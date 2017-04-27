package com.qpet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpet.dao.PetKnowledgeDao;
import com.qpet.entity.PetKnowledge;
import com.qpet.service.PetKnowledgeService;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年1月20日 下午7:37:15  
 * @email:2411685663@qq.com 
 */
@Service("petKnowledgeService")
public class PetKnowledgeServiceImpl implements PetKnowledgeService {
	@Autowired
	private PetKnowledgeDao petKnowledgeDao;
	
	@Override
	public void delete(Integer pkid) {
		this.petKnowledgeDao.delete(pkid);
	}

	@Override
	public void save(PetKnowledge record) {
		this.petKnowledgeDao.save(record);
	}

	@Override
	public List<PetKnowledge> findById(Integer pkid) {
		return this.petKnowledgeDao.findById(pkid);
	}

	@Override
	public void update(PetKnowledge record) {
		this.petKnowledgeDao.update(record);
	}

	@Override
	public List<PetKnowledge> find() {
		return this.petKnowledgeDao.find();
	}

	@Override
	public List<PetKnowledge> findByChannelId(Integer csid) {
		return this.petKnowledgeDao.findByChannelId(csid);
	}

	@Override
	public List<PetKnowledge> findByPage(int begin, int pageSize) {
		return this.petKnowledgeDao.findByPage(begin, pageSize);
	}

	@Override
	public Long totalSize() {
		return this.petKnowledgeDao.totalSize();
	}

}
