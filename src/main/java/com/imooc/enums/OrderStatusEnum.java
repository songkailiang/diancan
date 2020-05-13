package com.imooc.enums;

import lombok.Getter;

/**
 * Created by wwd
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单未确认"),
    NEW_PAYED(1, "新订单已确认"),
    CANCEL(2, "已取消"),
    FINISHED(3, "完结"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
