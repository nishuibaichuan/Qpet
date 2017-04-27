package com.qpet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpet.dao.AppinfoDao;
import com.qpet.entity.Appinfo;
import com.qpet.service.AppinfoService;

/** 
 * @Desc: (站点查看和修改)
 * @author: 张瑞
 * @date: 2017年1月12日 下午9:19:57  
 * @email:2411685663@qq.com 
 */
@Service("appinfoService")
public class AppinfoServiceImpl implements AppinfoService {

	@Autowired
	private AppinfoDao appinfoDao;
	
	@Override
	public void update(Appinfo app) {
		this.appinfoDao.update(app);
	}

	@Override
	public Appinfo findById(int id) {
		return this.appinfoDao.findById(id);
	}

}
