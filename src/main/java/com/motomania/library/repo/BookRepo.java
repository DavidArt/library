package com.motomania.library.repo;

import com.motomania.library.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findAllByAuthorId(Long authorId);

    List<BookEntity> findAllByLibraryId(Long libraryId);

    List<BookEntity> findAllByCustomerId(Long customerId);
}
