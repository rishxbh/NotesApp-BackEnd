package com.rishabh.notes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.notes.entity.Shared;
import com.rishabh.notes.repo.SharedRepo;

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

}
