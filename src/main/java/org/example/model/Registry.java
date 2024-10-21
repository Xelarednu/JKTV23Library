package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Registry implements Serializable {

    private UUID id;

    private User user;

    private Book book;

    private LocalDate bookBorrowDate;

    private LocalDate returnBookDate;

    public Registry() {

    }

    public Registry(User user, Book book, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.book = book;
        this.bookBorrowDate = startDate;
        this.returnBookDate = endDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBookBorrowDate() {
        return bookBorrowDate;
    }

    public void setBookBorrowDate(LocalDate bookBorrowDate) {
        this.bookBorrowDate = bookBorrowDate;
    }

    public LocalDate getReturnBookDate() {
        return returnBookDate;
    }

    public void setReturnBookDate(LocalDate returnBookDate) {
        this.returnBookDate = returnBookDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registry registry = (Registry) o;

        if (!Objects.equals(id, registry.id)) return false;
        if (!Objects.equals(user, registry.user)) return false;
        if (!Objects.equals(book, registry.book)) return false;
        if (!Objects.equals(bookBorrowDate, registry.bookBorrowDate)) return false;
        return Objects.equals(returnBookDate, registry.returnBookDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (bookBorrowDate != null ? bookBorrowDate.hashCode() : 0);
        result = 31 * result + (returnBookDate != null ? returnBookDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Registry{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", book=").append(book);
        sb.append(", startDate=").append(bookBorrowDate);
        sb.append(", endDate=").append(returnBookDate);
        sb.append('}');
        return sb.toString();
    }
}