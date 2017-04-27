package com.qpet.dao;

import com.qpet.entity.ItemDesc;

public interface ItemDescDao {

    int deleteByPrimaryKey(Long itemId);

    int insert(ItemDesc record);

    int insertSelective(ItemDesc record);


    ItemDesc selectByPrimaryKey(Long itemId);


    int updateByPrimaryKeySelective(ItemDesc record);

    int updateByPrimaryKeyWithBLOBs(ItemDesc record);

    int updateByPrimaryKey(ItemDesc record);
}