package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by wwd
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryIdIn(List<Integer> categoryTypeList);

    List<ProductCategory> findByStoreId(Long storeId);

    ProductCategory save(ProductCategory productCategory);
}
