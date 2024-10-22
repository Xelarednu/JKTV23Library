package org.example.services;

import org.example.model.Author;
import org.example.repository.Repository;
import org.example.services.helpers.AppHelperAuthorInput;

import java.util.List;

public class AuthorService {

    private List<Author> authors;
    private final AppHelperAuthorInput appHelperAuthorInput;
    private final Repository<Author> repository;

    public AuthorService(List<Author> authors, AppHelperAuthorInput appHelperAuthorInput, Repository<Author> repository) {
        this.authors = authors;
        this.appHelperAuthorInput = appHelperAuthorInput;
        this.repository = repository;
    }

    public boolean addAuthor() {
        authors = appHelperAuthorInput.createAuthor();

        if (authors != null) {
            //authors.add(author);
            repository.save(authors);
            return true;
        } else {
            return false;
        }
    }

    public void authors() {
        appHelperAuthorInput.printAuthors();
    }

}