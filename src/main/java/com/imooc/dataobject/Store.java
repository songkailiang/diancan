package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 门店
 * Created by skl
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class Store {

    /** 门店ID. */
    @Id
    @GeneratedValue
    private Long storeId;

    /** 门店名称. */
    private String storeName;

    /** 门店地址. */
    private String storeAddress;

    /** 门店电话. */
    private String storeMobile;

    private Date createTime;

    private Date updateTime;

    public Store() {
    }

}
