package com.ainsurtech.eureka.xml;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

/**
 * @program: aicloud
 * @description:
 * @author: klovis
 * @create: 2019-05-21 18:41
 **/
@Data
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TestObject implements Serializable {
    public TestObject() {}

    public TestObject(String returnMsg, String returnCode) {
        this.returnMsg = returnMsg;
        this.returnCode = returnCode;
    }

    @XmlJavaTypeAdapter(XmlCDATAAdapter.class)
    @XmlElement(name = "return_msg")
    private String returnMsg;
    @XmlElement(name = "return_code")
    private String returnCode;


}
