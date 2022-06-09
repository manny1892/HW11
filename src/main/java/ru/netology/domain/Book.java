package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book extends Product {
    private String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }
    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getAuthor().contains(search)) {
            return true;
        } else {
            return false;
            }
        }

    }

