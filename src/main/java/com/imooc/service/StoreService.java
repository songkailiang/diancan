package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dataobject.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 门店
 * Created by skl
 */
public interface StoreService {

    Store findOne(Long storeId);

    Store save(Store store);

   void delete(Long storeId);

    Page<Store> findAll(Pageable pageable);
}
