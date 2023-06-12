package com.selacha.start.service;

import java.util.List;

import com.selacha.start.domain.Note;

public interface NoteService {

	public Note saveNote(Note note);
	public Note  findById(long id);
	public List<Note> allNotes();
}
