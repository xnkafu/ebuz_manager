package com.selacha.start.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.Note;
import com.selacha.start.repository.NoteRepo;
import com.selacha.start.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	private NoteRepo noteRepo;

	@Override
	public Note saveNote(Note note) {
		return noteRepo.save(note);
	}

	@Override
	public Note findById(long id) {

		return noteRepo.findById(id).get();
	}

	@Override
	public List<Note> allNotes() {
		// TODO Auto-generated method stub
		return noteRepo.findAll();
	}
	
	

}
