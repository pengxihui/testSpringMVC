/** 
   *   项目名:testSpringMVC
   *   日期:2019年3月6日上午9:57:01 
 * Copyright (c) 2019, 华信设计 All Rights Reserved. 
 */

package com.ipfs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.util.Base64;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

/**       
 * 项目名称：testSpringMVC     
 * 类描述：    
 * 创建人：pxh  
 * 创建时间：2019年3月6日 上午9:57:01    
 * 修改备注：    
 * @version 1.0  
 * Copyright (c) 2019, 华信设计  All Rights Reserved.     
 */
public class TestIpfs {
	
	private static IPFS ipfs = new IPFS("/ip4/192.168.110.137/tcp/5001");//ipfs的服务器地址和端口

	/** 
	 * main:
	 * @author pxh 
	 * @param args 
	 * @throws IOException 
	 * @since JDK 1.8 
	 */
	public static void main(String[] args) throws IOException {
		    String filePathName = "E:\\testIpfs\\zhongwen1.txt";
		    String hash = "QmTkcwngvkA3sZHYzk6LonpxGmZ3hszDKhZ7iMnESW5Gmf";
		    download(filePathName, hash);
	}
	
	/**
	 * 
	 * upload:上传文件
	 * @author pxh 
	 * @param filePathName
	 * @return 
	 * @throws IOException 
	 * @since JDK 1.8
	 */
	public static String upload(String filePathName) throws IOException {
		//filePathName 指的是文件的上传路径+文件名  如 E:/ipfs/example.png
		NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File(filePathName));
		MerkleNode addResult = ipfs.add(file).get(0);
		return addResult.hash.toString();
	}
	
	/**
	 * 
	 * download:下载文件
	 * @author pxh 
	 * @param filePathName
	 * @param hash
	 * @throws IOException 
	 * @since JDK 1.8
	 */
	public static void download(String filePathName,String hash) throws IOException {
		Multihash filePointer = Multihash.fromBase58(hash);
		byte[] data = ipfs.cat(filePointer);
		if(data != null) {
			File file = new File(filePathName);
			if(file.exists()) {
				file.delete();
			}
			FileOutputStream fos = new FileOutputStream(file);
            fos.write(data, 0, data.length);
			fos.flush();
			fos.close();
		}
	}
	
	


}


