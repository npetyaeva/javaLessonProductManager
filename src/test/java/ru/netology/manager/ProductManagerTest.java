package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository = Mockito.mock(ProductRepository.class); //притворяжка - Я репозиторий

    @InjectMocks
    private ProductManager manager = new ProductManager(repository); //передача притворяжки менеджеру

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

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldSearchByFindSmartphone() {
        //настройка заглушки
        Product[] returned = { first, second, third, fourth };
        doReturn(returned).when(repository).findAll();

        String text = "Electronics";
        Product[] expected = new Product[] { first, third };
        Product[] actual = manager.searchBy("Electronics");

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldSearchByFindBook() {
        //настройка заглушки
        Product[] returned = { first, second, third, fourth };
        doReturn(returned).when(repository).findAll();

        String text = "Anna";
        Product[] expected = new Product[] { second };
        Product[] actual = manager.searchBy("Anna");

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldSearchByFindProduct() {
        //настройка заглушки
        Product[] returned = { first, second, third, fourth };
        doReturn(returned).when(repository).findAll();

        String text = "Java: A Beginner's Guide";
        Product[] expected = new Product[] { fourth };
        Product[] actual = manager.searchBy("Java: A Beginner's Guide");

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldSearchByNotFind() {
        //настройка заглушки
        Product[] returned = { first, second, third, fourth };
        doReturn(returned).when(repository).findAll();

        String text = "Java11";
        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy("Java11");

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldGetAll() {
        //настройка заглушки
        Product[] returned = { first, second, third, fourth };
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[] { first, second, third, fourth };
        Product[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}