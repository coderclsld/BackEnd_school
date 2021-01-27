package com.school.util;


import java.util.List;

/**
 * @author ZKJ
 * @create 2020-12-07 0:40
 */
public class Node {

    public Integer id;
    public Integer userId;
    public String userNickName;
    public Integer articleId;
    public Integer parentId;
    public String content;
    public Integer status;
    public String parentName;
    public List<Node> children ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", userId=" + userId +
                ", userNickName='" + userNickName + '\'' +
                ", articleId=" + articleId +
                ", parentId=" + parentId +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", parentName='" + parentName + '\'' +
                ", children=" + children +
                '}';
    }
}