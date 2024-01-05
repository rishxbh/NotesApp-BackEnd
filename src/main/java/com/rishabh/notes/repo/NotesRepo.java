package com.rishabh.notes.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.notes.entity.Notes;

@Repository
public interface NotesRepo extends CrudRepository<Notes, Integer> {
	List<Notes> findByUserId(int userId);
}
