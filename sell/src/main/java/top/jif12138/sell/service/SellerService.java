package top.jif12138.sell.service;

import top.jif12138.sell.dataobject.SellerInfo;

/**
 * 卖家端
 * Created by 廖师兄
 * 2017-07-29 23:14
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
