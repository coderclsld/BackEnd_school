package com.school.controller;

import com.school.Dao.CommentRepository;
import com.school.Dao.UserRepository;
import com.school.entity.Comment;
import com.school.util.CommentInfo;
import com.school.util.Node;
import com.school.util.RedisUtil;
import com.school.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public CommentRepository commentRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/aaa", produces = "application/json")
    public List<Node> asd(){
        List<CommentInfo> info = new ArrayList<>();

        info.add(new CommentInfo(1,7,"叶永",3,null,null,"文章 你写的真棒!",1));
        info.add(new CommentInfo(2,3,"YY",3,null,null,"这篇文章的人你是菜鸟吧!",1));
        info.add(new CommentInfo(3,1,"KJ",3,null,null,"一般一般吧!",1));
        info.add(new CommentInfo(4,5,"闪烁",3,1,"叶永","叶永你才是最真棒!",1));
        info.add(new CommentInfo(5,6,"O(∩_∩)O哈哈~",3	,4,"闪烁","不，闪烁你才是最真棒!",1));
        info.add(new CommentInfo(6,1,"KJ",3,2,"YY","梵蒂冈电风扇!",1));
        info.add(new CommentInfo(7,1,"KJ",3,3,"KJ","发生大幅度发梵蒂冈的兴奋地说热腾腾",1));

        TreeUtils treeUtils = new TreeUtils();
        List<Node> node = treeUtils.buildTree(info, 100);
        return node;
    }
    @RequestMapping("/bbb")
    public List<Comment> bbb(){
        return commentRepository.findAll();
    }

    @GetMapping("/wensocket")
    public Object reidsas(){
        return redisTemplate.opsForValue().get("a");
    }

}