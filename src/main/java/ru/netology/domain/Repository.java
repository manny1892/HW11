package ru.netology.domain;

public class Repository {

    private Product[] prod = new Product[0];


    public void save(Product unit) {
        for (Product product : prod) {
            if (findById(unit.id) == product) {
                throw new AlreadyExistsException("Такой ID товара уже существует! Введите другой! " + "Введеный ID=" + unit.id);
            }
        }
        int length = prod.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(prod, 0, tmp, 0, prod.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = unit;
        prod = tmp;
    }

    public Product[] findAll() {
        return prod;
    }

    public Product findById(int id) {
        for (Product product : prod) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("ID товара не найден! " + "Введеный ID=" + id);
        }
        Product[] tmp = new Product[prod.length - 1];
        int copyToIndex = 0;
        for (Product product : prod) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        prod = tmp;
    }

}
