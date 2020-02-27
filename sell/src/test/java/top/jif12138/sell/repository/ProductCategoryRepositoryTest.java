package top.jif12138.sell.repository;

import org.junit.Assert;
import top.jif12138.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    @Transactional
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }
    @Test
    @Transactional
    public void findAllTest() {
        List<ProductCategory> productCategory = repository.findAll();
        System.out.println(productCategory.toString()+productCategory.size());
    }
    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("女生最爱", 4);
        ProductCategory result = repository.save(productCategory);
        repository.save(productCategory);
        Assert.assertNotNull(result);
    }
    @Test
    @Transactional
        public   void finByCategoryTypeIn(){
        List<Integer>  list = Arrays.asList(2,3,4);

        List<ProductCategory> result  =repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}