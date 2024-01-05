package com.rishabh.notes.dto;

public class NotesResponse {
	
	private int id;
	private int userId;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public NotesResponse(int id, int userId, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
	}
	public NotesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NotesResponse [id=" + id + ", userId=" + userId + ", content=" + content + "]";
	}
}
