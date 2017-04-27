package com.qpet.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qpet.service.ChannelService;

/** 
 * @Desc: (前台首页)
 * @author: 张瑞
 * @date: 2017年1月5日 下午4:34:08  
 * @email:2411685663@qq.com 
 */
@Controller
@RequestMapping("/front")
public class CommonController {
	@Autowired
	private ChannelService channelService;
	
	/**
	 * 前台首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("channels", channelService.listChannelByParentId(0));
		
		for (int i = 14; i < 18; i++) {
			model.addAttribute("channelList", channelService.listChannelByParentId(i));
		}
		return "front/index";
	}
	
	
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		return "front/login";
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/register")
	public String register(){
		return "front/register";
	}
	
}
