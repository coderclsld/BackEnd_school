package clsld.controller;


import clsld.dao.answerdao;
import clsld.entity.answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private answerdao adao;
//    添加回答
    @GetMapping("/addAnswer")
    public boolean addAnswer(@RequestParam("answer") String answer,@RequestParam("userid") String userid,@RequestParam("question_id") int question_id,@RequestParam("username") String username){
        try{
            int zang = 0;
            answer Ranswer  =new answer(answer, userid, question_id,zang,username);
            adao.save(Ranswer);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
//    删除回答
    @GetMapping("/deleteAnswer")
    public boolean deleteAnswer(@RequestParam("answer_id") int answer_id){
        try {
            adao.deleteById(answer_id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
//    获得所有回答
    @GetMapping("/getAllAnswers")
    public List<answer> getAllAnswers(){
        return adao.findAll();
    }
//获得属于特定的question_id的回答
    @GetMapping("/getAnswerByQId")
    public List<answer> getAnswerByQId(@RequestParam("question_id")int question_id){
        return adao.selectOneAnswer(question_id);
    }
    @GetMapping("/getAnswerById")
    public answer getAnswerById(@RequestParam("answer_id")int answer_id){
        return adao.getAnswerById(answer_id);
    }

    //    点赞
    @GetMapping("/addZang")
    public int addZang(@RequestParam("answer_id")int answer_id){
        try {
        adao.addZang(answer_id);
        }catch (Exception e) {
            return 404;
        }
        return adao.getZang(answer_id);
    }
//    减赞
    @GetMapping("cutZang")
    public int cutZang(@RequestParam("answer_id") int answer_id){
        try {
        adao.cutZang(answer_id);
        }catch (Exception e) {
            return 404;
        }
        return adao.getZang(answer_id);
    }
}

