package top.jif12138.sell.service.Impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import top.jif12138.sell.dataobject.OrderDetail;
import top.jif12138.sell.dataobject.OrderMaster;
import top.jif12138.sell.dataobject.ProductInfo;
import top.jif12138.sell.dto.OrderDTO;
import top.jif12138.sell.enums.ResultEnum;
import top.jif12138.sell.exception.SellException;
import top.jif12138.sell.repository.OrderDetailRepository;
import top.jif12138.sell.repository.OrderMasterRepository;
import top.jif12138.sell.service.OrderService;
import top.jif12138.sell.service.ProductInfoService;
import top.jif12138.sell.utils.KeyUtil;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
//        1. 查询商品数量
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
//            2. 计算总价
            orderAmount = orderDetail.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
//  订单详情入库
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
        }

//        3. 写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);
//        4. 扣库存
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }


}
