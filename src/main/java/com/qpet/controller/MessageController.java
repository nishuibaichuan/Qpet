package com.qpet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qpet.entity.Message;
import com.qpet.entity.User;
import com.qpet.service.MessageService;
import com.qpet.service.UserService;
import com.qpet.vo.MessageVo;

/** 
 * @Desc: (管理员可以对留言列表查看和删除，会员只能查看自己发布的信息和删除.到时候
 * 		      做的时候，参考一些各大商城的留言怎么做的，如京东，E宠网，淘宝等)
 * @author: 张瑞
 * @date: 2017年1月14日 下午4:38:36  
 * @email:2411685663@qq.com 
 */
@Controller
@RequestMapping("/admin")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	/**
	 * 留言这个模块，要根据登陆者获得其对象后，到数据库获取他的id，之后，得到他自己发表的所有评论，他自己只能看
	 * 自己的评论留言。而管理员可以查看所有会员的评论留言。只能删除-查看，不可增加或者修改会员评论。
	 * 会员添加留言是在前台页面添加。
	 */
	@RequestMapping("/message")
	public String message(Model model){
		List<Message> messages = this.messageService.find();
		List<MessageVo> messageVos = new ArrayList<MessageVo>();
		MessageVo messageVo = null;
		for (Message message : messages) {
			if (message.getPid() != null) {
				List<User> users = this.userService.findById(message.getPid());
				for (User user : users) {
					if (user != null) {
						String ms = null;
						if (message.getContent().length() > 10) {
							ms = message.getContent().substring(0, 10);
						}else {
							ms = message.getContent();
						}
						messageVo = new MessageVo(message.getMid(), user.getUsername(), user.getName(), user.getEmail(),
								user.getPhone(), ms, message.getCreatetime());
						messageVos.add(messageVo);
					}
				}
			}
		}
		model.addAttribute("messageVos", messageVos);
		return "jsp/message/message";
	}
	
	@RequestMapping("/message/delete/{id}")
	public String delete(@PathVariable Integer id){
		if (id != null) {
			this.messageService.delete(id);
		}
		return "redirect:/admin/message";
	}
	
	
	
	
	
	
}
