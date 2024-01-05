package com.rishabh.notes.service;

import java.util.List;

import com.rishabh.notes.dto.NotesRequest;
import com.rishabh.notes.dto.NotesResponse;
import com.rishabh.notes.entity.Notes;

public interface NotesService {
	List<NotesResponse> findAllByUserId(int userID);
	NotesResponse postNote(NotesRequest req);
	void deleteNote(int id);
	public List<NotesResponse> getSharedByUserId(int userId);
}
