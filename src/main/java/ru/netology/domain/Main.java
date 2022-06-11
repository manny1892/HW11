package ru.netology.domain;

public class Main {
    public static void main(String[] args) {

        Product first = new Book(1, "Academy", 300, "A.Azimov");
        Product second = new Book(2, "Academy and Earth", 350, "A.Azimov");
        Product third = new Smartphone(3, "Poco M4 Pro", 24000, "Xiaomi");
        Product fourth = new Book(4, "Dark Tower", 450, "S.King");
        Product fifth = new Smartphone(5, "Galaxy S4", 35000, "Samsung");
        Product sixth = new Smartphone(6, "3220", 6600, "Nokia");

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        manager.removeById(4);

        manager.getAll();


    }
}
