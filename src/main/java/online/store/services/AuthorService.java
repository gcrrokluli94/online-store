package online.store.services;

import online.store.model.Author;
import online.store.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> readAllAutor(){
        return authorRepository.findAll();
    }

    public Optional<Author> readAuthorById(Long authorId){
        return authorRepository.findById(authorId);
    }

}
