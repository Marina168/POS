package com.example.library.Controllers;

import com.example.library.Entities.AuthorEntity;
import com.example.library.Entities.BookEntity;
import com.example.library.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value="/library/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) { this.authorService=authorService;};

    @RequestMapping(value = "/show", method = {RequestMethod.GET})
    public ResponseEntity<String> getStatus() {
        System.out.println("Hello");
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }

    @RequestMapping(value="/all", method = { RequestMethod.GET })
    public Iterable<AuthorEntity> getAllAuthors() {
        Iterable<AuthorEntity> list = authorService.findAuthors();
        return list;
    }
    @RequestMapping(value="/{id}", method = { RequestMethod.GET })
    public ResponseEntity<AuthorEntity> getAuthorById(@PathVariable("id") int authorId) {
        AuthorEntity author = authorService.AuthorById(authorId);
        return new ResponseEntity<>(author,HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Integer> insertAuthor(@RequestBody AuthorEntity author )
    {
        int authorID = authorService.insertAuthor(author);
        return new ResponseEntity<Integer>(authorID,HttpStatus.CREATED);
    }
    @RequestMapping(value = "/add/{author_id}/book", method = RequestMethod.POST)
    public ResponseEntity<AuthorEntity> insertAuthor (@PathVariable("author_id") int authorId, @RequestBody int bookId)
    {
        AuthorEntity author = authorService.addBook(authorId,bookId);
        return new ResponseEntity<>(author,HttpStatus.CREATED);
    }

}
