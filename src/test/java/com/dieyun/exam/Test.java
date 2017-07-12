package com.dieyun.exam;

import com.dieyun.exam.util.HttpClientUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchao
 * @date 2017/7/11
 * @desc：
 */


public class Test {

    @org.junit.Test
    public void payRegist() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("businessNo","12345678");
        map.put("data","dMpwIBgNhy9XcLee8FyFrVDdYhjp9+MwqyYRYV8L7GM=");
        map.put("key","aZqtgluDnG7vcJMtAX6GnCs8gGmYxgKYPfTAx9ANRvgwqUfvEQTtW+Pb6Lt/h+HIeynXUWkpQAZIbkVRrmsUIOhGBOL+3ZaKxtRhC+w962og/SkxLXmKRoSZMfAvSbx8UN8LGL9pnNMcC6y1H6aHXyNf4MN+j33tkOmri6FTcUg=");
        try {
            String s = HttpClientUtil.httpPostRequest("http://localhost:8011/payRegist", map);
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void revokeregist() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("businessNo","12345678");
        map.put("data","{\"userid\":1000}");
        map.put("key","");
        map.put("encrypted","1");
        try {
            String s = HttpClientUtil.httpPostRequest("http://localhost:8011/revokeregist", map);
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
