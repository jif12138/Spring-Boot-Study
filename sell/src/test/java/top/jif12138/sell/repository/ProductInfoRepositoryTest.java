package top.jif12138.sell.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jif12138.sell.dataobject.ProductCategory;
import top.jif12138.sell.dataobject.ProductInfo;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    @Transactional
    public void findOneTest() {
        ProductInfo productInfo = repository.findById("1").get();
        System.out.println(productInfo.toString());
    }
    @Test
    @Transactional
    public void findAllTest() {
        List<ProductInfo> productCategory = repository.findAll();
        System.out.println(productCategory.toString()+productCategory.size());
    }
    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo(
                "s2","番茄炒西兰花", new BigDecimal(12.00),99,
                "营养丰富的西红柿和同样营养丰富的西兰花配在一起，让人很有食欲，而且酸酸的很开胃呢。",
                null,1,1);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    @Transactional
    public   void finByProductStatus(){
        List<ProductInfo> result  =repository.findByProductStatus(1);
        Assert.assertNotEquals(0,result.size());
    }

}