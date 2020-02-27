package top.jif12138.sell.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jif12138.sell.ViewObject.ProductInfoVO;
import top.jif12138.sell.ViewObject.ProductVO;
import top.jif12138.sell.ViewObject.ResultVO;
import top.jif12138.sell.dataobject.ProductCategory;
import top.jif12138.sell.dataobject.ProductInfo;
import top.jif12138.sell.service.CategoryService;
import top.jif12138.sell.service.ProductInfoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    private final Logger logger = LoggerFactory.getLogger(BuyerProductController.class);


    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1.查询所有上架产品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2.查询所有类目（一次性查询）
        List<Integer> productCategoryTypeList = new ArrayList<>();

        // 传统方法
        for (ProductInfo productInfo : productInfoList) {
            productCategoryTypeList.add(productInfo.getCategoryType());
        }
        // 精简方法 (java8 lambda)
//        productCategoryTypeList = productInfoList.stream()
//                .map(e -> e.getCategoryType())
//                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(productCategoryTypeList);

        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            System.out.println("productCategory"+productCategory.toString());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            for (ProductInfo productInfo : productInfoList) {
                System.out.println("productInfo"+productInfo.toString());
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //springboot 封装的方法 复制属性
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            ProductVO productVO = new ProductVO(productCategory.getCategoryName(), productCategory.getCategoryType(), productInfoVOList);
            productVOList.add(productVO);
        }
        ResultVO resultVO = new ResultVO(0, "成功", productVOList);
        return resultVO;
    }
}
