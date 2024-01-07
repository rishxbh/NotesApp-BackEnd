package com.rishabh.noteApp.services;

import com.rishabh.noteApp.entity.Shared;

import java.util.List;

public interface SharedService {
	List<Integer> getNoteId(int userId);
	Shared shareItem(int shareWithId, int noteId);
}
