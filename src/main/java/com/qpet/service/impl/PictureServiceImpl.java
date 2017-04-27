package com.qpet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpet.dao.PictureDao;
import com.qpet.entity.Picture;
import com.qpet.service.PictureService;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年1月18日 下午10:41:32  
 * @email:2411685663@qq.com 
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {
	@Autowired
	private PictureDao pictureDao;
	
	@Override
	public void delete(Integer tid) {
		this.pictureDao.delete(tid);
	}

	@Override
	public void save(Picture record) {
		this.pictureDao.save(record);
	}

	@Override
	public List<Picture> findById(Integer tid) {
		return this.pictureDao.findById(tid);
	}
	
	@Override
	public List<Picture> find() {
		return this.pictureDao.find();
	}

	@Override
	public void update(Picture record) {
		this.pictureDao.update(record);
	}

	@Override
	public Picture findByImageUrl(String imageUrl) {
		return this.pictureDao.findByImageUrl(imageUrl);
	}

	@Override
	public void deleteByPid(Integer pid) {
		this.pictureDao.deleteByPid(pid);
	}

}
