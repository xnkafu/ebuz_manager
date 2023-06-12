package com.selacha.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Note;

public interface NoteRepo extends JpaRepository<Note,Long>{

}
