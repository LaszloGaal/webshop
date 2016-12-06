/**
 * Created by laszlogaal on 2016. 12. 05..
 */
public class Clothes extends Product{
    private String size = "unknown";
    private String color = "unknown";

    public enum Sizes{
        XS, S, M, L, XL, XXL;
    }

    public Clothes(double price) {
        super(price);
    }

    public String getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size.name();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getDetails() {
        return "Price: "+getPrice()+", [Clothes("+getProductId()+")], Color: "+getColor()+", Size: "+getSize();
    }
}
