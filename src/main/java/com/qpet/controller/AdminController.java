package com.qpet.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qpet.entity.Admin;
import com.qpet.service.AdminService;
import com.qpet.util.Captcha;

/** 
 * @Desc: (管理员：修改密码)
 * @author: 张瑞
 * @date: 2017年1月12日 下午11:06:03  
 * @email:2411685663@qq.com 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@SuppressWarnings("unused")
	private static final transient Logger log = LoggerFactory
			.getLogger(AdminController.class);
	
	/**
	 * 修改密码
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modify(Model model){
		model.addAttribute("admin", new Admin());
		return "jsp/app/modify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(Admin admin){
		Admin admin2 = new Admin();
		String[] pass = admin.getPassword().split(",");
		admin2.setAid(1);
		for (String p : pass) {
			admin2.setPassword(p);
		}
		this.adminService.update(admin2);
		return "redirect:/admin/modify";
	}
	
	/**
	 * 管理员登陆
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "jsp/admin/login";
	}
		
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Admin admin,String checkcode,Model model,HttpSession session) {
		String cc = (String)session.getAttribute("cc");//session中获取验证码
		//判断验证码是否一样
		if(!cc.equals(checkcode)) {
			model.addAttribute("msg","验证码出错，请重新输入");
			return "jsp/admin/login";
		}
	/*	log.info(admin.getUsername() + " login");*/
		session.removeAttribute("cc");
		//判断用户账号密码是否正确,正确进入后台，错误返回空，并报错
		Admin admin2 = adminService.loginAdmin(admin);
		if (admin2 == null) {
			model.addAttribute("msg", "用户名或者密码错误");
			return "jsp/admin/login";
		}else {
			session.setAttribute("admin", admin2.getUsername());
			//跳转后台首页
			return "redirect:index";
		}
		
	}
	
	/**
	 * 退出系统
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}
	
	/**
	 * 登录页面验证码
	 * @param resp
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping(value = "/drawCheckCode", method = RequestMethod.GET)
	public void drawCheckCode(HttpServletResponse resp, HttpServletRequest request) throws IOException {
		resp.setContentType("image/png");
		HttpSession session = request.getSession();
		int width = 180;
		int height = 40;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("cc", checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "png", os);
	}
	
}
