package com.qpet.dao;

import com.qpet.entity.Admin;

public interface AdminDao {

    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);
    
    /**
     * 后台管理员登陆查询
     * @param username
     * @return
     */
    public Admin login(Admin admin);
    
    /**
     * 修改密码
     * @param admin
     */
    public void update(Admin admin);
}