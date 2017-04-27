package com.qpet.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qpet.entity.Channel;

public interface ChannelService {
	/**
	 * 添加栏目
	 * @param channel
	 */
    public void save(Channel channel);

    /**
     * 更新栏目
     * @param channel
     */
    public void update(Channel channel);
    
    /**
     * 根据id查询栏目
     * @param id
     * @return
     */
    public Channel findById(int id);
    
    /**
     * 生成树
     * @return
     */
    public List<Channel> listChannelByTree();
    
    /**
	 * 根据父id获取所有的子栏目
	 * @param pid
	 * @return
	 */
	public List<Channel> listChannelByParent(Integer pid);
	
	/**
	 * 根据父id获取所有的子栏目
	 * @param pid
	 * @return
	 */
	public List<Channel> listChannelByParentId(Integer pid);
	
	/**
	 * 获取子栏目的最大的排序号
	 * @param pid
	 * @return
	 */
	public Integer getMaxOrderByParent(Integer pid);
	
	/**
	 * <!--根据创建者id，进行分页查询角色信息  -->
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<Channel> findByPage(@Param("parentId")int parentId,@Param("begin")int begin, @Param("pageSize")int pageSize);
	
	/**
	 * <!--根据创建者id，进行分页查询角色信息  -->
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<Channel> findByPager(@Param("begin")int begin, @Param("pageSize")int pageSize);
	
	public Long totalSize(@Param("parentId")int parentId);
}
