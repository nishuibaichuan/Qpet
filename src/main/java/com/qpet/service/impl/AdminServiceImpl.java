package com.qpet.service.impl;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpet.dao.AdminDao;
import com.qpet.entity.Admin;
import com.qpet.exception.QpetException;
import com.qpet.service.AdminService;
import com.qpet.util.MD5Utils;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年1月16日 上午11:32:14  
 * @email:2411685663@qq.com 
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public int deleteByPrimaryKey(Integer aid) {
		return 0;
	}

	@Override
	public int insert(Admin record) {
		return 0;
	}

	@Override
	public int insertSelective(Admin record) {
		return 0;
	}

	@Override
	public Admin selectByPrimaryKey(Integer aid) {
		return null;
	}

	@Override
	public void update(Admin admin) {
		this.adminDao.update(admin);
	}

	/**
	 * MD5加密
	 */
	@Override
	public Admin loginAdmin(Admin admin) {
		admin.setPassword(MD5Utils.md5(admin.getPassword()));
		return adminDao.login(admin);
	}

}
