package com.lll.dao;


import com.lll.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZKJ
 * @create 2020-12-08 11:35
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {
}
