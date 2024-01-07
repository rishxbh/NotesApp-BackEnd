package com.rishabh.noteApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotesResponse {
	
	private int id;
	private int userId;
	private String content;
}
