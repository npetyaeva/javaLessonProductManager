package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product emptyProduct = new Product();
    private Book emptyBook = new Book();
    private Smartphone emptySmartphone = new Smartphone();

    private Product first = new Product(1, "Java: A Beginner's Guide", 19_94);
    private Book second = new Book(
            2, "Google It!: A History of Google", 14_62, "Anna Crowley Redding"
    );
    private Smartphone third = new Smartphone(
            3, "Samsung Galaxy M12 Smartphone", 127_00, "Samsung Electronics"
    );

    //--------------Save---------------
    //--------------NoArg--------------
    @Test
    void shouldSaveOneItemProductNoArg() {
        repository.save(emptyProduct);

        Product[] expected = { emptyProduct };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItemBookNoArg() {
        repository.save(emptyBook);

        Product[] expected = { emptyBook };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItemSmartphoneNoArg() {
        repository.save(emptySmartphone);

        Product[] expected = { emptySmartphone };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveNoArg() {
        repository.save(emptyProduct);
        repository.save(emptyBook);
        repository.save(emptySmartphone);

        Product[] expected = { emptyProduct, emptyBook, emptySmartphone };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    //  -------------AllArg--------------
    @Test
    void shouldSaveOneItemProductAllArg() {
        repository.save(first);

        Product[] expected = { first };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItemBookAllArg() {
        repository.save(second);

        Product[] expected = { second };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItemSmartphoneAllArg() {
        repository.save(third);

        Product[] expected = {third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveAllArg() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = { first, second, third };
        //System.out.println(expected[1].getId());
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    //-------------findAll-------------
    @Test
    void shouldFindAllEmptyRepo() {
        Product[] expected = { };
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllNotEmptyRepo() {
        repository.save(second);
        repository.save(third);

        Product[] expected = { second, third };
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    //------------findById------------
    @Test
    void shouldFindByIdExistItem() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product expected = second;
        Product actual = repository.findById(2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdNotExistItem() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product expected = null;
        Product actual = repository.findById(4);
        assertEquals(expected, actual);
    }

    //-----------removeById-----------
    @Test
    void removeByIdExistItem() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = { second, third };
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdNotExistItem() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = { first, second, third };
        repository.removeById(4);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}