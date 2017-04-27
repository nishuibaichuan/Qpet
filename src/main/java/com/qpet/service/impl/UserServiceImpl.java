package com.qpet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpet.dao.UserDao;
import com.qpet.entity.User;
import com.qpet.service.UserService;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年1月16日 下午1:00:32  
 * @email:2411685663@qq.com 
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public void delete(int uid) {
		this.userDao.delete(uid);
	}

	@Override
	public List<User> find() {
		return this.userDao.find();
	}

	@Override
	public List<User> findById(int uid) {
		return this.userDao.findById(uid);
	}

	@Override
	public List<User> findByPage(int begin, int pageSize) {
		return this.userDao.findByPage(begin, pageSize);
	}

	@Override
	public Long totalSize() {
		return this.userDao.totalSize();
	}

}
