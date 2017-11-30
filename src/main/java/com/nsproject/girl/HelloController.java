package com.nsproject.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Top")
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${context}")
//    private String context;

//    @Autowired
//    private GirlPropertise girlp;

    @RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET)
    //@GetMapping("/hello")
    //@RequestMapping(value = {"/hello/{id}"}, method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", defaultValue = "0",required = false) Integer id){
                        //@PathVariable("id") Integer id
        //return cupSize+age;
       // return  "Hellow Spring Boot!";
       // return girlp.getCupSize();
        return "id:"+id;
    }



}
