package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product emptyProduct = new Product();
    private Product first = new Product(1, "Google It!: A History of Google", 14_62);
    private Product second = new Product(2, "Samsung Galaxy M12 Smartphone", 127_00);
    private Product third = new Product(1, "Google It!: A History of Google", 14_62);
    private Book fourth = new Book();
    private Product fifth = new Product(5, "Google It!: A History of Google", 14_62);
    private Product sixth = new Product(1, "Google It!: A History of Google", 14_00);
    private Product seventh = new Product(1, "Google It!", 14_62);

    //Constructor without parameters
    @Test
    void shouldGetIdEmpty() {
        int expected = 0;
        int actual = emptyProduct.getId();

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetNameEmpty() {
        String expected = null;
        String actual = emptyProduct.getName();

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetPriceEmpty() {
        int expected = 0;
        int actual = emptyProduct.getPrice();

        assertEquals(expected, actual);
    }

    //Constructor with parameters
    @Test
    void shouldGetId() {
        int expected = 1;
        int actual = first.getId();

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetName() {
        String expected = "Google It!: A History of Google";
        String actual = first.getName();

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetPrice() {
        int expected = 14_62;
        int actual = first.getPrice();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetId() {
        int expected = 4;
        first.setId(4);
        int actual = first.getId();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetName() {
        String expected = "Google It!";
        first.setName("Google It!");
        String actual = first.getName();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetPrice() {
        int expected = 10_00;
        first.setPrice(10_00);
        int actual = first.getPrice();

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
        boolean actual = first.equals(fourth);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualNull() {
        boolean expected = false;
        boolean actual = first.equals(null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualAnd() {
        boolean expected = false;
        boolean actual = first.equals(fifth);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualAnd1() {
        boolean expected = false;
        boolean actual = first.equals(sixth);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualAnd2() {
        boolean expected = false;
        boolean actual = first.equals(seventh);
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestHashCode() {
        int expected = 1893842836;
        int actual = first.hashCode();

        assertEquals(expected, actual);
    }

    @Test
    void shouldTestToString() {
        String expected = "Product{id=1, name='Google It!: A History of Google', price=1462}";
        String actual = first.toString();

        assertEquals(expected, actual);
    }
}