package com.xcs.wx.domain.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

import java.util.List;

/**
 * TimelineObjectBO
 *
 * @author xcs
 * @date 2024年01月03日 17时47分
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "TimelineObject")
public class TimelineObjectBO {

    @JacksonXmlProperty(localName = "id")
    private String id;

    @JacksonXmlProperty(localName = "username")
    private String username;

    @JacksonXmlProperty(localName = "createTime")
    private Long createTime;

    @JacksonXmlProperty(localName = "contentDesc")
    private String contentDesc;

    @JacksonXmlProperty(localName = "contentDescShowType")
    private String contentDescShowType;

    @JacksonXmlProperty(localName = "contentDescScene")
    private String contentDescScene;

    @JacksonXmlProperty(localName = "private")
    private String asPrivate;

    @JacksonXmlProperty(localName = "sightFolded")
    private String sightFolded;

    @JacksonXmlProperty(localName = "showFlag")
    private String showFlag;

    @JacksonXmlProperty(localName = "appInfo")
    private AppInfo appInfo;

    @JacksonXmlProperty(localName = "sourceUserName")
    private String sourceUserName;

    @JacksonXmlProperty(localName = "sourceNickName")
    private String sourceNickName;

    @JacksonXmlProperty(localName = "statisticsData")
    private String statisticsData;

    @JacksonXmlProperty(localName = "statExtStr")
    private String statExtStr;

    @JacksonXmlProperty(localName = "ContentObject")
    private ContentObject contentObject;

    @JacksonXmlProperty(localName = "publicUserName")
    private String publicUserName;

    @JacksonXmlProperty(localName = "location")
    private Location location;

    @JacksonXmlProperty(localName = "streamvideo")
    private StreamVideo streamVideo;

    /**
     * AppInfo
     */
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AppInfo {
        @JacksonXmlProperty(localName = "id")
        private String id;

        @JacksonXmlProperty(localName = "version")
        private String version;

        @JacksonXmlProperty(localName = "appName")
        private String appName;

        @JacksonXmlProperty(localName = "installUrl")
        private String installUrl;

        @JacksonXmlProperty(localName = "fromUrl")
        private String fromUrl;

        @JacksonXmlProperty(localName = "isForceUpdate")
        private String isForceUpdate;

        @JacksonXmlProperty(localName = "isHidden")
        private String isHidden;
    }

    /**
     * ContentObject
     */
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContentObject {
        @JacksonXmlProperty(localName = "contentStyle")
        private Integer contentStyle;

        @JacksonXmlProperty(localName = "description")
        private String description;

        @JacksonXmlProperty(localName = "title")
        private String title;

        @JacksonXmlProperty(localName = "contentUrl")
        private String contentUrl;

        @JacksonXmlProperty(localName = "mediaList")
        private List<Media> mediaList;

        /**
         * Media
         */
        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Media {
            @JacksonXmlProperty(localName = "id")
            private String id;

            @JacksonXmlProperty(localName = "type")
            private String type;

            @JacksonXmlProperty(localName = "title")
            private String title;

            @JacksonXmlProperty(localName = "description")
            private String description;

            @JacksonXmlProperty(localName = "private")
            private String asPrivate;

            @JacksonXmlProperty(localName = "userData")
            private String userData;

            @JacksonXmlProperty(localName = "subType")
            private String subType;

            @JacksonXmlProperty(localName = "videoSize")
            private String videoSize;

            @JacksonXmlProperty(localName = "url")
            private Url url;

            @JacksonXmlProperty(localName = "thumb")
            private Thumb thumb;

            @JacksonXmlProperty(localName = "size")
            private String size;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Url {
            @JacksonXmlProperty(isAttribute = true)
            private int type;

            @JacksonXmlProperty(isAttribute = true)
            private String md5;

            @JacksonXmlProperty(isAttribute = true)
            private String videomd5;

            @JacksonXmlText
            private String value;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Thumb {
            @JacksonXmlProperty(isAttribute = true)
            private int type;

            @JacksonXmlText
            private String value;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        @JacksonXmlProperty(isAttribute = true, localName = "poiClassifyId")
        private String poiClassifyId;

        @JacksonXmlProperty(isAttribute = true, localName = "poiName")
        private String poiName;

        @JacksonXmlProperty(isAttribute = true, localName = "poiAddress")
        private String poiAddress;

        @JacksonXmlProperty(isAttribute = true, localName = "poiClassifyType")
        private Integer poiClassifyType;

        @JacksonXmlProperty(isAttribute = true, localName = "city")
        private String city;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StreamVideo {
        @JacksonXmlProperty(localName = "streamvideourl")
        private String streamVideoUrl;

        @JacksonXmlProperty(localName = "streamvideothumburl")
        private String streamVideoThumbUrl;

        @JacksonXmlProperty(localName = "streamvideoweburl")
        private String streamVideoWebUrl;
    }
}
