package clsld.controller;


import clsld.dao.QuestionDao;
import clsld.entity.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class QuestionController {
    @Autowired
    public QuestionDao qdao;
//    增加一条问题
    @RequestMapping(value = "/addQuestion")
    public boolean addQuestion(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("userid") String userid,@RequestParam("username") String username){
        int focus = 0;
        try {
            question question = new question(title,content,userid,focus,username);
            qdao.save(question);
            return true;
        }catch (Exception e) {
            return false;
        }

    }
//    删除一条问题
    @GetMapping("/deleteQuestion")
    public boolean deleteQuestion(@RequestParam("question_id") int question_id) {
        try {
            qdao.deleteById(question_id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//    得到所有问题，后续需要改为分表模式
    @GetMapping("/getQuestion")
    public List<question> getQuestion(){
        return qdao.findAll();
    }
//    查询一条问题，目前想不出有什么用先放着
    @GetMapping("/selectQuestion")
    public Optional<question> selectQuestionById(@RequestParam("question_id") int question_id){
        return qdao.findById(question_id);

    }
//    增加关注数
    @GetMapping("/addfocus")
    public int addfocus(@RequestParam("question_id") int question_id){
        try {
            qdao.addfocus(question_id);
        }catch (Exception e) {
            return 404;
        }
        return qdao.getfocus(question_id);
    }
//    减少关注数
    @GetMapping("/cutfocus")
    public int cutfocus(@RequestParam("question_id") int question_id){
        try {
            qdao.cutfocus(question_id);
        }catch (Exception e){
            return 404;
        }
        return qdao.getfocus(question_id);
    }
}
