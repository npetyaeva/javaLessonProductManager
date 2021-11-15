package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private final Book emptyBook = new Book();

    private final Book first = new Book(
            1, "Google It!: A History of Google", 14_62, "Anna Crowley Redding"
    );
    private final Book second = new Book(
            2, "Java: A Beginner's Guide", 19_94, "Herbert Schildt"
    );
    private final Book third = new Book(
            1, "Google It!: A History of Google", 14_62, "Anna Crowley Redding"
    );
    private final Product fourth = new Product();

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
    void shouldEqualsTrue() {
        boolean actual = first.equals(third);
        assertTrue(actual);
    }

    @Test
    void shouldEqualsFalse() {
        boolean actual = first.equals(second);
        assertFalse(actual);
    }

    @Test
    void shouldEqualsLinkTrue() {
        boolean actual = first.equals(first);
        assertTrue(actual);
    }

    @Test
    void shouldEqualsNullFalse() {
        boolean actual = first.equals(null);
        assertFalse(actual);
    }

    @Test
    void shouldEqualsClassFalse() {
        boolean actual = first.equals(fourth);
        assertFalse(actual);
    }

    @Test
    void shouldTestHashCode() {
        int expected = 1777118612;
        int actual = first.hashCode();
        assertEquals(expected, actual);
    }
}