package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private final Smartphone emptySmartphone = new Smartphone();

    private final Smartphone first = new Smartphone(
            1, "Samsung Galaxy M12 Smartphone", 127_00, "Samsung Electronics"
    );
    private final Smartphone second = new Smartphone(
            2, "Motorola One 5G Ace", 395_16, "Motorola"
    );
    private final Smartphone third = new Smartphone(
            1, "Samsung Galaxy M12 Smartphone", 127_00, "Samsung Electronics"
    );
    private final Product fourth = new Product();

    //Constructor without parameters
    @Test
    void shoulsGetMakerNoArg() {
        String expected = null;
        String actual = emptySmartphone.getMaker();
        assertEquals(expected, actual);
    }

    //Constructor with parameters
    @Test
    void shoulsGetMakerAllArg() {
        String expected = "Samsung Electronics";
        String actual = first.getMaker();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetMaker() {
        String expected = "Samsung";
        first.setMaker("Samsung");
        String actual = first.getMaker();
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestToString() {
        String expected = "Smartphone(maker=Samsung Electronics)";
        String actual = first.toString();
        assertEquals(expected, actual);
    }

    @Test
    void shouldUseEqualTrue() {
        boolean actual = first.equals(third);
        assertTrue(actual);
    }

    @Test
    void shouldUseEqualFalse() {
        boolean actual = first.equals(second);
        assertFalse(actual);
    }

    @Test
    void shouldCanEqualLink() {
        boolean actual = first.equals(first);
        assertTrue(actual);
    }

    @Test
    void shouldCanEqualNull() {
        boolean actual = first.equals(null);
        assertFalse(actual);
    }

    @Test
    void shouldCanEqualClass() {
        boolean actual = first.equals(fourth);
        assertFalse(actual);
    }

    @Test
    void shouldTestHashCode() {
        int expected = 2084819786;
        int actual = first.hashCode();
        assertEquals(expected, actual);
    }
}