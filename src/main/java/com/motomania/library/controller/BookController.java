package com.motomania.library.controller;

import com.motomania.library.dto.Book;
import com.motomania.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/author/{authorId}")
    public List<Book> getAllBooksByAuthorId(@PathVariable Long authorId) {
        return bookService.getAllBooksByAuthorId(authorId);
    }

    @GetMapping("/library/{libraryId}")
    public List<Book> getAllBooksByLibraryId(@PathVariable Long libraryId) {
        return bookService.getAllBooksByLibraryId(libraryId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Book> getAllBooksByCustomerId(@PathVariable Long customerId) {
        return bookService.getAllBooksByCustomerId(customerId);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
