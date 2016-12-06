/**
 * Created by laszlogaal on 2016. 12. 05..
 */
public class ProductFactory {

    public enum ProductType{
        BOOK,
        CLOTHES;


        public static String print() {
            StringBuilder types = new StringBuilder("[");
            for (ProductType type : ProductType.values()) {
                types.append(type.name()+", ");
            }
            types.delete(types.length()-2, types.length());
            types.append("]");
            return types.toString();
        }
    }

    public Product getProduct(String productType, double price) throws IllegalArgumentException {

        if(null == productType)
            return null;

        if(ProductType.BOOK.name().equals(productType))
            return new Book(price);
        else if(ProductType.CLOTHES.name().equals(productType))
            return new Clothes(price);
        else
            throw new IllegalArgumentException("'"+productType+"' not supported. "+ProductType.print());
    }
}
