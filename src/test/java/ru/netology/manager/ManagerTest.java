package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);
    Product book1 = new Book(1, "The Witcher", 700, "Andrzej Sapkowski");
    Book book2 = new Book(2, "Sword of Destiny", 800, "Andrzej Sapkowski");
    Product book3 = new Book(3, "The Last Wish", 900, "Andrzej Sapkowski");
    Book book4 = new Book(4, "The Witcher Two", 1000, "Andrzej Sapkowski");
    Smartphone smartphone = new Smartphone(5, "Galaxy", 50_000, "Samsung");

    @Test
    void addManager() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);
        Product[] actual = manager.repository.findAll();
        Product[] expected = {book1, book2, book3, book4, smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);
        Product[] actual = manager.searchBy("Witcher");
        Product[] expected = {book1, book4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchOneProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);
        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = {smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchNotFound() {

        Product[] actual = manager.searchBy("Wish");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }


}