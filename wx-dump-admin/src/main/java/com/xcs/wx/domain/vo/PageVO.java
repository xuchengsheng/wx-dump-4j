package com.xcs.wx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * PageVO
 *
 * @author xcs
 * @date 2023年12月29日 16时19分
 **/
@Data
@AllArgsConstructor
public class PageVO<T> {

    /**
     * 当前页数
     */
    private Long current;

    /**
     * 页数大小
     */
    private Long pageSize;

    /**
     * 总页数
     */
    private Long total;

    /**
     * 查询条件
     */
    private List<T> records;
}
