package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.baomidou.mybatisplus.core.batch.MybatisBatch;
import com.baomidou.mybatisplus.core.toolkit.MybatisBatchUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.Msg;
import com.xcs.wx.domain.vo.CountRecentMsgsVO;
import com.xcs.wx.domain.vo.MsgTypeDistributionVO;
import com.xcs.wx.domain.vo.TopContactsVO;
import com.xcs.wx.mapper.MsgMapper;
import com.xcs.wx.repository.MsgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * 消息 Repository 实现类
 *
 * @author xcs
 * @date 2023年12月25日 15时29分
 **/
@Slf4j
@Repository
@RequiredArgsConstructor
@DS(value = DataSourceType.MSG_DB)
public class MsgRepositoryImpl extends ServiceImpl<MsgMapper, Msg> implements MsgRepository {

    private final TransactionTemplate transactionTemplate;
    private final SqlSessionFactory sqlSessionFactory;

    @Override
    public Long getNextSequence(String poolName) {
        // 切换数据源
        DynamicDataSourceContextHolder.push(poolName);
        // 获得最大的序列号
        Long nextSequence = getBaseMapper().getNextSequence();
        // 清理动态数据源
        DynamicDataSourceContextHolder.clear();
        // 返回数据
        return nextSequence;
    }

    @Override
    public List<Msg> queryMsgBySequence(String poolName, Long nextSequence) {
        log.info("开始查询数据:[{}][{}]", poolName, nextSequence);
        // 切换数据源
        DynamicDataSourceContextHolder.push(poolName);
        // 根据数量与序列号获取消息
        List<Msg> msgs = getBaseMapper().queryMsgBySequence(nextSequence);
        // 清理动态数据源
        DynamicDataSourceContextHolder.clear();
        log.info("结束查询数据:[{}][{}]", poolName, nextSequence);
        // 返回数据
        return msgs;
    }

    @Override
    public boolean saveBatch(String poolName, List<Msg> msg) {
        log.info("开始新增数据:[{}][{}]", poolName, msg.size());
        // 切换数据源
        DynamicDataSourceContextHolder.push(poolName);
        // 批量执行
        transactionTemplate.execute(status -> {
            MybatisBatch.Method<Msg> mapperMethod = new MybatisBatch.Method<>(MsgMapper.class);
            return MybatisBatchUtils.execute(sqlSessionFactory, msg, mapperMethod.insert());
        });
        // 清理动态数据源
        DynamicDataSourceContextHolder.clear();
        log.info("结束新增数据:[{}][{}]", poolName, msg.size());
        // 返回数据
        return true;
    }

    @Override
    public List<Msg> queryMsgByTalker(String talker, Long lastCreateTime) {
        return super.list(Wrappers.<Msg>lambdaQuery()
                .eq(Msg::getStrTalker, talker)
                .lt(Msg::getCreateTime, lastCreateTime)
                .ne(Msg::getType, 11000)
                .orderByDesc(Msg::getCreateTime)
                .last("limit 20"));
    }

    @Override
    public List<Msg> exportMsg(String talker) {
        return super.list(Wrappers.<Msg>lambdaQuery()
                .eq(Msg::getStrTalker, talker)
                .ne(Msg::getType, 11000)
                .orderByDesc(Msg::getCreateTime));
    }

    @Override
    public List<MsgTypeDistributionVO> msgTypeDistribution() {
        return super.getBaseMapper().msgTypeDistribution();
    }

    @Override
    public List<CountRecentMsgsVO> countRecentMsgs() {
        return super.getBaseMapper().countRecentMsgs();
    }

    @Override
    public List<TopContactsVO> topContacts() {
        return super.getBaseMapper().topContacts();
    }

    @Override
    public int countSent() {
        return getBaseMapper().countSent();
    }

    @Override
    public int countReceived() {
        return getBaseMapper().countReceived();
    }
}
