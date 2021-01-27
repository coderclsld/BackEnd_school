package clsld.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class comment {
    @Id
    private int comment_id;
    private String userid;
    private String parentId;
    private String content;
    private int answer_id;
    private String username;
    public comment() {
    }

    public comment(int comment_id, String userid, String parentId, String content, int answer_id, String username) {
        this.comment_id = comment_id;
        this.userid = userid;
        this.parentId = parentId;
        this.content = content;
        this.answer_id = answer_id;
        this.username = username;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
