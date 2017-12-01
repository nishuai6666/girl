package com.nsproject.girl.repository;

import com.nsproject.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer>{

  public List<Girl> findByAge(Integer age);



}
