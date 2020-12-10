package com.lll.Test1;

/**
 * @author ZKJ
 * @create 2020-12-07 0:36
 */
public class CommentInfo {

    public Integer id;
    public Integer userId;
    public String userNickName;
    public Integer articleId;
    public Integer parentId;
    public String parentName;
    public String content;
    public Integer status;

    public CommentInfo() {
    }

	public CommentInfo(Integer id, Integer userId, String userNickName, Integer articleId, Integer parentId, String parentName, String content, Integer status) {
		this.id = id;
		this.userId = userId;
		this.userNickName = userNickName;
		this.articleId = articleId;
		this.parentId = parentId;
		this.parentName = parentName;
		this.content = content;
		this.status = status;
	}

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

	@Override
	public String toString() {
		return "CommentInfo{" +
				"id=" + id +
				", userId=" + userId +
				", userNickName='" + userNickName + '\'' +
				", articleId=" + articleId +
				", parentId=" + parentId +
				", parentName='" + parentName + '\'' +
				", content='" + content + '\'' +
				", status=" + status +
				'}';
	}
}
