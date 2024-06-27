package com.xcs.wx.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import lombok.Data;

/**
 * ExportChatRoomVO
 *
 * @author xcs
 * @date 2024年01月08日 16时10分
 **/
@Data
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER)
public class ExportChatRoomVO {

    /**
     * 群号
     */
    @ColumnWidth(25)
    @ExcelProperty("群号")
    private String chatRoomName;

    /**
     * 群聊名称
     */
    @ColumnWidth(25)
    @ExcelProperty("群聊名称")
    private String chatRoomTitle;

    /**
     * 备注
     */
    @ColumnWidth(25)
    @ExcelProperty("备注")
    private String selfDisplayName;

    /**
     * 创建人
     */
    @ColumnWidth(25)
    @ExcelProperty("创建人")
    private String createBy;

    /**
     * 群聊是否已经解散
     */
    @ColumnWidth(25)
    @ExcelProperty("群聊是否已经解散")
    private Boolean dissolution;

    /**
     * 是否为企业微信群
     */
    @ColumnWidth(25)
    @ExcelProperty("是否为企业微信群")
    private Boolean enterprise;

    /**
     * 群聊数据
     */
    @ExcelIgnore
    private byte[] roomData;

    /**
     * 群聊人数
     */
    @ColumnWidth(25)
    @ExcelProperty("群聊人数")
    private Integer memberCount;
}
