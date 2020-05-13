package com.imooc.service.impl;


import com.imooc.dataobject.StoreTable;
import com.imooc.repository.StoreTableRepository;
import com.imooc.service.StoreTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 * Created by skl
 */
@Service
public class StoreTableServiceImpl implements StoreTableService {

    @Autowired
    private StoreTableRepository repository;

    @Override
    public StoreTable findOne(Integer tableId) {
        return repository.findOne(tableId);
    }

    @Override
    public List<StoreTable> findAll() {
        return repository.findAll();
    }

    @Override
    public List<StoreTable> findByStoreId(Long storeId) {
        return repository.findByStoreId(storeId);
    }

    @Override
    public StoreTable save(StoreTable storeTable) {
        return repository.save(storeTable);
    }
}
