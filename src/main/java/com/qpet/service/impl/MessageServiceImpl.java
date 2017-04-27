package com.qpet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpet.dao.MessageDao;
import com.qpet.entity.Message;
import com.qpet.service.MessageService;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年1月16日 下午3:13:52  
 * @email:2411685663@qq.com 
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public void delete(int mid) {
		this.messageDao.delete(mid);
	}

	@Override
	public List<Message> find() {
		return this.messageDao.find();
	}

	@Override
	public void Save(Message record) {
		this.messageDao.Save(record);
	}

	@Override
	public List<Message> findById(Integer mid) {
		return this.messageDao.findById(mid);
	}

	@Override
	public void update(Message record) {
		this.messageDao.update(record);
	}

}
