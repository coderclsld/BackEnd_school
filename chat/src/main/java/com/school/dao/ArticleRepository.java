package com.school.dao;
import com.school.entity.article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZKJ
 * @create 2020-12-08 11:35
 */
public interface ArticleRepository extends JpaRepository<article,Integer> {
}
