package com.qpet.channel.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qpet.entity.Channel;
import com.qpet.service.ChannelService;

/** 
 * @Desc: (测试栏目)
 * @author: 张瑞
 * @date: 2017年1月14日 下午6:21:50  
 * @email:2411685663@qq.com 
 */
public class ChannelDaoTest {
	private ChannelService channelService;
	
	@Before
	public void before(){
		System.out.println("before...");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:/spring-mybatis.xml","classpath:/spring.xml"});
		channelService = (ChannelService) context.getBean("channelService");
	}
	
	@Test
	public void listChannelByTree(){
		List<Channel> listChannels = this.channelService.listChannelByParent(1);
		for (Channel channel : listChannels) {
			System.out.println(channel.getName());
		}
	}
	
	@After
	public void after(){
		System.out.println("after...");
	}
}
