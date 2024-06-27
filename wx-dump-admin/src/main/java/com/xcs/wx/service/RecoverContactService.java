package com.xcs.wx.service;

import com.xcs.wx.domain.dto.RecoverContactDTO;
import com.xcs.wx.domain.vo.RecoverContactVO;

import java.util.List;

/**
 * 找回联系人服务
 *
 * @author xcs
 * @date 2024年6月14日15:28:11
 */
public interface RecoverContactService {

    /**
     * 找回好友
     *
     * @return RecoverContactVO
     */
    List<RecoverContactVO> queryRecoverContact(RecoverContactDTO recoverContactDTO);

    /**
     * 删除已删除的好友
     *
     * @return 地址
     */
    String exportRecoverContact();
}
