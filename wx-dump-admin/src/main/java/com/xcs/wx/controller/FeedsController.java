package com.xcs.wx.controller;

import com.xcs.wx.domain.dto.FeedsDTO;
import com.xcs.wx.domain.vo.FeedsVO;
import com.xcs.wx.domain.vo.PageVO;
import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.service.FeedsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 朋友圈  Controller
 *
 * @author xcs
 * @date 2024年01月04日 13时48分
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feeds")
public class FeedsController {

    private final FeedsService feedsService;

    /**
     * 查询朋友圈
     *
     * @param feedsDTO 请求参数
     * @return FeedsVO
     */
    @GetMapping("/list")
    public ResponseVO<List<FeedsVO>> list(FeedsDTO feedsDTO) {
        // 查询朋友圈
        PageVO<FeedsVO> pageVO = feedsService.queryFeeds(feedsDTO);
        // 返回数据
        return ResponseVO.ok(pageVO.getRecords(), pageVO.getCurrent(), pageVO.getTotal());
    }
}
