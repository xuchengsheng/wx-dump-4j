// TopGroupChatsVO.java
package com.xcs.wx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopGroupChatsVO {
    private String groupName; // 群聊名称
    private int messageCount; // 这个群聊在过去5天内的消息数量
}
