package com.nsproject.girl.server;

import com.nsproject.girl.domain.Girl;
import com.nsproject.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlServer {

    @Autowired
     private GirlRepository girlRepository;
    @Transactional
    public void girlAddTwo(){

        Girl girlA = new Girl();
        girlA.setCupSize("E");
        girlA.setAge(25);
        girlRepository.save(girlA);

        Girl  girlB = new Girl();
        girlB.setCupSize("C");
        girlB.setAge(21);
        girlRepository.save(girlB);

    }


    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age<10){
            throw new Exception("还在上小学");
        } else if (age>10 && age<16){
            throw new Exception("还在上中学");
        }
    }
}
