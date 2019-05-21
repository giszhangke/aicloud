package com.ainsurtech.eureka.xml;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * http://www.it610.com/article/34291.htm
 *
 * @program: aicloud
 * @description:
 * @author: klovis
 * @create: 2019-05-21 18:41
 **/
@Slf4j
public class XMLConvert {
    @Test
    public void serialize() throws JAXBException {
        String encoding = "GBK";
        TestObject object = TestObject.builder().returnCode("000").returnMsg("asdfas").build();
        JAXBContext jaxbContext = JAXBContext.newInstance(TestObject.class);
        StringWriter stringWriter = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        //去掉生成xml的默认报文头。
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
        //转换所有的适配字符，包括xml实体字符&lt;和&gt;，xml实体字符在好多处理xml
        //的框架中是处理不了的，除非序列化。
        marshaller.setProperty("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler",
                new CharacterEscapeHandler() {
                    @Override
                    public void escape(char[] ch, int start,int length, boolean isAttVal,
                                       Writer writer) throws IOException {
                        writer.write(ch, start, length);
                    }
                });
        marshaller.marshal(object, stringWriter);
        String xmlString = stringWriter.toString();
        log.info(xmlString);
    }
}
