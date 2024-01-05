package com.rishabh.notes.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.notes.entity.Shared;

@Repository
public interface SharedRepo extends CrudRepository<Shared, Integer> {
	List<Shared> findByUserId(int userId);
}
