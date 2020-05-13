package com.imooc.service.impl;


import com.imooc.dataobject.Store;
import com.imooc.repository.StoreRepository;
import com.imooc.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 门店
 * Created by skl
 */
@Service
public class StoreServiceImpl implements StoreService {


    @Autowired
    StoreRepository storeRepository;


    @Override
    public Store findOne(Long storeId) {
        return storeRepository.findOne(storeId);
    }

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    public void delete(Long storeId) {
        storeRepository.delete(storeId);

    }

    @Override
    public Page<Store> findAll(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }
}
