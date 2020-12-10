package com.lll.dao;

import com.lll.entity.Comment;
import com.lll.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author ZKJ
 * @create 2020-12-06 2:02
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
