package com.qpet.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qpet.entity.Channel;
import com.qpet.service.ChannelService;
import com.qpet.vo.Page;

/** 
 * @Desc: (栏目管理)
 * @author: 张瑞
 * @date: 2017年1月15日 下午1:14:13  
 * @email:2411685663@qq.com 
 */
@Controller
@RequestMapping("/admin")
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	
	@RequestMapping("/channel")
	public String channel(){
		return "jsp/channel/channelList";
	}
	
	/**
	 * 栏目树：获取id,parentId,Name 异步ajax
	 * 
	 * @return
	 */
	@RequestMapping("/ajaxchannel")
	@ResponseBody
	public List<Channel> ajaxchannel() {
		List<Channel> mvList = channelService.listChannelByTree();
		return mvList;
	}
	
	/**
	 * 分页
	 * @param pid
	 * @param model
	 */
	public void initChannel(Integer pid,int pageNum, Model model) {
		Page<Channel> pages = new Page<Channel>();
		Channel cs = null;
		List<Channel> cLists = new ArrayList<Channel>();
		List<Channel> channelLists = this.channelService.findByPage(pid,pageNum*pages.getPageSize(), pages.getPageSize());
		for (Channel channel : channelLists) {
			cs = new Channel(channel.getId(), channel.getName(),channel.getDescription(),"admin"
							,new Date(),
							channel.getChannelorder(), channel.getStatus()	);
			cLists.add(cs);
		}
		Long count = this.channelService.totalSize(pid);
		pages.setTotalRecords(count);//总数
		pages.setCurrentPage(pageNum);//当前页
		pages.setPageSize(pages.getPageSize());
		model.addAttribute("channels", cLists);
		model.addAttribute("pages", pages);
	}
	
	/**
	 * 获取当前操作栏目名称
	 * 
	 * @param pid
	 * @param model
	 */
	public void initRoot(Integer pid, Model model) {
		Channel currentChannelName = channelService.findById(pid);
		model.addAttribute("currentChannelName", currentChannelName);
	}
	
	/**
	 * 点击任意栏目,列出该栏目下的子栏目
	 * 
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping("/channel/{pid}_{pageNum}")
	public String listChannelByParent(@PathVariable Integer pid, @PathVariable int pageNum,Model model) {
		initRoot(pid, model);
		initChannel(pid,pageNum, model);
		return "jsp/channel/channelChild";
	}
	
	/**
	 * 添加栏目
	 * 
	 * @return
	 */
	@RequestMapping(value = "/channelSave/{pid}", method = RequestMethod.GET)
	public String channelSave(@PathVariable Integer pid, Model model) {
		initRoot(pid, model);
		model.addAttribute("channel", new Channel());
		return "jsp/channel/channelSave";
	}

	/**
	 * 添加栏目后跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/channelSave/{pid}", method = RequestMethod.POST)
	public String channelSave(@PathVariable Integer pid, Model model,
			Channel channel) {
		initRoot(pid, model);
		Integer channelOrder = this.channelService.getMaxOrderByParent(pid);
		if (channelOrder == null) {
			channelOrder = 0;
		}
		if (pid == 0) {
			channel.setParentid(0);
			channel.setChannelorder(0);
		}else {
			channel.setParentid(pid);
			channel.setChannelorder(channelOrder + 1);
		}
		channelService.save(channel);
		return "redirect:/admin/channel/" + pid + "_0";
	}

	/**
	 * 更新栏目
	 * 
	 * @return
	 */
	@RequestMapping(value = "/channelUpdate/{id}", method = RequestMethod.GET)
	public String channelUpdate(@PathVariable Integer id, Model model) {
		Channel channel = channelService.findById(id);
		model.addAttribute("channel", channel);
		return "jsp/channel/channelUpdate";
	}

	/**
	 * 更新栏目后跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/channelUpdate/{id}", method = RequestMethod.POST)
	public String channelUpdate(@PathVariable Integer id, Channel channel) {
		Channel channel2 = channelService.findById(id);
		channel2.setName(channel.getName());
		channel2.setCreator(channel.getCreator());
		channel2.setDescription(channel.getDescription());
		channel2.setStatus(channel.getStatus());
		channelService.update(channel2);
		return "redirect:/admin/channel/"+ "0_0";
	}
}
