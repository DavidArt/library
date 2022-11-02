package com.motomania.library.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "author")
@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "author", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BookEntity> books = new ArrayList<>();
}
