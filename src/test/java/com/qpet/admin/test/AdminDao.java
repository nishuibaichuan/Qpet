package com.qpet.admin.test;

import org.junit.Test;

import com.qpet.util.MD5Utils;

/** 
 * @Desc: (测试md5加密)
 * @author: 张瑞
 * @date: 2017年4月6日 上午11:42:52  
 * @email:2411685663@qq.com 
 */
public class AdminDao {
	
	@Test
	public void md5Test(){
		System.out.println(MD5Utils.md5("isAdmin"));//5fdedfe381eef204ab3354d244885a40 --> 密码
	}
	
	
	
}
