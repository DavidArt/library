package com.motomania.library.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "book")
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private LibraryEntity library;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
