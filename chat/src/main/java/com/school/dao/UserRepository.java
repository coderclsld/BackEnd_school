package com.school.dao;


import com.school.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ZKJ
 * @create 2020-09-27 18:29
 */
@Repository
public interface UserRepository extends JpaRepository<user,Integer> {

}
