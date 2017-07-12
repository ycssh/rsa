package com.dieyun.exam.vo;

import lombok.Data;

/**
 * @author yuchao
 * @date 2017/7/11
 * @desc：
 */
@Data
public class Business {
    //商家密钥，RSA加密用
    private String privateKey;
    //商家私钥，RSA加密用
    private String publicKey;
    //商家编号
    private String businessNo;
    //授权码，商家注册的时候生成的8位随机数并告知商家
    private String license;
}
