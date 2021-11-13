package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book emptyBook = new Book();

    private Book first = new Book(
            1, "Google It!: A History of Google", 14_62, "Anna Crowley Redding"
    );
    private Book second = new Book(
            2, "Java: A Beginner's Guide", 19_94, "Herbert Schildt"
    );
    private Book third = new Book(
            1, "Google It!: A History of Google", 14_62, "Anna Crowley Redding"
    );

    //Constructor without parameters
    @Test
    void shouldGetAuthorNoArg() {
        String expected = null;
        String actual = emptyBook.getAuthor();

        assertEquals(expected, actual);
    }

    //Constructor with parameters
    @Test
    void shouldGetAuthorAllArg() {
        String expected = "Anna Crowley Redding";
        String actual = first.getAuthor();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetAuthor() {
        String expected = "Anna";
        first.setAuthor("Anna");
        String actual = first.getAuthor();

        assertEquals(expected, actual);
    }

    @Test
    void shouldTestToString() {
        String expected = "Book(author=Anna Crowley Redding)";
        String actual = first.toString();

        assertEquals(expected, actual);
    }

    @Test
    void shouldUseEqualTrue() {
        boolean expected = true;
        boolean actual = first.equals(third);
        assertEquals(expected, actual);
    }

    @Test
    void shouldUseEqualFalse() {
        boolean expected = false;
        boolean actual = first.equals(second);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualLink() {
        boolean expected = true;
        boolean actual = first.equals(first);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualClass() {
        boolean expected = false;
        boolean actual = first.equals(null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestHashCode() {
        int expected = 289127717;
        int actual = first.hashCode();

        assertEquals(expected, actual);
    }
}