package com.example.springbootmydiaryserver.note;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
@AllArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public List<Note> findAllNotes() {
        return noteService.findAllNotes();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public Note saveNote(@RequestBody NoteRequest request) {
        return noteService.saveNote(request);
    }

    @GetMapping("{noteId}")
    public EntityModel<Note> showNote(@PathVariable Long noteId) {
        return noteService.showNote(noteId);
    }

    @PutMapping(path = "{noteId}")
    public Note updateNote(@RequestBody NoteRequest noteRequest, @PathVariable Long noteId) {
        return noteService.updateNote(noteRequest, noteId);
    }

    @DeleteMapping("{noteId}")
    public String deleteNote(@PathVariable Long noteId) {
        return noteService.deleteNote(noteId);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllNotes() {
        return noteService.deleteAllNotes();
    }
}
