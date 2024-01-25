package com.xcs.wx.domain.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @author xcs
 * @date 2024年01月16日 14时59分
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "msg")
public class MsgBO {

    @JacksonXmlProperty(localName = "img")
    public Img img;

    @JacksonXmlProperty(localName = "emoji")
    private Emoji emoji;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Img {
        @JacksonXmlProperty(isAttribute = true, localName = "aeskey")
        public String aesKey;

        @JacksonXmlProperty(isAttribute = true, localName = "encryver")
        public String encryVer;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnthumbaeskey")
        public String cdnThumbAesKey;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnthumburl")
        public String cdnThumbUrl;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnthumblength")
        public int cdnThumbLength;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnthumbheight")
        public int cdnThumbHeight;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnthumbwidth")
        public int cdnThumbWidth;

        @JacksonXmlProperty(isAttribute = true,localName = "cdnmidheight")
        public int cdnMidHeight;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnmidwidth")
        public int cdnMidWidth;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnhdheight")
        public int cdnHdHeight;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnhdwidth")
        public int cdnHdWidth;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnmidimgurl")
        public String cdnMidImgUrl;

        @JacksonXmlProperty(isAttribute = true, localName = "length")
        public int length;

        @JacksonXmlProperty(isAttribute = true, localName = "md5")
        public String md5;

        @JacksonXmlProperty(isAttribute = true, localName = "hevc_mid_size")
        public int hevcMidSize;

        @JacksonXmlProperty(isAttribute = true, localName = "originsourcemd5")
        public String originSourceMd5;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Emoji {

        @JacksonXmlProperty(isAttribute = true, localName = "fromusername")
        private String fromUsername;

        @JacksonXmlProperty(isAttribute = true, localName = "tousername")
        private String toUsername;

        @JacksonXmlProperty(isAttribute = true, localName = "type")
        private String type;

        @JacksonXmlProperty(isAttribute = true, localName = "idbuffer")
        private String idBuffer;

        @JacksonXmlProperty(isAttribute = true, localName = "md5")
        private String md5;

        @JacksonXmlProperty(isAttribute = true, localName = "len")
        private String len;

        @JacksonXmlProperty(isAttribute = true, localName = "productid")
        private String productId;

        @JacksonXmlProperty(isAttribute = true, localName = "androidmd5")
        private String androidMd5;

        @JacksonXmlProperty(isAttribute = true, localName = "androidlen")
        private String androidLen;

        @JacksonXmlProperty(isAttribute = true, localName = "s60v3md5")
        private String s60v3Md5;

        @JacksonXmlProperty(isAttribute = true, localName = "s60v3len")
        private String s60v3Len;

        @JacksonXmlProperty(isAttribute = true, localName = "s60v5md5")
        private String s60v5Md5;

        @JacksonXmlProperty(isAttribute = true, localName = "s60v5len")
        private String s60v5Len;

        @JacksonXmlProperty(isAttribute = true, localName = "cdnurl")
        private String cdnUrl;

        @JacksonXmlProperty(isAttribute = true, localName = "designerid")
        private String designerId;

        @JacksonXmlProperty(isAttribute = true, localName = "thumburl")
        private String thumbUrl;

        @JacksonXmlProperty(isAttribute = true, localName = "encrypturl")
        private String encryptUrl;

        @JacksonXmlProperty(isAttribute = true, localName = "aeskey")
        private String aesKey;

        @JacksonXmlProperty(isAttribute = true, localName = "externurl")
        private String externUrl;

        @JacksonXmlProperty(isAttribute = true, localName = "externmd5")
        private String externMd5;

        @JacksonXmlProperty(isAttribute = true, localName = "width")
        private String width;

        @JacksonXmlProperty(isAttribute = true, localName = "height")
        private String height;

        @JacksonXmlProperty(isAttribute = true, localName = "tpurl")
        private String tpUrl;

        @JacksonXmlProperty(isAttribute = true, localName = "tpauthkey")
        private String tpAuthKey;

        @JacksonXmlProperty(isAttribute = true, localName = "attachedtext")
        private String attachedText;

        @JacksonXmlProperty(isAttribute = true, localName = "attachedtextcolor")
        private String attachedTextColor;

        @JacksonXmlProperty(isAttribute = true, localName = "lensid")
        private String lensId;

        @JacksonXmlProperty(isAttribute = true, localName = "emojiattr")
        private String emojiAttr;

        @JacksonXmlProperty(isAttribute = true, localName = "linkid")
        private String linkId;

        @JacksonXmlProperty(isAttribute = true, localName = "desc")
        private String desc;
    }
}
