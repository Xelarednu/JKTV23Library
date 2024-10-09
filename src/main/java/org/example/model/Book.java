package org.example.model;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private static Long count;

    private Long id;
    private String  title;
    private Author[] author;
    private int publishYear;

    public Book() {
        id = count++;
    }

    public Book(String title, Author[] author, int publishYear) {
        id = count++;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author[] getAuthor() {
        return author;
    }

    public void setAuthor(Author[] author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publishYear == book.publishYear && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.deepEquals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, Arrays.hashCode(author), publishYear);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", author=").append(Arrays.toString(author));
        sb.append(", publishYear=").append(publishYear);
        sb.append('}');
        return sb.toString();
    }
}
