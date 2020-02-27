package top.jif12138.sell.service;

import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;
import top.jif12138.sell.dataobject.ProductCategory;

import java.util.List;


public interface ProductCategoryService {

    ProductCategory findOne(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
