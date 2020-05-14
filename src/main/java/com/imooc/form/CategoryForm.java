package com.imooc.form;

import lombok.Data;

/**
 * Created by wwd
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 门店Id. */
    private Long storeId;
}
