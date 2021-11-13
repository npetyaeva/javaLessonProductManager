package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone emptySmartphone = new Smartphone();

    private Smartphone first = new Smartphone(
            1, "Samsung Galaxy M12 Smartphone", 127_00, "Samsung Electronics"
    );
    private Smartphone second = new Smartphone(
            2, "Motorola One 5G Ace", 395_16, "Motorola"
    );
    private Smartphone third = new Smartphone(
            1, "Samsung Galaxy M12 Smartphone", 127_00, "Samsung Electronics"
    );

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
        int expected = 1667774487;
        int actual = first.hashCode();

        assertEquals(expected, actual);
    }
}