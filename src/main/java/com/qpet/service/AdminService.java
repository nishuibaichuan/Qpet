package com.qpet.service;

import com.qpet.entity.Admin;

public interface AdminService {

    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);

    public Admin loginAdmin(Admin admin);
    
    /**
     * 修改密码
     * @param admin
     */
    public void update(Admin admin);
}