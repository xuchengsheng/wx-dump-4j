package com.xcs.wx.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * 时间格式化工具类
 *
 * @author xcs
 * @date 2023年12月27日 16时06分
 **/
public class DateFormatUtil {

    /**
     * 格式化时间戳
     *
     * @param timestampInSeconds 时间戳（以秒为单位）
     * @return 格式化后的时间字符串
     */
    public static String formatTimestamp(long timestampInSeconds) {
        // 将秒转换为毫秒
        DateTime dateTime = new DateTime(timestampInSeconds * 1000);
        DateTime now = DateUtil.date();

        // 如果是今天
        if (DateUtil.isSameDay(dateTime, now)) {
            return DateUtil.format(dateTime, "H:mm");
        }

        // 如果是昨天
        if (DateUtil.isSameDay(dateTime, DateUtil.yesterday())) {
            return "昨天";
        }

        // 如果是本周（而不是昨天）
        if (dateTime.isAfterOrEquals(DateUtil.beginOfWeek(now)) && DateUtil.isSameWeek(dateTime, now, true)) {
            return DateUtil.dayOfWeekEnum(dateTime).toChinese("周");
        }

        // 如果不是本年
        if (dateTime.year() != now.year()) {
            return DateUtil.format(dateTime, "yy年M月d日");
        }

        // 如果都不是，则显示月日
        return DateUtil.format(dateTime, "M月d日");
    }
}
