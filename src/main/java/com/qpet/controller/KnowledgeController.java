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

import com.qpet.entity.PetKnowledge;
import com.qpet.entity.User;
import com.qpet.service.ChannelService;
import com.qpet.service.PetKnowledgeService;
import com.qpet.service.SearchService;
import com.qpet.vo.KnowledgeVo;
import com.qpet.vo.Page;

/** 
 * @Desc: (宠物管理：列表，知识，查询(lucene)，分类)
 * @author: 张瑞
 * @date: 2017年1月14日 下午4:35:28  
 * @email:2411685663@qq.com 
 */
@Controller
@RequestMapping("/admin")
public class KnowledgeController {
	@Autowired
	private PetKnowledgeService petKnowledgeService;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="/knowledge/{pageNum}",method=RequestMethod.GET)
	public String knowledge(@PathVariable int pageNum,Model model){
		Page<User> pages = new Page<User>();
		List<PetKnowledge> petKnowledges = this.petKnowledgeService.findByPage(pageNum*pages.getPageSize(), pages.getPageSize());
		List<KnowledgeVo> knowledgeVos = new ArrayList<KnowledgeVo>();
		KnowledgeVo knowledgeVo = null;
		for (PetKnowledge petKnowledge : petKnowledges) {
			knowledgeVo = new KnowledgeVo(petKnowledge.getPkid(), petKnowledge.getPkname(), 
					this.channelService.findById(petKnowledge.getCsid()).getName(), 
					petKnowledge.getLabel(), petKnowledge.getCopyright(), petKnowledge.getCreatetime(), petKnowledge.getCreator());
			knowledgeVos.add(knowledgeVo);
		}
		Long count = this.petKnowledgeService.totalSize();
		pages.setTotalRecords(count);//总数
		pages.setCurrentPage(pageNum);//当前页
		pages.setPageSize(pages.getPageSize());
		model.addAttribute("pages", pages);
		model.addAttribute("knowledgeVos", knowledgeVos);
		return "jsp/knowledge/knowledge";
	}
	
	/**
	 * 添加知识百科内容
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/knowledge/knowledgeSave",method=RequestMethod.GET)
	public String knowledgeSave(Model model){
		model.addAttribute("knowledgeInfo", new PetKnowledge());
		return "jsp/knowledge/knowledgeSave";
	}
	
	@RequestMapping(value="/knowledge/knowledgeSave",method=RequestMethod.POST)
	public String knowledgeSave(PetKnowledge petKnowledge){
		PetKnowledge petKnowledgeInfo = new PetKnowledge();
		petKnowledge.setCreatetime(new Date());
		petKnowledge.setCopyright("本文版权属于Qpet网（localhost:8080/Qpet/admin/index##），转载请注明出处。商业使用请联系Qpet网。");
		petKnowledgeInfo.setCopyright(petKnowledge.getCopyright());
		petKnowledgeInfo.setCreatetime(petKnowledge.getCreatetime());
		petKnowledgeInfo.setCreator(petKnowledge.getCreator());
		petKnowledgeInfo.setCsid(petKnowledge.getCsid());
		petKnowledgeInfo.setLabel(petKnowledge.getLabel());
		petKnowledgeInfo.setPkdescription(petKnowledge.getPkdescription());
		petKnowledgeInfo.setPkname(petKnowledge.getPkname());
		petKnowledgeInfo.setSummary(petKnowledge.getSummary());
		petKnowledgeInfo.setCopyright(petKnowledge.getCopyright());
		//添加索引
		this.petKnowledgeService.save(petKnowledge);
		return "redirect:/admin/knowledge/0";
	}
	
	/**
	 * 更新信息
	 * @param pkid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/knowledge/knowledgeUpdate/{pkid}",method=RequestMethod.GET)
	public String knowledgeUpdate(@PathVariable Integer pkid,Model model){
		model.addAttribute("knowledgeInfo", this.petKnowledgeService.findById(pkid).get(0));
		return "jsp/knowledge/knowledgeUpdate";
	}
	
	@RequestMapping(value="/knowledge/knowledgeUpdate/{pkid}",method=RequestMethod.POST)
	public String knowledgeUpdate(@PathVariable Integer pkid,PetKnowledge petKnowledge){
		PetKnowledge petKnowledgeModify = this.petKnowledgeService.findById(pkid).get(0);
		petKnowledgeModify.setCreator(petKnowledge.getCreator());
		petKnowledgeModify.setLabel(petKnowledge.getLabel());
		petKnowledgeModify.setPkdescription(petKnowledge.getPkdescription());
		petKnowledgeModify.setPkname(petKnowledge.getPkname());
		petKnowledgeModify.setSummary(petKnowledge.getSummary());
		this.petKnowledgeService.update(petKnowledgeModify);
		return "redirect:/admin/knowledge/0";
	}
	
	/**
	 * 删除
	 * @param pid
	 * @return
	 */
	@RequestMapping("/knowledge/delete/{pid}")
	public String delete(@PathVariable Integer pid){
		this.petKnowledgeService.delete(pid);
		return "redirect:/admin/knowledge/0";
	}
	
}
