package com.example.springbootmydiaryserver.note;

public class NoteNotFoundException extends RuntimeException{

    public NoteNotFoundException(Long id) {
        super("Could not find the note " + id);
    }
}