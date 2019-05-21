package com.ainsurtech.eureka.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @program: aicloud
 * @description:
 * @author: klovis
 * @create: 2019-05-21 19:28
 **/
public class XmlCDATAAdapter extends XmlAdapter<String, String> {
    private static final String CDATA_PRE = "<!CDATA[";
    private static final String CDATA_SUFFIX = "]]>";
    private static final String CDATA_EMPTY = CDATA_PRE + CDATA_SUFFIX;

    @Override
    public String marshal(String v) throws Exception {
        return CDATA_PRE + v + CDATA_SUFFIX;
    }

    @Override
    public String unmarshal(String v) throws Exception {
        if (CDATA_EMPTY.equals(v)) {
            return "";
        }
        if (v.startsWith(CDATA_PRE)) {
            return v.substring(CDATA_PRE.length(), v.length() - CDATA_SUFFIX.length());
        } else {
            return v;
        }
    }
}
