package top.jif12138.sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jif12138.sell.dataobject.OrderDetail;
import top.jif12138.sell.dataobject.ProductCategory;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}