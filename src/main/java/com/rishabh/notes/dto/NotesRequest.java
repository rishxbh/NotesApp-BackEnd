package com.rishabh.notes.dto;

public class NotesRequest {
	
	private int userId;
	private String content;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public NotesRequest(int userId, String content) {
		this.userId = userId;
		this.content = content;
	}
	public NotesRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NotesResponse [userId=" + userId + ", content=" + content + "]";
	}
	
}
