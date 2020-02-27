package top.jif12138.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

//    @RequestMapping(value = {"/{id}/say","/say/{id}"} , method= RequestMethod.GET)
//    public String say(@PathVariable("id") Integer id) {
////        return girlProperties.getCupSize();
//        return "id = " + id;
//    }

//    @RequestMapping(value = "/say", method= RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id" ,required=false , defaultValue = "nnn") String String_Id) {  //localhost:8080/hello/say?id=/100
//        return girlProperties.getCupSize();
        return "String_Id = " + String_Id;
    }
}
