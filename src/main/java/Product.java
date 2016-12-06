/**
 * Created by laszlogaal on 2016. 12. 05..
 */
public abstract class Product {
    private static int productIdCounter = 0;
    private int productId;
    private double price;


    public Product(double price) {
        this.productId = getNextProductId();
        this.price = price;
    }

    private static int getNextProductId() {
        return ++productIdCounter;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getDetails();
}
