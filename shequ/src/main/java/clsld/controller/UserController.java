package clsld.controller;

import clsld.dao.Userdao;
import clsld.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {
    @Autowired
    public Userdao userdao;
    private HashMap<Integer,String> map;
    @RequestMapping(value = "getUserById")
    public user getUserByid(@RequestParam("userid")String userid){
        user user = new user();
        user = userdao.getOne(userid);
        return user;
    }
}
