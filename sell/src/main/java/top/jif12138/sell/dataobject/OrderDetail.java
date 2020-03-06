package top.jif12138.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import java.math.BigDecimal;

import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate // 自动更新update time
public class OrderDetail {

    @Id
    private String detailId;

    //    /** 订单id. */
    private String orderId;

    //    /** 商品id. */
    private String productId;

    //    /** 商品名称. */
    private String productName;

    //    /** 商品单价. */
    private BigDecimal productPrice;

    //    /** 商品数量. */
    private Integer productQuantity;

    //    /** 商品小图. */
    private String productIcon;
}
