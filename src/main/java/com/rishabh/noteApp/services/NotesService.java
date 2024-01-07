package com.rishabh.noteApp.services;

import java.util.List;

import com.rishabh.noteApp.dto.NotesRequest;
import com.rishabh.noteApp.dto.NotesResponse;
import com.rishabh.noteApp.exceptions.CannotAccessException;

public interface NotesService {
	List<NotesResponse> findAllByUserId(int userID);
	NotesResponse postNote(NotesRequest req, int userId);
	void deleteNote(int id, int userId) throws CannotAccessException;
	public List<NotesResponse> getSharedByUserId(int userId);
}
