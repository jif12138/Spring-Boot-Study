package top.jif12138.sell.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.jif12138.sell.dataobject.ProductCategory;
import top.jif12138.sell.dataobject.ProductInfo;

import java.util.List;

/**
 * 商品
 */
public interface ProductInfoService {

    ProductInfo findOne(String productID);

    /**
     * 查询所有在架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable );

    ProductInfo save(ProductInfo productInfo);

    //加库存
    //todo

    //减库存
    //todo
}
