package com.lll.dao;

import com.lll.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZKJ
 * @create 2020-09-27 18:29
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
