package com.codenerve.streams.domain;

public class Book implements Comparable<Book>{

    private final String title;
    private final String author;
    private final int rating;

    public Book(String title, String author, int rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Book book) {
        return book.getAuthor().compareTo(this.getAuthor());
    }
}