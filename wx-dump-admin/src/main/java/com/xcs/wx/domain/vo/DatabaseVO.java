package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * @author xcs
 * @date 2023年12月21日 18时13分
 **/
@Data
public class DatabaseVO {

    private String dbName;

    private String dbPath;

    private String status;

    private String desc;

    private String lastSyncTime;
}
