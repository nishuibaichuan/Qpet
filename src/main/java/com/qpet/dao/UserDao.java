package com.qpet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qpet.entity.User;

public interface UserDao {

	/**
	 * 删除会员
	 * @param uid
	 */
    public void delete(int uid);

    /**
     * 查询所有会员
     * @return
     */
    public List<User> find();
    
    /**
     * 根据id查询会员
     * @param uid
     * @return
     */
    public List<User> findById(int uid);
    
    /**
	 * <!--根据创建者id，进行分页查询角色信息  -->
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<User> findByPage(@Param("begin")int begin, @Param("pageSize")int pageSize);
	
	public Long totalSize();
}