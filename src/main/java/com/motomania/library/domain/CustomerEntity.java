package com.motomania.library.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "customer")
@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private LibraryEntity library;

    @OneToMany(mappedBy = "customer", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BookEntity> books = new ArrayList<>();
}
