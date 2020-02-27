package top.jif12138.sell.controller;

import org.junit.Test;
import top.jif12138.sell.ViewObject.ProductInfoVO;
import top.jif12138.sell.ViewObject.ProductVO;
import top.jif12138.sell.ViewObject.ResultVO;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BuyerProductControllerTest {

    @Test
    public void list() {
        ProductInfoVO productInfoVO1 = new ProductInfoVO(
                "s1", "清炒土豆丝", new BigDecimal(10.00),
                "清炒土豆丝是以土豆作为主料，大葱作为辅料，盐、胡麻油、花生油作为调料制作而成的家常菜。具有咸鲜，酸辣的口味。",
                "https://www.xiangha.com/caipu/80002697.html");
        ProductInfoVO productInfoVO2 = new ProductInfoVO(
                "s1", "清炒土豆丝", new BigDecimal(10.00),
                "清炒土豆丝是以土豆作为主料，大葱作为辅料，盐、胡麻油、花生油作为调料制作而成的家常菜。具有咸鲜，酸辣的口味。",
                "https://www.xiangha.com/caipu/80002697.html");

        ProductVO productVO = new ProductVO("热销榜", 1, Arrays.asList(productInfoVO1, productInfoVO2));
        ResultVO resultVO = new ResultVO(0, "成功", productVO);
    }
}