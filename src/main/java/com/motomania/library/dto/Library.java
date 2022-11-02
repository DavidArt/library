package com.motomania.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.motomania.library.domain.BookEntity;
import com.motomania.library.domain.CustomerEntity;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Library {

    private Long id;
    private String name;
    private String address;

    @JsonIgnore
    private List<BookEntity> books;

    @JsonIgnore
    private List<CustomerEntity> customers;
}
