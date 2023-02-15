package e1;

import java.util.Objects;

public class Product {

    private final String id;

    private int stock;

    private float price;

    public String getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(String id, int stock, float price) { // El nombre que se da como id, es inmutable
        this.id = id;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return stock == product.stock && Float.compare(product.price, price) == 0 && Objects.equals(id, product.id);
    }

}
