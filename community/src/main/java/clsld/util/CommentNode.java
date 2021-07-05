package clsld.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


public class CommentNode {

    private Integer comment_id;
    private String userid;
    private Integer parent_id;
    private String content;
    private Integer answer_id;
    private String username;
    private String avatar_url;
    private String parent_name;
    public List<CommentNode> children ;

    public CommentNode() {
    }

    public CommentNode(Integer comment_id, String userid, Integer parent_id, String content, Integer answer_id, String username, String avatar_url, String parent_name, List<CommentNode> children) {
        this.comment_id = comment_id;
        this.userid = userid;
        this.parent_id = parent_id;
        this.content = content;
        this.answer_id = answer_id;
        this.username = username;
        this.avatar_url = avatar_url;
        this.parent_name = parent_name;
        this.children = children;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public List<CommentNode> getChildren() {
        return children;
    }

    public void setChildren(List<CommentNode> children) {
        this.children = children;
    }
}