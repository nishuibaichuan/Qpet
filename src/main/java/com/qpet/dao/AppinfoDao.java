package com.qpet.dao;

import com.qpet.entity.Appinfo;

public interface AppinfoDao {
	/**
	 * 更新站点
	 * @param record
	 * @return
	 */
    public void update(Appinfo app);
    
    /**
     * 根据id获取站点信息
     * @param id
     * @return
     */
    public Appinfo findById(int id);
}