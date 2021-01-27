package clsld.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class answer {
    @Id
    private int answer_id;
    private String answer;
    private int zang;
    private String userid;
    private int question_id;
    private String username;


    public answer(int answer_id, String answer, int zang, String userid, int question_id, String username) {
        this.answer_id = answer_id;
        this.answer = answer;
        this.zang = zang;
        this.userid = userid;
        this.question_id = question_id;
        this.username = username;
    }

    public answer(String answer, String userid, int question_id, int zang) {
        this.answer = answer;
        this.zang = zang;
        this.userid = userid;
        this.question_id = question_id;
    }

    public answer() {

    }

    public answer(String answer, String userid, int question_id, int zang, String username) {
        this.answer = answer;
        this.zang = zang;
        this.userid = userid;
        this.question_id = question_id;
        this.username = username;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getZang() {
        return zang;
    }

    public void setZang(int zang) {
        this.zang = zang;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
