package com.qpet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpet.dao.PetCategoryProductInfoDao;
import com.qpet.entity.PetCategoryProductInfo;
import com.qpet.service.PetCategoryProductInfoService;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年1月18日 下午8:44:08  
 * @email:2411685663@qq.com 
 */
@Service("petCategoryProductInfoService")
public class PetCategoryProductInfoServiceImpl implements
		PetCategoryProductInfoService {
	@Autowired
	private PetCategoryProductInfoDao petCategoryProductInfoDao;

	@Override
	public void delete(Integer pid) {
		this.petCategoryProductInfoDao.delete(pid);
	}

	@Override
	public void save(PetCategoryProductInfo record) {
		this.petCategoryProductInfoDao.save(record);
	}

	@Override
	public List<PetCategoryProductInfo> findById(Integer pid) {
		return this.petCategoryProductInfoDao.findById(pid);
	}

	@Override
	public List<PetCategoryProductInfo> find() {
		return this.petCategoryProductInfoDao.find();
	}

	@Override
	public void update(PetCategoryProductInfo record) {
		this.petCategoryProductInfoDao.update(record);
	}

	@Override
	public PetCategoryProductInfo findByName(String pname) {
		return this.petCategoryProductInfoDao.findByName(pname);
	}

	@Override
	public PetCategoryProductInfo findByPid(Integer pid) {
		return this.petCategoryProductInfoDao.findByPid(pid);
	}

	@Override
	public List<PetCategoryProductInfo> findByChannelId(Integer channelId) {
		return this.petCategoryProductInfoDao.findByChannelId(channelId);
	}

	@Override
	public List<PetCategoryProductInfo> findByPage(int begin, int pageSize) {
		return this.petCategoryProductInfoDao.findByPage(begin, pageSize);
	}

	@Override
	public Long totalSize() {
		return this.petCategoryProductInfoDao.totalSize();
	}
	
}
