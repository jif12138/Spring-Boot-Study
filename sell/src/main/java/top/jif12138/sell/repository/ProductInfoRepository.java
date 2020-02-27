package top.jif12138.sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jif12138.sell.dataobject.ProductInfo;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {


    List<ProductInfo> findByProductStatus(Integer productStatus);
}
