package com.school.dao;
import com.school.entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ZKJ
 * @create 2020-12-06 2:02
 */
@Repository
public interface CommentRepository extends JpaRepository<comment,Integer> {
}
