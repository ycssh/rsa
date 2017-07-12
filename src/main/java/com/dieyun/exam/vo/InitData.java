package com.dieyun.exam.vo;

import com.dieyun.exam.util.AES;
import com.dieyun.exam.util.RSA;

/**
 * @author yuchao
 * @date 2017/7/11
 * @desc：
 */
public class InitData {

    public static Business getBusiness(String businessNo){
        if("12345678".equals(businessNo)){
            Business business = new Business();
            business.setPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAILojrJiFLEERvyA0juwl2zNCFmFZ1bw+v6qQ+QiXHBXNTMRu32TXXjNqU8y98BWj8aPlut1WTjtWnmk/N3PdShxuXVW9zhUaei6XfAXYuKWVrvD8EiKhy4n8n6nVtHFImQA5Z0PXSrn1+nSwuAyT3r1CCbe4j8tGPMqh64YB6EVAgMBAAECgYBwWhX2hXVKw+gE2K8WqaYcrBAJfRRHKwXQQeOIzfDWPhKbpRFsYmjrwF8aaRz3h5NYEG6v4QRVdmibVH3uBRqAAaBEvsU0fvL7RA3YYA9+w/iUdDbixJ+IwPrYGW4gUqpxA+Wb5dqWki4z9k4GndSdUFn1VTZE93/RjFJWdVJuVQJBANFhnQvfr3diqfEH4wDkxA3nXWeysMbOW+AIkKTVkvKHQi9OJWzVaVujJgwHI3DlWVFssQtYjW5jrGtI5YxcANcCQQCgDh7Q/jSDL9xN2lRocxCYNoeDvFbJfwpORPFakWdheDFcLEnWSTyZYPZZQCZ08jwDq+RflbfamrW7LnDCuDPzAkByO2o97yTA4pBK0v2zIBwiZcbc621smWsgmCup8meAb/DY9C6Q6QHZH/KC/2YDku0e8kjJIt/OiQypX5T09cDzAkEAnzSMeKxzRY7E33fuABt8hTuwXlxoI3PHp4UyYjlCERUCXEH9jDY7HgHx6WNDHY6aHbjMqDt/ruW3ISKXrUiW+wJAEXBWRZmfnRWC0NofITa1VTPnRikqASL7DVSXXOjqOL5HCv0WueZ79hZxg0yw2H53SmBMASyUOSR+r1pa1tIxfg==d2ITkr1a4jsYSvjpy1O3SQ==");
            business.setPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCC6I6yYhSxBEb8gNI7sJdszQhZhWdW8Pr+qkPkIlxwVzUzEbt9k114zalPMvfAVo/Gj5brdVk47Vp5pPzdz3Uocbl1Vvc4VGnoul3wF2Lilla7w/BIiocuJ/J+p1bRxSJkAOWdD10q59fp0sLgMk969Qgm3uI/LRjzKoeuGAehFQIDAQAB");
            business.setLicense("c0ea2845");
            return business;
        }
        return null;
    }

    public static void main(String[] args) {
        String randomkey = "82c0c44b";
        Business business = getBusiness("12345678");
        String data = "{\"userid\":1000,\"hour\":100}";
        try {
            String entryKey = RSA.encryptByPrivateKey(randomkey + business.getLicense(), business.getPrivateKey());
            String entryData = AES.encryptToBase64(data, randomkey + business.getLicense());
            System.out.println(entryKey);
            System.out.println(entryData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
