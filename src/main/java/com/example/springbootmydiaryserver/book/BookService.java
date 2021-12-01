package com.example.springbootmydiaryserver.book;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
  
  private final BookRepository bookRepository;

  public List<Book> findAll() {
    return bookRepository.findAll();
  }
  
  public Book save(Book book) {
    return bookRepository.save(book);
  }

  public Book findOne(Long bookId) {
    return bookRepository.findById(bookId)
            .orElseThrow(() -> new IllegalStateException("The specified book does not exists"));
  }
}
