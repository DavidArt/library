package com.motomania.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.motomania.library.domain.BookEntity;
import com.motomania.library.domain.LibraryEntity;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private LibraryEntity libraryEntity;

    @JsonIgnore
    private List<BookEntity> books;
}
