package clsld.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user {
    @Id
    private String userid;
    private String nickname;
    private String genderclass;
    private Integer gender;
    private Integer studentNum;
    private String avatarUrl;

    public user(String userid, String nickname, String genderclass, Integer gender, Integer studentNum, String avatarUrl) {
        this.userid = userid;
        this.nickname = nickname;
        this.genderclass = genderclass;
        this.gender = gender;
        this.studentNum = studentNum;
        this.avatarUrl = avatarUrl;
    }

    public user() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGenderclass() {
        return genderclass;
    }

    public void setGenderclass(String genderclass) {
        this.genderclass = genderclass;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
