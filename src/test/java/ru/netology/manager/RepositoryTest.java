package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repo = new Repository();

    Product book1 = new Book(1, "The Witcher", 700, "Andrzej Sapkowski");
    Book book2 = new Book(2, "Sword of Destiny", 800, "Andrzej Sapkowski");
    Product book3 = new Book(3, "The Last Wish", 900, "Andrzej Sapkowski");
    Book book4 = new Book(4, "The Witcher Two", 1000, "Andrzej Sapkowski");
    Smartphone smartphone = new Smartphone(5, "Galaxy", 50_000, "Samsung");

    @Test
    void removeById() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(smartphone);
        repo.remove(5);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, book4};
        assertArrayEquals(expected, actual);

    }

    @Test
    void add() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(smartphone);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, book4, smartphone};
        assertArrayEquals(expected, actual);

    }


}