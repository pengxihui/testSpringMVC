/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年9月19日下午3:56:51 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.wx.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * description: 解析请求的消息xml
 * Date:2018年9月19日下午3:56:59
 */
public class MessageUtil {

	public static Map<String,String> parseXml(HttpServletRequest request){
		   Map<String, String> data = new HashMap<String, String>();
		   InputStream inputStream;
		   StringBuffer strXML = new StringBuffer();
		   try {
			    inputStream = request.getInputStream();
			    String readLineStr;
			    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			    while ((readLineStr = in.readLine()) != null) {
				   strXML.append(readLineStr);
			    }
			    in.close();
			    inputStream.close();
			   
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				documentBuilderFactory.setAttribute("http://apache.org/xml/features/disallow-doctype-decl", true);
				documentBuilderFactory.setAttribute("http://apache.org/xml/features/disallow-doctype-decl", true);
				documentBuilderFactory.setAttribute("http://xml.org/sax/features/external-general-entities", false);
				documentBuilderFactory.setAttribute("http://xml.org/sax/features/external-parameter-entities", false);
				documentBuilderFactory.setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
				documentBuilderFactory.setAttribute(XMLConstants.FEATURE_SECURE_PROCESSING, true);
				documentBuilderFactory.setNamespaceAware(false);
				documentBuilderFactory.setExpandEntityReferences(false);
				DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
				//DocumentBuilder documentBuilder = WXPayXmlUtil.newDocumentBuilder();
				InputStream stream = new ByteArrayInputStream(strXML.toString().getBytes("UTF-8"));
				org.w3c.dom.Document doc = documentBuilder.parse(stream);
				doc.getDocumentElement().normalize();
				NodeList nodeList = doc.getDocumentElement().getChildNodes();
				for (int idx = 0; idx < nodeList.getLength(); ++idx) {
				       Node node = nodeList.item(idx);
				       if (node.getNodeType() == Node.ELEMENT_NODE) {
			                org.w3c.dom.Element element = (org.w3c.dom.Element) node;
			                data.put(element.getNodeName(), element.getNodeValue());
				       }
				}
				stream.close();
				 
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		    return data;
	}
}
  