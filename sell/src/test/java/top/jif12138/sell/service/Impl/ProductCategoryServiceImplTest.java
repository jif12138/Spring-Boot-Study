package top.jif12138.sell.service.Impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jif12138.sell.dataobject.ProductCategory;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryService.findOne(1);
//        productCategory.setCategoryType(5);
//        categoryService.save(productCategory);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
//        System.out.println(productCategoryList.indexOf(1));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(2, 3, 4));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生专享", 3);
        ProductCategory result = productCategoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}