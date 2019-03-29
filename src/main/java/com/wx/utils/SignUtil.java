/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年9月18日下午3:45:22 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.wx.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {

	private static String token = "pengxihui123";
	
	public static boolean checkSignature(String signature,String timestamp,String nonce) {
	    String checktext = null;
	    if(signature != null) {
	    	//对Token,timestamp,nonce 按字典排序
	    	String[] paramArr = new String[] {token,timestamp,nonce};
	    	Arrays.sort(paramArr);
	    	//将排序后的结果拼成一个字符串
	    	String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);
	    	try {
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				//对拼接后的字符串进行sha1加密
				byte[] digest = md.digest(content.toString().getBytes());
				checktext = byteToStr(digest);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
	    }
	    //将加密后的字符串与signature进行对比
	    return checktext != null ? checktext.equals(signature.toUpperCase()):false;
	}
	
	 /**
     * 将字节数组转化我16进制字符串
     * @param byteArrays 字符数组
     * @return 字符串
     */
    private static String byteToStr(byte[] byteArrays){
        String str = "";
        for (int i = 0; i < byteArrays.length; i++) {
            str += byteToHexStr(byteArrays[i]);
        }
        return str;
    }
    
    /**
     *  将字节转化为十六进制字符串
     * @param myByte 字节
     * @return 字符串
     */
    private static String byteToHexStr(byte myByte) {
        char[] Digit = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] tampArr = new char[2];
        tampArr[0] = Digit[(myByte >>> 4) & 0X0F];
        tampArr[1] = Digit[myByte & 0X0F];
        String str = new String(tampArr);
        return str;
    }
}
  