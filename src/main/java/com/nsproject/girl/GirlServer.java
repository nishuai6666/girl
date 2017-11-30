package com.nsproject.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlServer {

    @Autowired
     private GirlRepository girlRepository;
    @Transactional
    public void girlAddTwo(){

        Girl  girlA = new Girl();
        girlA.setCupSize("E");
        girlA.setAge(25);
        girlRepository.save(girlA);

        Girl  girlB = new Girl();
        girlB.setCupSize("C");
        girlB.setAge(21);
        girlRepository.save(girlB);

    }
}
