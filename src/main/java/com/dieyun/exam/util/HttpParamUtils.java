package com.dieyun.exam.util;

import com.dieyun.exam.vo.Business;
import com.dieyun.exam.vo.InitData;
import com.dieyun.exam.vo.RequestVo;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchao
 * @date 2017/7/11
 * @desc：
 *
 * 工具类用于解密商家的请求参数，商家请求参数格式规定如下，json格式，只接受post请求：
 * {
 *     "key":"",
 *     "data":"",
 *     "businessNo":""
 *     "encrypted":1
 * }
 * key：用户生成一个随机的8位字符串+商家授权码 构成一个16位的字符串，
 *         用商家的密钥RSA(私钥)方式加密这个16位的字符串
 * data:商家请求的参数，用第一步生成的key来AES（128位）加密,如请求参数params为{id:1,name:123},则data值为AES.encrypt(params,key)的结果
 * businessNo:商家编号，用于服务器判断是哪个商家调用此接口
 * encrypted是否加密，1加密，0不加密，默认为1，可以不填写，测试阶段可以是0，上线之后为1
 */
public class HttpParamUtils {
    public static Map<String, String> getParams(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> params = new HashMap<String, String>();
        Enumeration<String> names = request.getParameterNames();
        System.out.println(request.getParameter("key"));
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getParameter(name);
            map.put(name.trim(),value.trim());
        }
        if(StringUtils.hasLength(map.get("encrypted"))&&"0".equals(map.get("encrypted"))){
            //TODO 测试阶段，上线的时候删除此判断，必须加密
            //不加密方式：直接处理data参数
            Map<String, Object> stringObjectMap = JsonUtils.parseMap(map.get("data"));
            for(Map.Entry<String,Object> entry:stringObjectMap.entrySet()){
                params.put(entry.getKey(),entry.getValue()==null?null:entry.getValue().toString());
            }
        }else{
            Business business = InitData.getBusiness(map.get("businessNo"));
            //用公钥解密key的值
            String aesKey = RSA.decryptByPublicKey(map.get("key"), business.getPublicKey());
            if(!aesKey.endsWith(business.getLicense())){
                throw new Exception("请求参数解析错误");
            }
            //解密aes加密的data部分
            String data = AES.decryptFromBase64(map.get("data"), aesKey);
            Map<String, Object> stringObjectMap = JsonUtils.parseMap(data);
            for(Map.Entry<String,Object> entry:stringObjectMap.entrySet()){
                params.put(entry.getKey(),entry.getValue()==null?null:entry.getValue().toString());
            }
        }
        return params;
    }

    public static Map<String,String> getParams(RequestVo requestVo) throws Exception{
        if(StringUtils.hasLength(requestVo.getEncrypted())&&"0".equals(requestVo.getEncrypted())){
            //TODO 测试阶段，上线的时候删除此判断，必须加密
            //不加密方式：直接处理data参数
            Map<String, Object> stringObjectMap = JsonUtils.parseMap(requestVo.getData());
            Map<String, String> params = new HashMap<String, String>();
            for(Map.Entry<String,Object> entry:stringObjectMap.entrySet()){
                params.put(entry.getKey(),entry.getValue()==null?null:entry.getValue().toString());
            }
            return params;
        }

        Business business = InitData.getBusiness(requestVo.getBusinessNo());
        //用公钥解密key的值
        String aesKey = RSA.decryptByPublicKey(requestVo.getKey(), business.getPublicKey());
        if(!aesKey.endsWith(business.getLicense())){
            throw new Exception("请求参数解析错误");
        }
        //解密aes加密的data部分
        String data = AES.decryptFromBase64(requestVo.getData(), aesKey);
        Map<String, Object> stringObjectMap = JsonUtils.parseMap(data);
        Map<String, String> params = new HashMap<String, String>();
        for(Map.Entry<String,Object> entry:stringObjectMap.entrySet()){
            params.put(entry.getKey(),entry.getValue()==null?null:entry.getValue().toString());
        }
        return params;
    }
}
