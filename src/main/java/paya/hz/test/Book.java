package paya.hz.test;

import java.io.Serializable;

/**
 * Created by sorin on 08.11.2016.
 */
public class Book implements Serializable {
    public Book() {
    }

    public Book(Long key) {
        this.key = key;
        this.title = "Title " + key;
        this.author = "Author " + key;
    }

    private Long key;
    private String title;
    private String author;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Title: " + title + "<br/>" + "Author: " + author + "<br/><br/>";
    }
}
