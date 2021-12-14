package com.example.springbootmydiaryserver.note;


import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public Note saveNote(NoteRequest noteRequest) {
        return noteRepository.save(new Note(
                noteRequest.getTitle(),
                noteRequest.getContent()
        ));
    }

    public EntityModel<Note> showNote(Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow(

                () -> new NoteNotFoundException(noteId));

        return  EntityModel.of(note,
                linkTo(methodOn(NoteController.class).showNote(noteId)).withSelfRel(),
                linkTo(methodOn(NoteController.class).findAllNotes()).withRel("notes"));
    }

    public Note updateNote(NoteRequest noteRequest, Long noteId) {
        return noteRepository.findById(noteId)
                .map(note -> {
                    note.setTitle(noteRequest.getTitle());
                    note.setContent(noteRequest.getContent());
                    return noteRepository.save(note);
                })
                .orElseGet(() -> noteRepository.save(
                        new Note(noteRequest.getTitle(), noteRequest.getTitle())
                ));
    }

    public String deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);

        return "Note successfully deleted";
    }

    public ResponseEntity<String> deleteAllNotes() {
        noteRepository.deleteAllInBatch(() -> noteRepository.findAll().iterator());

        return ResponseEntity.ok("All notes successfully deleted");
    }
}