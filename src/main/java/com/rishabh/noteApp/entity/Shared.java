package com.rishabh.noteApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "shared")
public class Shared {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int relationId;
	private int noteId;
	private int userId;
	public int getRelationId() {
		return relationId;
	}
	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Shared(int relationId, int noteId, int userId) {
		super();
		this.relationId = relationId;
		this.noteId = noteId;
		this.userId = userId;
	}
	public Shared() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Shared [relationId=" + relationId + ", noteId=" + noteId + ", userId=" + userId + "]";
	}
}
