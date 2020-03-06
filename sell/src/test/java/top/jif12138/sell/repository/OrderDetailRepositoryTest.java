package top.jif12138.sell.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jif12138.sell.dataobject.OrderDetail;
import top.jif12138.sell.dataobject.OrderMaster;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("212121");
        orderDetail.setProductId("11111");
        orderDetail.setDetailId("4454");
        orderDetail.setProductIcon("4545545445");
        orderDetail.setProductName("好吃的");
        orderDetail.setProductPrice(new BigDecimal(2.0));
        orderDetail.setProductQuantity(2);
        OrderDetail result = repository.save(orderDetail);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findBuyerOpenId() throws Exception {

        List<OrderDetail> result = repository.findByOrderId("123123");
        System.out.println(result);
        Assert.assertNotNull(result);

    }

}