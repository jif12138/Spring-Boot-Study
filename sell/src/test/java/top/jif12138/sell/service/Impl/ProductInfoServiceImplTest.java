package top.jif12138.sell.service.Impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jif12138.sell.dataobject.ProductInfo;
import top.jif12138.sell.service.ProductInfoService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("r1");
        Assert.assertEquals("r1", productInfo.getProductId());

    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());

    }

    @Test
    @Transactional
    public void save() {
        ProductInfo productInfo1212 = new ProductInfo(
                "s3", "番茄炒西兰花", new BigDecimal(12.00), 99,
                "营养丰富的西红柿和同样营养丰富的西兰花配在一起，让人很有食欲，而且酸酸的很开胃呢。",
                null, 1, 1);
        ProductInfo result = productInfoService.save(productInfo1212);
        Assert.assertNotNull(result);
    }
}