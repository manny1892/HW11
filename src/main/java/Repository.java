public class Repository {

    private Product[] prod = new Product[0];


    public void save(Product unit) {
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

    public void deleteById(int id) {

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
