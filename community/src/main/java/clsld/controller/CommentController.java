package clsld.controller;

import clsld.dao.CommentDao;
import clsld.entity.comment;
import clsld.util.CommentNode;
import clsld.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentDao commentdao;
    @RequestMapping(value = "/getCommentByAnswerId",produces = "application/json")
    public List<CommentNode> getCommentByAnswerId(@RequestParam("answerId") int answer_id){
        System.out.println(answer_id);
        List<comment> info= commentdao.getAllcommentByAnswerId(answer_id);
        System.out.println("info=>>>"+info);
//        List<comment> info = new ArrayList<>();
//        info.add(new comment(1,"7","叶永",3,null,null,"文章 你写的真棒!","1"));
//        info.add(new comment(2,"3","YY",3,null,null,"这篇文章的人你是菜鸟吧!","1"));
//        info.add(new comment(3,"1","KJ",3,null,null,"一般一般吧!","1"));
//        info.add(new comment(4,"5","闪烁",3,1,"叶永","叶永你才是最真棒!","1"));
//        info.add(new comment(5,"6","O(∩_∩)O哈哈~",3	,4,"闪烁","不，闪烁你才是最真棒!","1"));
//        info.add(new comment(6,"1","KJ",3,2,"YY","梵蒂冈电风扇!","1"));
//        info.add(new comment(7,"1","KJ",3,3,"KJ","发生大幅度发梵蒂冈的兴奋地说热腾腾","1"));
        TreeUtil treeUtils = new TreeUtil();
        List<CommentNode> node = treeUtils.buildTree(info, 100);
        return node;
    }
    @RequestMapping(value = "/addComment")
    public boolean addComment(@RequestParam("userid")String userid,@RequestParam("parent_id")Integer parent_id,
                              @RequestParam("content")String content,@RequestParam("answer_id")Integer answer_id,
                              @RequestParam("parent_name")String parent_name, @RequestParam("username")String username,
                              @RequestParam("avatar_url")String avatar_url){
        comment c = new comment();
        c.setUserid(userid);c.setParent_id(parent_id);c.setContent(content);c.setAvatar_url(avatar_url);
        c.setAnswer_id(answer_id);c.setParent_name(parent_name);c.setUsername(username);
        try {
            commentdao.save(c);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
