package com.imooc.form;

import lombok.Data;

/**
 * Created by skl
 */
@Data
public class StoreForm {

    private Long storeId;

    /** 门店名称. */
    private String storeName;

    /** 门店地址. */
    private String storeAddress;

    /** 门店电话. */
    private String storeMobile;
}
