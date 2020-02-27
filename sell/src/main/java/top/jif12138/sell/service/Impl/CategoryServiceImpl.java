package top.jif12138.sell.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jif12138.sell.dataobject.ProductCategory;
import top.jif12138.sell.repository.CategoryRepository;
import top.jif12138.sell.service.CategoryService;

import java.util.List;

/**
 *类目
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
