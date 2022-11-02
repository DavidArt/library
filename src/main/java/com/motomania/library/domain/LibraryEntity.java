package com.motomania.library.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "library")
@Entity
public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "library", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BookEntity> books = new ArrayList<>();

    @OneToMany(mappedBy = "library", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CustomerEntity> customers = new ArrayList<>();
}
