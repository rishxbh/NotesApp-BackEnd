package com.rishabh.noteApp.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.rishabh.noteApp.dto.NotesRequest;
import com.rishabh.noteApp.dto.NotesResponse;
import com.rishabh.noteApp.entity.Notes;
import com.rishabh.noteApp.exceptions.CannotAccessException;
import com.rishabh.noteApp.repository.NotesRepo;
import com.rishabh.noteApp.services.NotesService;
import com.rishabh.noteApp.services.SharedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesServiceImpl implements NotesService {
	
	@Autowired
	private NotesRepo notesRepo;
	
	@Autowired
	private SharedService sharedService;
	
	public List<NotesResponse> getSharedByUserId(int userId) {
		List<Integer> ids = sharedService.getNoteId(userId);
		return getByIds(ids);
	}
	
	private List<NotesResponse> getByIds(List<Integer> list) {
		List<Notes> notes = (List<Notes>) notesRepo.findAllById(list);
		List<NotesResponse> res = new ArrayList<>();
		for (Notes n : notes) {
			res.add(mapToNotesResponse(n));
		}
		return res;
	}
	
	public List<NotesResponse> findAllByUserId(int userID) {
		List<Notes> list = (List<Notes>) notesRepo.findByUserId(userID);
		List<NotesResponse> res = new ArrayList<>();
		for (Notes n : list) {
			res.add(mapToNotesResponse(n));
		}
		return res;
	}
	private NotesResponse mapToNotesResponse(Notes note) {
		return new NotesResponse(note.getId(), note.getUserId(), note.getContent());
	}
	@Override
	public NotesResponse postNote(NotesRequest req, int userId) {
		Notes newNote = new Notes();
		newNote.setUserId(userId);
		newNote.setContent(req.getContent());
		Notes response = notesRepo.save(newNote);
		return mapToNotesResponse(response);
	}
	@Override
	public void deleteNote(int id, int userId) throws CannotAccessException {
		// TODO Auto-generated method stub
		if(notesRepo.findById(id).get().getUserId() == userId) {
			notesRepo.deleteById(id);
		}
		else {
			new CannotAccessException("Cannot access unauthorized note");
		}
	}

}
