package com.xcs.wx.domain.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * VoipMsgBO
 *
 * @author xcs
 * @date 2024年01月17日 15时15分
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "voipmsg")
public class VoipMsgBO {

    @JacksonXmlProperty(localName = "VoIPBubbleMsg")
    private VoIPBubbleMsg voIPBubbleMsg;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VoIPBubbleMsg {

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "msg")
        private String msg;
    }
}
