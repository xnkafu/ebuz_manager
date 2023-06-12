package com.selacha.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selacha.start.domain.Customer;
import com.selacha.start.domain.Employee;
import com.selacha.start.domain.Note;
import com.selacha.start.service.implementation.CustomerServiceImpl;
import com.selacha.start.service.implementation.EmployeeServiceImpl;
import com.selacha.start.service.implementation.NoteServiceImpl;

@RestController
@RequestMapping("v1/api/note")
//@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@CrossOrigin(origins = {"https://cvs-sand.vercel.app/", "http://localhost:3000"}, allowedHeaders = "*", allowCredentials = "true")
public class NotesController {
	
	@Autowired
	private NoteServiceImpl noteService;
	
	
	@PostMapping(value="/createNote", produces = "application/json")
	public  ResponseEntity<Note> registerEmployee(@RequestBody Note  note){
		Note noteTemp = noteService.saveNote(note);
		return noteTemp != null? new ResponseEntity<Note>(noteTemp, HttpStatus.OK): new ResponseEntity<>(HttpStatus.CONFLICT);

	}
	
	@GetMapping(value="/notes", produces = "application/json")
	public ResponseEntity<List<Note>> getEmployees(){
		return new ResponseEntity<List<Note>>(noteService.allNotes(),HttpStatus.OK);
		
	}
	

}
