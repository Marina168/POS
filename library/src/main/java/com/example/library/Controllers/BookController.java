package com.example.library.Controllers;

import com.example.library.Entities.BookEntity;
import com.example.library.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/library/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/show", method = {RequestMethod.GET})
    public ResponseEntity<String> getStatus() {
        System.out.println("Hello");
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }

    @RequestMapping(value="/all", method = { RequestMethod.GET })
    public Iterable<BookEntity> getAllBooks() {
        Iterable<BookEntity> lista = bookService.findBooks();
        return lista;
    }

    @RequestMapping(value="/{id}", method = { RequestMethod.GET })
    public ResponseEntity<BookEntity> getBookById(@PathVariable("id") UUID bookId) {
        BookEntity book = bookService.BookById(bookId);
        return new ResponseEntity<>(book,HttpStatus.OK);

    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<UUID> insertBook(@RequestBody BookEntity carte )
    {
        UUID bookID = bookService.insert(carte);
        return new ResponseEntity<>(bookID,HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBook(@RequestBody BookEntity carte, @PathVariable UUID id)
    {
        BookEntity carteUpdate=bookService.update(carte,id);
        return new ResponseEntity<>(carteUpdate,HttpStatus.OK);
    }
    @RequestMapping(value="/delete/{id}", method={RequestMethod.DELETE})
    @ResponseBody
    public String deleteBook(@PathVariable UUID id)
    {
        bookService.deleteBookById(id);
        return "Book has been deleted successfully";
    }
}
