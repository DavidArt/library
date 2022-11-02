package com.motomania.library.service;

import com.motomania.library.domain.BookEntity;
import com.motomania.library.dto.Book;
import com.motomania.library.repo.BookRepo;
import com.motomania.library.util.MapperUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;
    private final MapperUtil mapperUtil;

    public BookService(BookRepo bookRepo, MapperUtil mapperUtil) {
        this.bookRepo = bookRepo;
        this.mapperUtil = mapperUtil;
    }

    public Book getBook(Long id) {
        BookEntity bookEntity = bookRepo
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No book found with id = " + id));

        return mapperUtil.map(bookEntity, Book.class);
    }

    public List<Book> getAllBooks() {
        List<BookEntity> bookEntityList = bookRepo.findAll();

        return mapperUtil.mapList(bookEntityList, Book.class);
    }

    public List<Book> getAllBooksByAuthorId(Long authorId) {
        List<BookEntity> bookEntityList = bookRepo.findAllByAuthorId(authorId);

        return mapperUtil.mapList(bookEntityList, Book.class);
    }

    public List<Book> getAllBooksByLibraryId(Long libraryId) {
        List<BookEntity> bookEntityList = bookRepo.findAllByLibraryId(libraryId);

        return mapperUtil.mapList(bookEntityList, Book.class);
    }

    public List<Book> getAllBooksByCustomerId(Long customerId) {
        List<BookEntity> bookEntityList = bookRepo.findAllByCustomerId(customerId);

        return mapperUtil.mapList(bookEntityList, Book.class);
    }

    public Book createBook(Book book) {
        BookEntity savedBook = bookRepo.save(
                mapperUtil.map(book, BookEntity.class));

        return mapperUtil.map(savedBook, Book.class);
    }

    public Book updateBook(Book book) {
        BookEntity savedBook = bookRepo.save(
                mapperUtil.map(book, BookEntity.class));

        return mapperUtil.map(savedBook, Book.class);
    }

    public void deleteBook(Long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        }
    }
}
