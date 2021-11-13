package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager repository = new ProductManager();

    private Product emptyProduct = new Product();
    private Book emptyBook = new Book();
    private Smartphone emptySmartphone = new Smartphone();

    private Smartphone first = new Smartphone(
            1, "Samsung Galaxy M12 Smartphone", 127_00, "Samsung Electronics"
    );
    private Book second = new Book(
            2, "Google It!: A History of Google", 14_62, "Anna Crowley Redding"
    );
    private Smartphone third = new Smartphone(
            1, "Samsung Galaxy M12 Smartphone", 127_00, "Samsung Electronics"
    );
    private Product fourth = new Product(4, "Java: A Beginner's Guide", 19_94);

    @Test
    void shouldSearchByFindSmartphone() {
        String text = "Electronics";
        Product[] expected = new Product[] { first, third };
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        Product[] actual = repository.searchBy("Electronics");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByFindBook() {
        String text = "Anna";
        Product[] expected = new Product[] { second };
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        Product[] actual = repository.searchBy("Anna");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByFindProduct() {
        String text = "Java: A Beginner's Guide";
        Product[] expected = new Product[] { fourth };
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        Product[] actual = repository.searchBy("Java: A Beginner's Guide");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotFind() {
        String text = "Java11";
        Product[] expected = new Product[] {};
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        Product[] actual = repository.searchBy("Java11");

        assertArrayEquals(expected, actual);
    }

/*    @Test
    void shouldAdd() {
        Product[] expected = new Product[] { first, second };
        repository.add(first);
        repository.add(second);
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllEmptyRepo() {
        Product[] expected = new Product[] {};
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        Product[] expected = new Product[] { first, second, third };
        repository.add(first);
        repository.add(second);
        repository.add(third);
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldMatchesSmartphoneTrue() {
        String text = "Electronics";
        boolean expected = true;
        boolean actual = repository.matches(first, text);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMatchesSmartphoneFalse() {
        String text = "Electronicc";
        boolean expected = false;
        boolean actual = repository.matches(first, text);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMatchesBookTrue() {
        String text = "Anna";
        boolean expected = true;
        boolean actual = repository.matches(second, text);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMatchesBookFalse() {
        String text = "Ana";
        boolean expected = false;
        boolean actual = repository.matches(second, text);

        assertEquals(expected, actual);
    }


    @Test
    void shouldMatchesProduct() {
        String text = "Java";
        boolean expected = false;
        boolean actual = repository.matches(fourth, text);

        assertEquals(expected, actual);
    }*/
}