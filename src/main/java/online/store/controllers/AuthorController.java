package online.store.controllers;

import javassist.NotFoundException;
import online.store.model.Author;
//import online.store.model.errors.NotFoundException;
import online.store.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class AuthorController {



    @Autowired
    private AuthorService authorService;


    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthor(){
        return ResponseEntity.ok().body(authorService.readAllAutor());
    }

    @GetMapping("/authors/{authorId}")
    public ResponseEntity<Optional<Author>> getAuthor(@PathVariable("authorId") final Long authorId ) throws NotFoundException {
       return ResponseEntity.ok(authorService.readAuthorById(authorId));
    }


}
