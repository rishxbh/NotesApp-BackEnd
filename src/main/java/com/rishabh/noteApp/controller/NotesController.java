package com.rishabh.noteApp.controller;

import java.util.List;

import com.rishabh.noteApp.dto.NotesRequest;
import com.rishabh.noteApp.dto.NotesResponse;
import com.rishabh.noteApp.dto.SharedInput;
import com.rishabh.noteApp.entity.Shared;
import com.rishabh.noteApp.entity.User;
import com.rishabh.noteApp.exceptions.CannotAccessException;
import com.rishabh.noteApp.services.JwtService;
import com.rishabh.noteApp.services.NotesService;
import com.rishabh.noteApp.services.SharedService;
import com.rishabh.noteApp.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService userService;
	@Autowired
	private SharedService sharedService;

	Logger logger = LoggerFactory.getLogger(NotesController.class);
	
	@GetMapping("/shared")
	public ResponseEntity<List<NotesResponse>> getSharedByUserId(HttpServletRequest request) {
		int userId = getId(request);
		List<NotesResponse> notes = notesService.getSharedByUserId(userId);
		if (notes != null)
			return ResponseEntity.status(HttpStatus.OK).body(notes);
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	@GetMapping("/test")
	public String getString() {
		return "Helllooooo";
	}
	@GetMapping("/get")
	public ResponseEntity<List<NotesResponse>> getNotesByUserId(HttpServletRequest request) {
		logger.warn(">>>>>>>>>");
		int userId = getId(request);
		logger.warn(">>>>>>>>>" + userId);
		List<NotesResponse> notes = notesService.findAllByUserId(userId);
		if (notes != null)
			return ResponseEntity.status(HttpStatus.OK).body(notes);
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PostMapping("/post")
	public ResponseEntity<NotesResponse> postNote(@RequestBody NotesRequest notesRequest, HttpServletRequest request) {
		int userId = getId(request);
		NotesResponse res = notesService.postNote(notesRequest, userId);
		if (res != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(res);
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteNote(@PathVariable("id") int id, HttpServletRequest request) throws CannotAccessException {
		int userId = getId(request);
		notesService.deleteNote(id, userId);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PostMapping("/share-with")
	public ResponseEntity<Shared> shareNote(@RequestBody SharedInput sharedInput) {
		Shared s = sharedService.shareItem(sharedInput.getShareWithId(), sharedInput.getNoteId());
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}

	private String extract(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
			return authorizationHeader.substring(7);
		}
		return null;
	}
	private int getId(HttpServletRequest request) {
		String token = extract(request);

		String email = jwtService.extractUsername(token);
		logger.warn(">>>>>>>>>>>>" + email);
		User user = userService.loadByEmail(email);
		return user.getId();
	}
}
