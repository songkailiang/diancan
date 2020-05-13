package com.imooc.form;

import lombok.Data;

/**
 * Created by skl
 */
@Data
public class StoreTableForm {

    private Integer tableId;

    /** 门店桌号. */
    private Integer tableNo;

    /** 门店ID. */
    private Long storeId;
}
