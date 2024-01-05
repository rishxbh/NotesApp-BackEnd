package com.rishabh.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.notes.dto.NotesRequest;
import com.rishabh.notes.dto.NotesResponse;
import com.rishabh.notes.entity.Notes;
import com.rishabh.notes.service.NotesService;

@RestController
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	@GetMapping("/shared/{id}")
	public ResponseEntity<List<NotesResponse>> getSharedByUserId(@PathVariable("id") int userId) {
		List<NotesResponse> notes = notesService.getSharedByUserId(userId);
		if (notes != null)
			return ResponseEntity.status(HttpStatus.OK).body(notes);
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<NotesResponse>> getNotesByUserId(@PathVariable("id") int userId) {
		List<NotesResponse> notes = notesService.findAllByUserId(userId);
		if (notes != null)
			return ResponseEntity.status(HttpStatus.OK).body(notes);
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PostMapping("/post")
	public ResponseEntity<NotesResponse> postNote(@RequestBody NotesRequest notesRequest) {
		NotesResponse res = notesService.postNote(notesRequest);
		if (res != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(res);
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteNote(@PathVariable("id") int id) {
		notesService.deleteNote(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
