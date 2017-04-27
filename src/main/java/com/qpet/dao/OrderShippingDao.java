package com.qpet.dao;

import com.qpet.entity.OrderShipping;

public interface OrderShippingDao {

    int deleteByPrimaryKey(String orderId);

    int insert(OrderShipping record);

    int insertSelective(OrderShipping record);


    OrderShipping selectByPrimaryKey(String orderId);


    int updateByPrimaryKeySelective(OrderShipping record);

    int updateByPrimaryKey(OrderShipping record);
}