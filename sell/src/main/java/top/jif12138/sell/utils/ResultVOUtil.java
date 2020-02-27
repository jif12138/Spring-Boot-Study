package top.jif12138.sell.utils;

import top.jif12138.sell.ViewObject.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object) {

        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }
}
