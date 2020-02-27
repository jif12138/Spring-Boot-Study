package top.jif12138.sell.service;

import org.springframework.data.domain.jaxb.SpringDataJaxb;
import top.jif12138.sell.dto.OrderDTO;

public interface OrderService {

    public OrderDTO create(OrderDTO orderDTO);

    public OrderDTO findOne(String orderId);
}
