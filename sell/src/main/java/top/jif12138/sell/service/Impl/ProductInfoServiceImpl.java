package top.jif12138.sell.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.jif12138.sell.dataobject.ProductInfo;
import top.jif12138.sell.repository.ProductInfoRepository;
import top.jif12138.sell.service.ProductInfoService;
import top.jif12138.sell.enums.ProductStatusEnum;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

   @Autowired
   private  ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productID) {
        return repository.findById(productID).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
