package com.motomania.library.repo;

import com.motomania.library.domain.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<LibraryEntity, Long> {
}
