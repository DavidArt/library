package com.motomania.library.service;

import com.motomania.library.domain.LibraryEntity;
import com.motomania.library.dto.Library;
import com.motomania.library.repo.LibraryRepo;
import com.motomania.library.util.MapperUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepo libraryRepo;
    private final MapperUtil mapperUtil;

    public LibraryService(LibraryRepo libraryRepo, MapperUtil mapperUtil) {
        this.libraryRepo = libraryRepo;
        this.mapperUtil = mapperUtil;
    }

    public Library getLibrary(Long id) {
        LibraryEntity libraryEntity = libraryRepo
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No library found with id = " + id));

        return mapperUtil.map(libraryEntity, Library.class);
    }

    public List<Library> getAllLibraries() {
        List<LibraryEntity> libraryEntityList = libraryRepo.findAll();

        return mapperUtil.mapList(libraryEntityList, Library.class);
    }

    public Library createLibrary(Library library) {
        LibraryEntity savedLibrary = libraryRepo.save(
                mapperUtil.map(library, LibraryEntity.class));

        return mapperUtil.map(savedLibrary, Library.class);
    }

    public Library updateLibrary(Library library) {
        LibraryEntity savedLibrary = libraryRepo.save(
                mapperUtil.map(library, LibraryEntity.class));

        return mapperUtil.map(savedLibrary, Library.class);
    }

    public void deleteLibrary(Long id) {
        if (libraryRepo.existsById(id)) {
            libraryRepo.deleteById(id);
        }
    }
}

