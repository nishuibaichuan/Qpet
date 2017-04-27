package com.qpet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpet.dao.ChannelDao;
import com.qpet.entity.Channel;
import com.qpet.service.ChannelService;

/** 
 * @Desc: (栏目的更新，查看和修改)
 * @author: 张瑞
 * @date: 2017年1月14日 下午6:08:36  
 * @email:2411685663@qq.com 
 */
@Service("channelService")
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelDao channelDao;
	
	@Override
	public void save(Channel channel) {
		this.channelDao.save(channel);
	}

	@Override
	public void update(Channel channel) {
		this.channelDao.update(channel);
	}

	@Override
	public Channel findById(int id) {
		return this.channelDao.findById(id);
	}

	@Override
	public List<Channel> listChannelByTree() {
		return this.channelDao.listChannelByTree();
	}

	@Override
	public List<Channel> listChannelByParent(Integer pid) {
		return this.channelDao.listChannelByParent(pid);
	}

	@Override
	public Integer getMaxOrderByParent(Integer pid) {
		return this.channelDao.getMaxOrderByParent(pid);
	}

	@Override
	public List<Channel> findByPage(int parentId,int begin, int pageSize) {
		return this.channelDao.findByPage(parentId,begin, pageSize);
	}
	
	@Override
	public List<Channel> findByPager(int begin, int pageSize) {
		return this.channelDao.findByPager(begin, pageSize);
	}

	@Override
	public Long totalSize(int parentId){
		return this.channelDao.totalSize(parentId);
	}

	@Override
	public List<Channel> listChannelByParentId(Integer pid) {
		return this.channelDao.listChannelByParentId(pid);
	}

	
	
}
