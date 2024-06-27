package com.xcs.wx.domain.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * CompressContentBO
 *
 * @author xcs
 * @date 2024年01月16日 14时59分
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "msg")
public class CompressContentBO {

    @JacksonXmlProperty(localName = "appmsg")
    private AppMsg appMsg;

    @JacksonXmlProperty(localName = "fromusername")
    private String fromUsername;

    @JacksonXmlProperty(localName = "scene")
    private int scene;

    @JacksonXmlProperty(localName = "appinfo")
    private AppInfo appInfo;

    @JacksonXmlProperty(localName = "titile")
    private String titile;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AppMsg {
        @JacksonXmlProperty(localName = "title")
        private String title;

        @JacksonXmlProperty(localName = "sourcedisplayname")
        private String sourceDisplayName;

        @JacksonXmlProperty(localName = "des")
        private String des;

        @JacksonXmlProperty(localName = "url")
        private String url;

        @JacksonXmlProperty(localName = "action")
        private String action;

        @JacksonXmlProperty(localName = "type")
        private int type;

        @JacksonXmlProperty(localName = "showtype")
        private int showType;

        @JacksonXmlProperty(localName = "refermsg")
        private ReferMsg referMsg;

        @JacksonXmlProperty(localName = "weappinfo")
        private WeAppInfo weAppInfo;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ReferMsg {
            @JacksonXmlProperty(localName = "type")
            private int type;

            @JacksonXmlProperty(localName = "svrid")
            private long svrId;

            @JacksonXmlProperty(localName = "fromusr")
            private String fromUsr;

            @JacksonXmlProperty(localName = "displayname")
            private String displayName;

            @JacksonXmlProperty(localName = "content")
            private String content;

            @JacksonXmlProperty(localName = "msgsource")
            private String msgSource;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class WeAppInfo {
            @JacksonXmlProperty(localName = "weappiconurl")
            private String weAppIconUrl;

            @JacksonXmlProperty(localName = "weapppagethumbrawurl")
            private String weAppPageThumbRawUrl;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AppInfo {
        @JacksonXmlProperty(localName = "version")
        private int version;

        @JacksonXmlProperty(localName = "appname")
        private String appName;
    }
}