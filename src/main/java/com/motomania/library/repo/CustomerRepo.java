package com.motomania.library.repo;

import com.motomania.library.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAllByLibraryId(Long libraryId);
}

