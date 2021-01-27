package clsld.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class question {
    @Id
    private int question_id;
    private String title;
    private String content;
    private String userid;
    private int focus;
    private String username;

    public question(int question_id, String title, String content, String userid, int focus) {
        this.question_id = question_id;
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.focus = focus;
    }

    public question(int question_id, String title, String content, String userid, int focus, String username) {
        this.question_id = question_id;
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.focus = focus;
        this.username = username;
    }

    public question(String title, String content, String userid, int focus) {
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.focus = focus;
    }

    public question() {

    }

    public question(String title, String content, String userid, int focus, String username) {
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.focus = focus;
        this.username = username;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
