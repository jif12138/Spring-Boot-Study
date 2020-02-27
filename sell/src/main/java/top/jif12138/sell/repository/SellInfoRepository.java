package top.jif12138.sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jif12138.sell.dataobject.SellerInfo;

public interface SellInfoRepository extends JpaRepository<SellerInfo, Integer> {
    SellerInfo findByOpenid(String openid);

}
