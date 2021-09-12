package dev.mwhyte.streams.lists;

import dev.mwhyte.streams.domain.Book;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListFiltering {

    private final List<Book> books = asList(
            new Book("Clean Code", "Robert Martin", 5),
            new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "Eric Gamma", 4),
            new Book("Patterns of Enterprise Application Architecture", "Martin Fowler", 3),
            new Book("Enterprise Integration Patterns", "Gregor Hohpe", 5),
            new Book("The Mythical Man-Month", "Frederick Brooks", 4),
            new Book("Code Complete", "Steve McConnell", 3),
            new Book("Git for Teams", "Emma Hogbin Westby", 5),
            new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", 4),
            new Book("The Art of Unit Testing", "Roy Osherove", 3),
            new Book("Soft Skills: The Software Developer’s Life Manual", "John Sonmez", 5));

    private final Predicate<Book> patternBooks = book -> book.getTitle().contains("Patterns");

    @Test
    void filter_five_star_books() {

        List<Book> fiveStarBooks = books.stream()
                .filter(book -> book.getRating() == 5)
                .collect(Collectors.toList());

        assertThat(fiveStarBooks.size(), is(equalTo(4)));
    }

    @Test
    void filter_five_star_git_books() {
        List<Book> fiveStarGitBooks = books.stream()
                .filter(book -> book.getRating() == 5)
                .filter(book -> book.getTitle().contains("Git"))
                .collect(Collectors.toList());

        assertThat(fiveStarGitBooks.size(), is(equalTo(1)));
    }

    @Test
    void filter_even_ratings() {
        List<Book> bookILike = books.stream()
                .filter(book -> {
                    return book.getRating() % 2 == 0;
                })
                .collect(Collectors.toList());

        assertThat(bookILike.size(), is(equalTo(3)));
    }

    @Test
    void filter_pattern_books() {
        List<Book> fiveStarBooks = books.stream()
                .filter(patternBooks)
                .collect(Collectors.toList());

        assertThat(fiveStarBooks.size(), is(equalTo(3)));
    }

    @Test
    void find_a_robert_martin_book() {
        Optional<Book> aRobertMartinBook = books.stream()
                .filter(book -> book.getAuthor().contains("Martin Fowler"))
                .findAny();

        assertThat(aRobertMartinBook.get().getAuthor(), is(equalTo("Martin Fowler")));
    }

    @Test
    void find_a_martin_fowler_book() {
        Book aMartinFowlerBook = books.stream()
                .filter(book -> book.getAuthor().contains("Martin Fowler"))
                .findAny()
                .orElse(null);

        assertThat(aMartinFowlerBook.getAuthor(), is(equalTo("Martin Fowler")));
    }

    @Test
    void find_the_first_martin_fowler_book() {
        Book aMartinFowlerBook = books.stream()
                .filter(book -> book.getAuthor().contains("Martin Fowler"))
                .findFirst()
                .orElse(null);

        assertThat(aMartinFowlerBook.getTitle(), is(equalTo("Patterns of Enterprise Application Architecture")));
    }

    @Test
    void find_codenerves_awesome_book() {
        assertThrows(Exception.class, () ->
                books.stream()
                        .filter(book -> book.getAuthor().contains("Codenerve"))
                        .findFirst()
                        .orElseThrow(() -> new Exception("Codenerve hasn't written any good books yet :-(")));
    }
}