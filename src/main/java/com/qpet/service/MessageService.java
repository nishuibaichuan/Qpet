package com.qpet.service;

import java.util.List;

import com.qpet.entity.Message;

public interface MessageService {

	public void delete(int mid);

    public void Save(Message record);

    public List<Message> findById(Integer mid);
    
    /**
     * 获取所有评价信息
     * @param mid
     * @return
     */
    public List<Message> find();

    public void update(Message record);
}