package com.motomania.library.controller;

import com.motomania.library.dto.Library;
import com.motomania.library.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("{id}")
    public Library getLibrary(@PathVariable Long id) {
        return libraryService.getLibrary(id);
    }

    @GetMapping("/all")
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryService.createLibrary(library);
    }

    @PutMapping
    public Library updateLibrary(@RequestBody Library library) {
        return libraryService.updateLibrary(library);
    }

    @DeleteMapping("{id}")
    public void deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
    }
}
