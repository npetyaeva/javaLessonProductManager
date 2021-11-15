package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private final Product emptyProduct = new Product();
    private final Product first = new Product(1, "Google It!: A History of Google", 14_62);
    private final Product second = new Product(2, "Samsung Galaxy M12 Smartphone", 127_00);
    private final Product third = new Product(1, "Google It!: A History of Google", 14_62);
    private final Book fourth = new Book();
    private final Product fifth = new Product(5, "Google It!: A History of Google", 14_62);
    private final Product sixth = new Product(1, "Google It!: A History of Google", 14_00);
    private final Product seventh = new Product(1, "Google It!", 14_62);

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
    void shouldUseEqualsTrue() {
        boolean actual = first.equals(third);
        assertTrue(actual);
    }

    @Test
    void shouldUseEqualsFalse() {
        boolean actual = first.equals(second);
        assertFalse(actual);
    }

    @Test
    void shouldCanEqualsLink() {
        boolean actual = first.equals(first);
        assertTrue(actual);
    }

    @Test
    void shouldCanEqualsClass() {
        boolean actual = first.equals(fourth);
        assertFalse(actual);
    }

    @Test
    void shouldCanEqualsNull() {
        boolean actual = first.equals(null);
        assertFalse(actual);
    }

    @Test
    void shouldCanEqualsReturnId() {
        boolean actual = first.equals(fifth);
        assertFalse(actual);
    }

    @Test
    void shouldCanEqualsReturnPrice() {
        boolean actual = first.equals(sixth);
        assertFalse(actual);
    }

    @Test
    void shouldCanEqualsReturnName() {
        boolean actual = first.equals(seventh);
        assertFalse(actual);
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