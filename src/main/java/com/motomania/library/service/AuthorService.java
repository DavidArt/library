package com.motomania.library.service;

import com.motomania.library.domain.AuthorEntity;
import com.motomania.library.dto.Author;
import com.motomania.library.repo.AuthorRepo;
import com.motomania.library.util.MapperUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final MapperUtil mapperUtil;

    public AuthorService(AuthorRepo authorRepo, MapperUtil mapperUtil) {
        this.authorRepo = authorRepo;
        this.mapperUtil = mapperUtil;
    }

    public Author getAuthor(Long id) {
        AuthorEntity authorEntity = authorRepo
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No author found with id = " + id));

        return mapperUtil.map(authorEntity, Author.class);
    }

    public List<Author> getAllAuthors() {
        List<AuthorEntity> authorEntityList = authorRepo.findAll();

        return mapperUtil.mapList(authorEntityList, Author.class);
    }

    public Author createAuthor(Author author) {
        AuthorEntity savedAuthor = authorRepo.save(
                mapperUtil.map(author, AuthorEntity.class));

        return mapperUtil.map(savedAuthor, Author.class);
    }

    public Author updateAuthor(Author author) {
        AuthorEntity savedAuthor = authorRepo.save(
                mapperUtil.map(author, AuthorEntity.class));

        return mapperUtil.map(savedAuthor, Author.class);
    }

    public void deleteAuthor(Long id) {
        if (authorRepo.existsById(id)) {
            authorRepo.deleteById(id);
        }
    }
}
