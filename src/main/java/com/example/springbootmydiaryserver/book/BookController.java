package com.example.springbootmydiaryserver.book;

import com.example.springbootmydiaryserver.embedables.Directory;
import com.example.springbootmydiaryserver.note.Note;
import com.example.springbootmydiaryserver.note.NoteRequest;
import com.example.springbootmydiaryserver.note.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final PublicationHouseService publicationHouseService;
    private final NoteService noteService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping
    public String saveNewBook() {

        // Create book
        Book b1 = new Book();
        b1.setName("spring data");
        b1.setDirectory(new Directory("SHELF--3"));
        b1.setPublicationDate(LocalDate.now());
        b1.setCreatedAt(LocalDate.now());
        b1.setAuthorName("Elie");
        b1.setAuthorPhone("0000099999");

        // Create notes for the book and save them

        NoteRequest note1 = new NoteRequest();
        note1.setTitle("First note");
        note1.setContent("This is the first note");
        Note savedNote = noteService.saveNote(note1);

        NoteRequest note2 = new NoteRequest();
        note2.setTitle("Second note");
        note2.setContent("This is the second note");
        Note savedNote2 = noteService.saveNote(note2);

        NoteRequest note3 = new NoteRequest();
        note3.setTitle("Third note");
        note3.setContent("This is the third note");
        Note savedNote3 = noteService.saveNote(note3);

        // Add notes to the book
        b1.setNote(new ArrayList<>());
        b1.getNote().add(savedNote);
        b1.getNote().add(savedNote2);
        b1.getNote().add(savedNote3);


        // Create a publication house
        PublicationHouse ph = new PublicationHouse();
        ph.setName("DRC house");
        ph.setBook(b1);

        // Add book to the publication house
        ph.setBook(b1);

        // Save the book
        bookService.save(b1);

        // Save the publication house
        publicationHouseService.save(ph);

        return "New book saved";
    }

    @GetMapping(path = "{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        return bookService.findOne(bookId);
    }


}
