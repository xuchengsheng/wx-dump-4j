package com.xcs.wx.msg;

import cn.hutool.extra.spring.SpringUtil;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xcs
 * @date 2024年01月24日 15时55分
 **/
public class MsgStrategyFactory {

    private MsgStrategyFactory(){}

    /**
     * 获取策略
     *
     * @param type    类型
     * @param subType 子类型
     * @return MsgStrategy
     */
   public static MsgStrategy getStrategy(Integer type, Integer subType) {
        // 从Spring中获取所有的策略
        Map<String, MsgStrategy> msgStrategyList = SpringUtil.getBeansOfType(MsgStrategy.class);
        // 查找到的策略
        AtomicReference<MsgStrategy> findMsgStrategy = new AtomicReference<>();
        // 遍历
        msgStrategyList.forEach((key, msgStrategy) -> {
            // 查找是否支持该策略
            if (msgStrategy.support(type, subType)) {
                findMsgStrategy.set(msgStrategy);
            }
        });
        // 返回
        return findMsgStrategy.get();
    }
}
