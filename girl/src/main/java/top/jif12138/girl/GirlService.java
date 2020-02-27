package top.jif12138.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);
        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBBBB");
        girlRepository.save(girlB);
    }

}
