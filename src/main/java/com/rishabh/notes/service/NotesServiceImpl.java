package com.rishabh.notes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.notes.dto.NotesRequest;
import com.rishabh.notes.dto.NotesResponse;
import com.rishabh.notes.entity.Notes;
import com.rishabh.notes.repo.NotesRepo;

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
	public NotesResponse postNote(NotesRequest req) {
		Notes newNote = new Notes();
		newNote.setUserId(req.getUserId());
		newNote.setContent(req.getContent());
		Notes response = notesRepo.save(newNote);
		return mapToNotesResponse(response);
	}
	@Override
	public void deleteNote(int id) {
		// TODO Auto-generated method stub
		notesRepo.deleteById(id);
	}

}
