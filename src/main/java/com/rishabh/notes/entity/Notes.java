package com.rishabh.notes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "notes_table")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public Notes(int id, int userId, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
	}
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Notes [id=" + id + ", userId=" + userId + ", content=" + content + "]";
	}
	
}