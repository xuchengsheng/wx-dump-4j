package com.xcs.wx.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * RecoverContactVO
 *
 * @author xcs
 * @date 2024年6月14日15:29:54
 **/
@Data
public class RecoverContactVO {

    /**
     * 本地唯一标识符，自增。
     */
    @ExcelIgnore
    private Integer docId;

    /**
     * alias
     */
    @ExcelProperty("微信号")
    @ColumnWidth(50)
    private String alias;

    /**
     * nickname
     */
    @ExcelProperty("昵称")
    @ColumnWidth(100)
    private String nickname;

    /**
     * c2remark
     */
    @ExcelProperty("备注")
    @ColumnWidth(100)
    private String remark;
}
