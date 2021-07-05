package clsld.controller;

import clsld.dao.UserDao;
import clsld.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {
    @Autowired
    public UserDao userdao;
    private HashMap<Integer,String> map;
    @RequestMapping(value = "getUserById")
    public user getUserByid(@RequestParam("userid")String userid){
        return userdao.getOne(userid);
    }
//    private String userid;
//    private String nickname;
//    private String genderclass;
//    private Integer gender;
//    private Integer studentNum;
//    private String avatarUrl;
    @RequestMapping(value = "addUser")
    public boolean addUser(@RequestParam("userid")String userid,
                           @RequestParam("nickname")String nickname,
                           @RequestParam("genderclass")String genderclass,
                           @RequestParam("gender")Integer gender,
                           @RequestParam("studentNum")Integer studentNum,
                           @RequestParam("avatarUrl")String avatarUrl){
        user user = new user();
        user.setUserid(userid);user.setNickname(nickname);user.setGenderclass(genderclass);
        user.setGender(gender);user.setStudentNum(studentNum);user.setAvatarUrl(avatarUrl);
        userdao.save(user);
        return true;
    }
}
