package com.nsproject.girl.controller;

import com.nsproject.girl.domain.Girl;
import com.nsproject.girl.domain.Result;
import com.nsproject.girl.repository.GirlRepository;
import com.nsproject.girl.server.GirlServer;
import com.nsproject.girl.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlServer girlServer;


   /**
    * 查询所有女生列表
    *
    * */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();

    }
    /**
     * 往女生列表中加一个女生
     *
     *
     * */
    @RequestMapping(value = "/girls" , method = RequestMethod.POST)
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
       // Girl girl = new Girl();
      //  Result result = new Result();
        if (bindingResult.hasErrors()){

            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

            girl.setCupSize(girl.getCupSize());
            girl.setAge(girl.getAge());
            girl.setMoney(girl.getMoney());
            return ResultUtil.success(girlRepository.save(girl));
    }

    //查询一个女生
    @GetMapping(value="/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    //更新一个女生信息
    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age
                            ){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    //删除一个女生的信息
    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){

        girlRepository.delete(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value="/girls/age/{age}")
    public List<Girl> girlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    //同时插入两条数据
    @PostMapping(value="/girls/two")
    public void girlByTwo(){
        girlServer.girlAddTwo();
    }

    //根据女生年龄做判断
    @GetMapping(value="/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlServer.getAge(id);
    }



}
