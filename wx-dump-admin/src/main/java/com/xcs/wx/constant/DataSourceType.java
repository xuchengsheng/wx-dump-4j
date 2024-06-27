package com.xcs.wx.constant;

import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.xcs.wx.service.UserService;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据源类型枚举
 *
 * @author xcs
 * @date 2023年12月25日 16时41分
 **/
public class DataSourceType {

    public static final String APPLET_DB = "Applet.db";
    public static final String BIZ_CHAT_DB = "BizChat.db";
    public static final String BIZ_CHAT_MSG_DB = "BizChatMsg.db";
    public static final String CHAT_MSG_DB = "ChatMsg.db";
    public static final String CHAT_ROOM_USER_DB = "ChatRoomUser.db";
    public static final String CLIENT_CONFIG_DB = "ClientConfig.db";
    public static final String CLIENT_GENERAL_DB = "ClientGeneral.db";
    public static final String CUSTOMER_SERVICE_DB = "CustomerService.db";
    public static final String EMOTION_DB = "Emotion.db";
    public static final String FAVORITE_DB = "Favorite.db";
    public static final String FTS_CONTACT_DB = "FTSContact.db";
    public static final String FTS_FAVORITE_DB = "FTSFavorite.db";
    public static final String FTS_MSG_DB = "FTSMsg.db";
    public static final String FUNCTION_MSG_DB = "FunctionMsg.db";
    public static final String HARD_LINK_FILE_DB = "HardLinkFile.db";
    public static final String HARD_LINK_IMAGE_DB = "HardLinkImage.db";
    public static final String HARD_LINK_VIDEO_DB = "HardLinkVideo.db";
    public static final String IMAGE_TRANSLATE_DB = "ImageTranslate.db";
    public static final String LINK_HISTORY_DB = "LinkHistory.db";
    public static final String MEDIA_DB = "Media.db";
    public static final String MICRO_MSG_DB = "MicroMsg.db";
    public static final String MISC_DB = "Misc.db";
    public static final String MULTI_SEARCH_CHAT_MSG_DB = "MultiSearchChatMsg.db";
    public static final String NEW_TIPS_DB = "NewTips.db";
    public static final String OPEN_IM_CONTACT_DB = "OpenIMContact.db";
    public static final String OPEN_IM_MEDIA_DB = "OpenIMMedia.db";
    public static final String OPEN_IM_MSG_DB = "OpenIMMsg.db";
    public static final String OPEN_IM_RESOURCE_DB = "OpenIMResource.db";
    public static final String PRE_DOWNLOAD_DB = "PreDownload.db";
    public static final String PUBLIC_MSG_DB = "PublicMsg.db";
    public static final String PUBLIC_MSG_MEDIA_DB = "PublicMsgMedia.db";
    public static final String SNS_DB = "Sns.db";
    public static final String STORE_EMOTION_DB = "StoreEmotion.db";
    public static final String VOIP_DB = "Voip.db";
    public static final String MSG_DB = "MSG.db";
    public static final String MSG0_DB = "MSG0.db";

    /**
     * 读取MSG*.db
     *
     * @return 数据库名称
     */
    public static List<String> getMsgDb() {
        String wxId = SpringUtil.getBean(UserService.class).currentUser();
        // 空校验
        if (wxId == null) {
            return Collections.emptyList();
        }
        return getDb(wxId + "#" + "MSG.*\\.db");
    }

    /**
     * 根据pattern匹配数据库
     *
     * @param pattern 需要匹配的字符串
     * @return 数据库名称
     */
    private static List<String> getDb(String pattern) {
        // 获取动态数据源
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringUtil.getBean(DynamicRoutingDataSource.class);
        // 获取所有数据源
        Map<String, DataSource> dataSources = dynamicRoutingDataSource.getDataSources();

        // 筛选出符合模式的数据源键，并进行降序排序
        return dataSources.keySet().stream()
                .filter(key -> key.matches(pattern))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
