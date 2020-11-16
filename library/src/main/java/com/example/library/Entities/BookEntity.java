package com.example.library.Entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="publisher",nullable = false)
    private String publisher;

    @Column(name="genre",nullable = false)
    private String genre;

    @Column(name="byear",nullable = false)
    private int year;

    @Column(name="summary",nullable = false)
    private String summary;

    public BookEntity()
    {

    }

    public BookEntity(String title,String publisher,String genre,int year, String summary)
    {
        this.title=title;
        this.publisher=publisher;
        this.genre=genre;
        this.year=year;
        this.summary=summary;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
