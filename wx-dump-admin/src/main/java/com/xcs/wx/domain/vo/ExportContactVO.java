package com.xcs.wx.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import lombok.Data;

/**
 * ExportContactVO
 *
 * @author xcs
 * @date 2023年12月22日 14时43分
 **/
@Data
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER)
public class ExportContactVO {

    /**
     * 用户名
     */
    @ColumnWidth(25)
    @ExcelProperty("微信Id")
    private String userName;

    /**
     * 别名
     */
    @ColumnWidth(25)
    @ExcelProperty("微信号")
    private String alias;

    /**
     * 备注
     */
    @ColumnWidth(25)
    @ExcelProperty("备注")
    private String remark;

    /**
     * 昵称
     */
    @ColumnWidth(30)
    @ExcelProperty("昵称")
    private String nickName;

    /**
     * 描述
     */
    @ColumnWidth(25)
    @ExcelProperty("描述")
    private String describe;

    /**
     * 标签Id
     */
    @ColumnWidth(20)
    @ExcelProperty("标签Id")
    private String labelIdList;
}
