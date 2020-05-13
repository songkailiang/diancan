package com.imooc.repository;

import com.imooc.dataobject.StoreTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by skl
 */
public interface StoreTableRepository extends JpaRepository<StoreTable, Integer> {
    List<StoreTable> findByStoreId(Long storeId);
}
