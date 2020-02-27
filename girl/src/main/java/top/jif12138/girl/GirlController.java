package top.jif12138.girl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女孩
     *
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }


    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 通过ID查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFinOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).get();
//        return girlRepository.findOne(id);
    }

    /**
     * 通过ID更新一个女生
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * \通过ID删除一个女生
     *
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }
}
