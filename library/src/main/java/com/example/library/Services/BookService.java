package com.example.library.Services;

import com.example.library.Entities.BookEntity;
import com.example.library.Exceptions.ResourceNotFoundException;
import com.example.library.Repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);
    @Autowired
    private BookRepository bookRepository;
    private BookEntity book;

    public Iterable<BookEntity> findBooks() {
        return bookRepository.findAll();
    }

    public BookEntity BookById(UUID id) {
        Optional<BookEntity> book =  bookRepository.findById(id);
        System.out.println( bookRepository.findById(id));
        if (!book.isPresent()) {
            LOGGER.error("Book with id {} was not find ", id);
            throw new ResourceNotFoundException(BookEntity.class.getName() + "with id" + id);
        }

        return  book.get();
    }
    public UUID  insert(BookEntity carte)
    {
        BookEntity book =bookRepository.save(carte);
        LOGGER.error("Book with id {} was inserted in db", book.getId());
        return book.getId();
    }

    public BookEntity update(BookEntity newBook, UUID id)
    {
        Optional<BookEntity> updatedBook =bookRepository.findById(id);
        if(!updatedBook.isPresent())
        {
            LOGGER.error("Book with id {} was not find",id);
            throw new ResourceNotFoundException(BookEntity.class.getName() + "with id" + id);
        }

        newBook.setId(id);
        return bookRepository.save(newBook);


    }

    public void  deleteBookById(UUID id)
    {
        bookRepository.deleteById(id);
    }
}
