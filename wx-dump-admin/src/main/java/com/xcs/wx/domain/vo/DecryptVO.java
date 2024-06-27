package com.xcs.wx.domain.vo;

import lombok.Builder;
import lombok.Data;

/**
 * DecryptVO
 *
 * @author xcs
 * @date 2023年12月21日 18时13分
 **/
@Data
@Builder
public class DecryptVO {

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 当前进度
     */
    private int currentProgress;

    /**
     * 总数量
     */
    private int total;
}
