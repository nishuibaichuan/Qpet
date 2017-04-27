package com.qpet.dao;

import com.qpet.entity.Order;

public interface OrderDao {

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);


    Order selectByPrimaryKey(String orderId);


    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}