package com.xcs.wx.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * MsgVO
 *
 * @author xcs
 * @date 2023年12月22日 14时43分
 **/
@Data
public class MsgVO {

    /**
     * 本地唯一标识符，自增。
     */
    private Integer localId;

    /**
     * 消息服务器 ID
     */
    private String msgSvrId;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 消息子类型
     */
    private Integer subType;

    /**
     * 序列号
     */
    private Long sequence;

    /**
     * 是否为发送者
     */
    private Integer isSender;

    /**
     * 消息创建时间
     */
    private Long createTime;

    /**
     * 消息创建时间
     */
    private String strCreateTime;

    /**
     * 消息内容字符串
     */
    private String strContent;

    /**
     * 引用消息内容
     */
    private String referMsgContent;

    /**
     * 聊天者字符串
     */
    private String strTalker;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 图片地址Md5
     */
    private String imgMd5;

    /**
     * 图片缩略图
     */
    private String thumb;

    /**
     * 图片
     */
    private String image;

    /**
     * 表情Url
     */
    private String emojiUrl;

    /**
     * compressContent
     */
    @JsonIgnore
    private byte[] compressContent;

    /**
     * bytesExtra
     */
    @JsonIgnore
    private byte[] bytesExtra;

    /**
     * 小程序信息
     */
    private WeAppInfoVO weAppInfo;

    /**
     * 卡片链接
     */
    private CardLinkVO cardLink;

    /**
     * 聊天人Id
     */
    private String wxId;
}
