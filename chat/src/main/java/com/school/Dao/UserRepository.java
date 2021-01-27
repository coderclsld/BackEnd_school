package com.school.Dao;


import com.school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZKJ
 * @create 2020-09-27 18:29
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
