package com.xcs.wx.repository;

import com.xcs.wx.domain.FTSContactContent;
import com.xcs.wx.domain.dto.RecoverContactDTO;

import java.util.List;

/**
 * FTSContactContentRepository
 *
 * @author xcs
 * @date 2024年6月14日15:18:11
 **/
public interface FTSContactContentRepository {

    /**
     * 查询联系人
     *
     * @return FTSContactContent
     */
    List<FTSContactContent> queryContactContent(RecoverContactDTO recoverContactDTO);
}
