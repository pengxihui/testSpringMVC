/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年9月19日下午3:07:03 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.wx.menu;  

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 证书信任管理器（用于https请求）
 * 这个证书管理器的作用就是让它信任我们指定的证书，下面的代码意味着信任所有证书，不管是否权威机构颁发。
 * @author Richard_yyf
 *
 */
public class MyX509TrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}