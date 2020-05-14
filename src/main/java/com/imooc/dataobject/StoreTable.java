package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 桌位信息
 * Created by skl
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class StoreTable {

    /** 门店ID. */
    @Id
    @GeneratedValue
    private Integer tableId;

    /** 桌号. */
    private Integer tableNo;

    /** 桌名. */
    private String tableName;

    /** 门店ID. */
    private Long storeId;

    private Date createTime;

    private Date updateTime;

    public StoreTable() {
    }

}
