package com.xcs.wx.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjUtil;
import com.xcs.wx.domain.bo.TimelineObjectBO;
import com.xcs.wx.domain.dto.FeedsDTO;
import com.xcs.wx.domain.vo.FeedsLocationVO;
import com.xcs.wx.domain.vo.FeedsMediaVO;
import com.xcs.wx.domain.vo.FeedsVO;
import com.xcs.wx.domain.vo.PageVO;
import com.xcs.wx.mapping.FeedsMapping;
import com.xcs.wx.repository.*;
import com.xcs.wx.service.FeedsService;
import com.xcs.wx.util.XmlUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 朋友圈服务实现
 *
 * @author xcs
 * @date 2024年1月3日17:25:26
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FeedsServiceImpl implements FeedsService {

    private final FeedsRepository feedsRepository;
    private final FeedsMapping feedsMapping;
    private final ContactRepository contactRepository;
    private final ContactHeadImgUrlRepository contactHeadImgUrlRepository;
    private final HardLinkVideoAttributeRepository hardLinkVideoAttributeRepository;
    private final HardLinkImageAttributeRepository hardLinkImageAttributeRepository;

    @Override
    public PageVO<FeedsVO> queryFeeds(FeedsDTO feedsDTO) {
        // 查询朋友圈
        return Optional.ofNullable(feedsRepository.queryFeeds(feedsDTO))
                // 处理头像并转换参数
                .map(pageResult -> {
                    // 转换参数
                    List<FeedsVO> feedsVos = feedsMapping.convert(pageResult.getRecords())
                            // 转换成流
                            .stream()
                            // 解析Content里面的XML
                            .map(feedsVO -> {
                                TimelineObjectBO timelineObjectBO = parseXmlToObj(feedsVO.getContent());
                                // 空校验
                                if (timelineObjectBO == null) {
                                    return feedsVO;
                                }
                                // 设置内容描述
                                feedsVO.setContentDesc(timelineObjectBO.getContentDesc());
                                // 设置媒体内容
                                feedsVO.setMedias(getMedia(timelineObjectBO));
                                // 设置地址
                                feedsVO.setLocation(getLocation(timelineObjectBO));
                                return feedsVO;
                            })
                            // 处理日期
                            .peek(feedsVO -> {
                                // 转换日期
                                String strCreateTime = DateUtil.formatDateTime(new Date(feedsVO.getCreateTime() * 1000L));
                                // 设置日期
                                feedsVO.setStrCreateTime(strCreateTime);
                            })
                            // 处理联系人名称
                            .peek(feedsVO -> {
                                // 查询用户名
                                String nickname = contactRepository.getContactNickname(feedsVO.getUserName());
                                // 设置用户名
                                feedsVO.setNickName(nickname);
                            })
                            // 处理联系人头像
                            .peek(feedsVO -> {
                                // 联系人头像
                                String headImgUrl = contactHeadImgUrlRepository.queryHeadImgUrlByUserName(feedsVO.getUserName());
                                // 设置联系人头像
                                feedsVO.setHeadImgUrl(headImgUrl);
                            })
                            // 转换成List
                            .collect(Collectors.toList());
                    // 返回分页数据
                    return new PageVO<>(pageResult.getCurrent(), pageResult.getSize(), pageResult.getTotal(), feedsVos);
                })
                // 默认值
                .orElse(new PageVO<>(feedsDTO.getCurrent(), feedsDTO.getPageSize(), 0L, null));
    }

    /**
     * 获取媒体内容
     *
     * @param timelineObjectBO 参数
     * @return FeedsMediaVO
     */
    private List<FeedsMediaVO> getMedia(TimelineObjectBO timelineObjectBO) {
        List<FeedsMediaVO> feedsMediaVos = new ArrayList<>();

        // 获取媒体
        List<TimelineObjectBO.ContentObject.Media> mediaList = timelineObjectBO.getContentObject().getMediaList();

        if (CollUtil.isEmpty(mediaList)) {
            return feedsMediaVos;
        }

        for (TimelineObjectBO.ContentObject.Media media : mediaList) {
            FeedsMediaVO feedsMediaVo = new FeedsMediaVO();
            feedsMediaVo.setUrl(media.getUrl().getValue());
            feedsMediaVo.setThumb(media.getThumb().getValue());
            feedsMediaVos.add(feedsMediaVo);
        }
        return feedsMediaVos;
    }

    /**
     * 获取地址
     *
     * @param timelineObjectBO 参数
     * @return FeedsLocationVO
     */
    private FeedsLocationVO getLocation(TimelineObjectBO timelineObjectBO) {
        TimelineObjectBO.Location location = timelineObjectBO.getLocation();
        // 空校验
        if (ObjUtil.isNotEmpty(location)) {
            FeedsLocationVO feedsLocationVO = new FeedsLocationVO();
            feedsLocationVO.setCity(location.getCity());
            feedsLocationVO.setPoiAddress(location.getPoiAddress());
            feedsLocationVO.setPoiClassifyId(location.getPoiClassifyId());
            feedsLocationVO.setPoiName(location.getPoiName());
            feedsLocationVO.setPoiClassifyType(location.getPoiClassifyType());
            return feedsLocationVO;
        }
        return null;
    }

    /**
     * 将xml转换成对象
     *
     * @param xml xml内容
     * @return TimelineObjectBO
     */
    private TimelineObjectBO parseXmlToObj(String xml) {
        try {
            xml = xml.replace("&#x2;", "");
            xml = xml.replace("&#x02;", "");
            return XmlUtil.parseXml(xml, TimelineObjectBO.class);
        } catch (Exception e) {
            log.error("parse xml to obj fail", e);
        }
        return null;
    }
}
