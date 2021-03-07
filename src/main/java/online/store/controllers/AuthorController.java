package online.store.controllers;

import online.store.model.Author;
import online.store.model.DTO.AuthorDTO;
import online.store.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class AuthorController {


    @Autowired
    private AuthorService authorService;


    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors(){
        return ResponseEntity.ok().body(authorService.readAllAutor());
    }

    @GetMapping("/authors/{authorId}")
    public ResponseEntity<Optional<Author>> getAuthor(@PathVariable("authorId") final Long authorId ){
       return ResponseEntity.ok(authorService.readAuthorById(authorId));
    }

    @PostMapping("/newAuthor")
    public ResponseEntity<Author> saveAuthor(@RequestBody @Valid final AuthorDTO authorDTO ) {
        return ResponseEntity.ok(authorService.saveTheAuthor(authorDTO));

    }


}
