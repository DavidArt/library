package com.motomania.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.motomania.library.domain.AuthorEntity;
import com.motomania.library.domain.LibraryEntity;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    private Long id;
    private String name;
    private String description;
    private int releaseYear;
    private AuthorEntity author;
    private LibraryEntity libraryEntity;
}
