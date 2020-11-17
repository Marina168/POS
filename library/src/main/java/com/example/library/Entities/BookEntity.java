package com.example.library.Entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="publisher",nullable = false)
    private String publisher;

    @Column(name="genre",nullable = false)
    private String genre;

    @Column(name="published",nullable = false)
    private LocalDate publishedDate;

    @Column(name="summary")
    private String summary;

   /*@ManyToOne(fetch =FetchType.LAZY,optional = false)
    @JoinColumn(
            name="author_id",
            nullable = false,
            foreignKey = @ForeignKey(name="fk_books_authors_id")
    )
    private BookEntity book;*/


    public BookEntity()
    {

    }

    public BookEntity(String title,String publisher,String genre,LocalDate publishedDate, String summary)
    {
        this.title=title;
        this.publisher=publisher;
        this.genre=genre;
        this.publishedDate=publishedDate;
        this.summary=summary;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublishedDate(){
return publishedDate;
}
    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }



}
