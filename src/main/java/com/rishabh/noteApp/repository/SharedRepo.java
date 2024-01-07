package com.rishabh.noteApp.repository;

import java.util.List;

import com.rishabh.noteApp.entity.Shared;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedRepo extends CrudRepository<Shared, Integer> {
	List<Shared> findByUserId(int userId);
}
