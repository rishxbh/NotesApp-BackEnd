package com.rishabh.noteApp.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.rishabh.noteApp.entity.Shared;
import com.rishabh.noteApp.repository.SharedRepo;
import com.rishabh.noteApp.services.SharedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharedServiceImpl implements SharedService {
	
	@Autowired
	private SharedRepo sharedRepo;
	
	public List<Integer> getNoteId(int userId) {
		List<Shared> list = sharedRepo.findByUserId(userId);
		List<Integer> noteIds = new ArrayList<>();
		for(Shared s : list) {
			noteIds.add(s.getNoteId());
		}
		return noteIds;
	}

	@Override
	public Shared shareItem(int shareWithId, int noteId) {
		Shared shared = new Shared();
		shared.setNoteId(noteId);
		shared.setUserId(shareWithId);
		return sharedRepo.save(shared);
	}

}
