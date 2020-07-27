package com.codenerve.streams.lists;

import com.codenerve.streams.comparators.CustomComparator;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListSorting {

    // https://devconnected.com/the-10-best-software-engineering-books-in-2019/
    private final List<String> books = asList(
            "Clean Code",
            "Design Patterns: Elements of Reusable Object-Oriented Software",
            "Patterns of Enterprise Application Architecture",
            "Enterprise Integration Patterns",
            "The Mythical Man-Month",
            "Code Complete",
            "Git for Teams",
            "Refactoring: Improving the Design of Existing Code",
            "The Art of Unit Testing",
            "Soft Skills: The Software Developer’s Life Manual");

    @Test
    void sort_alphabetical() {
        List<Object> sortedList =
                books.stream()
                        .sorted()
                        .collect(toList());

        assertThat(sortedList.get(0), is(equalTo("Clean Code")));
        assertThat(sortedList.get(sortedList.size() -1), is(equalTo("The Mythical Man-Month")));
    }

    @Test
    void sort_reverse_alphabetical() {
        List<Object> sortedList =
                books.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(toList());

        assertThat(sortedList.get(0), is(equalTo("The Mythical Man-Month")));
        assertThat(sortedList.get(sortedList.size() -1), is(equalTo("Clean Code")));
    }

    @Test
    void sort_by_title_length() {
        List<Object> sortedList =
                books.stream()
                        .sorted(Comparator.comparing(String::length))
                        .collect(toList());

        assertThat(sortedList.get(0), is(equalTo("Clean Code"))); // the shortest title
        assertThat(sortedList.get(sortedList.size() -1), is(equalTo("Design Patterns: Elements of Reusable Object-Oriented Software"))); // the longest title
    }

    @Test
    void sort_by_custom_comparator() {
        List<Object> sortedList =
                books.stream()
                        .sorted(new CustomComparator())
                        .collect(toList());

        // the letter 3 occurs the most in this book.
        assertThat(sortedList.get(0), is(equalTo("Design Patterns: Elements of Reusable Object-Oriented Software")));
    }
}
