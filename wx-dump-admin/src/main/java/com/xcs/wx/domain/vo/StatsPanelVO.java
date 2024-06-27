package com.xcs.wx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * StatsPanelVO
 *
 * @author xcs
 * @date 2024年01月23日 17时25分
 **/
@Data
@AllArgsConstructor
public class StatsPanelVO {

    /**
     * 联系人数量
     */
    private Integer contact;

    /**
     * 群聊数量
     */
    private Integer chatRoom;

    /**
     * 今日发送消息数量
     */
    private Integer sent;

    /**
     * 今日接受消息数量
     */
    private Integer received;
}
