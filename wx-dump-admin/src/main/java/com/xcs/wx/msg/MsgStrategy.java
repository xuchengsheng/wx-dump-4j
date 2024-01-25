package com.xcs.wx.msg;

import com.xcs.wx.domain.vo.MsgVO;

/**
 * @author xcs
 * @date 2024年01月24日 11时44分
 **/
public interface MsgStrategy {

    /**
     * 是否支持该策略
     *
     * @param type    类型
     * @param subType 子类型
     * @return 是否支持
     */
    boolean support(Integer type, Integer subType);

    /**
     * 处理消息
     *
     * @param msgVO 参数
     */
    void process(MsgVO msgVO);
}
