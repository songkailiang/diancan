package com.imooc.service;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.StoreTable;

import java.util.List;

/**
 * 桌位
 * Created by skl
 */
public interface StoreTableService {

    StoreTable findOne(Integer tableId);

    List<StoreTable> findAll();

    List<StoreTable> findByStoreId(Long storeId);

    StoreTable save(StoreTable storeTable);
}
