package com.xcs.wx.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.domain.SqliteMaster;
import com.xcs.wx.mapper.SqliteMasterMapper;
import com.xcs.wx.repository.SqliteMasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SqliteMasterRepositoryImpl extends ServiceImpl<SqliteMasterMapper, SqliteMaster> implements SqliteMasterRepository {

    @Override
    public boolean isTableExists(String tableName) {
        LambdaQueryWrapper<SqliteMaster> wrapper = Wrappers.<SqliteMaster>lambdaQuery()
                .eq(SqliteMaster::getType, "table")
                .eq(SqliteMaster::getTblName, tableName);
        return super.count(wrapper) > 0;
    }
}
