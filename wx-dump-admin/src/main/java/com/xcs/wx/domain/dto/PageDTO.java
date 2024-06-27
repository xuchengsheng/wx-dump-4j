package com.xcs.wx.domain.dto;

import lombok.Data;

/**
 * PageDTO
 *
 * @author xcs
 * @date 2023年12月29日 15时58分
 **/
@Data
public class PageDTO {

    /**
     * 当前页数
     */
    private Long current;

    /**
     * 页数大小
     */
    private Long pageSize;
}
