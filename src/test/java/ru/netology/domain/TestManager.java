package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestManager {
    Product first = new Book(1, "Academy", 300, "A.Azimov");
    Product second = new Book(2, "Academy and Earth", 350, "A.Azimov");
    Product third = new Smartphone(3, "Poco M4 Pro", 24000, "Xiaomi");
    Product fourth = new Book(4, "Dark Tower", 450, "S.King");
    Product fifth = new Smartphone(5, "Galaxy S4", 35000, "Samsung");
    Product sixth = new Smartphone(6, "3220", 6600, "Nokia");

    @Test
    public void shouldViewAllAddProducts() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        manager.getAll();

        Product[] actual = manager.getAll();
        Product[] expected = {first, second, third, fourth, fifth, sixth};

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldViewSearchByOneLetter() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        manager.searchBy("y");

        Product[] actual = manager.searchBy("y");
        Product[] expected = {first, second, fifth};

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldViewSearchByOneWord() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        manager.searchBy("Academy");

        Product[] actual = manager.searchBy("Academy");
        Product[] expected = {first, second};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldViewSearchByFullTitle() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        manager.searchBy("Dark Tower");

        Product[] actual = manager.searchBy("Dark Tower");
        Product[] expected = {fourth};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldViewProductAfterDelete() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        manager.removeById(5);

        manager.getAll();

        Product[] actual = manager.getAll();
        Product[] expected = {first, second, third, fourth, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldViewSearchAfterDelete() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        manager.removeById(6);

        manager.getAll();

        manager.searchBy("3220");

        Product[] actual = manager.searchBy("3220");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
