package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    protected int id;
    protected String title;
    protected int price;

    public boolean matches(String search) {
        if (getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
