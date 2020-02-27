package top.jif12138.sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jif12138.sell.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository <ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTYPElIST);



}
