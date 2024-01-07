package com.rishabh.noteApp.repository;

import java.util.List;

import com.rishabh.noteApp.entity.Notes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotesRepo extends CrudRepository<Notes, Integer> {
	List<Notes> findByUserId(int userId);
}
