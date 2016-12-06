import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Created by laszlogaal on 2016. 12. 05..
 */
public class Basket {
    private int count = 0;
    private Map<Product, Integer> basket = new HashMap<Product, Integer>();


    public void add (Product product, int quantity) {
        count += quantity;
        basket.put(product, Integer.valueOf(quantity));
    }

    public void add (Product product) {
        add (product, 1);
    }

    public void modify(int productId, int quantity) {
        count += quantity - basket.get(getProductByProductId(productId));
        basket.replace(
                getProductByProductId(productId),
                basket.get(getProductByProductId(productId)),
                Integer.valueOf(quantity));
    }

    public void remove(int productId) {
        count -= basket.get(getProductByProductId(productId));
        basket.remove(getProductByProductId(productId));
    }

    public String toString() {
        StringBuilder content = new StringBuilder();
        int lineCount = 0;
        double sum = 0;
        for (Object o : basket.entrySet()) {
            for (int i=0 ; i<((Integer)((Map.Entry) o).getValue()) ; i++) {
                lineCount++;
                content.append(lineCount+" - "+((Product) ((Map.Entry) o).getKey()).getDetails());
                sum += ((Product) ((Map.Entry) o).getKey()).getPrice();
            }
        }
        content.append("*********************************************");
        content.append("Total: "+sum);
        return content.toString();
    }


    public int getCount() {
        return count;
    }

    private Product getProductByProductId (int productId) {
        Iterator i = basket.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry pair = (Map.Entry)i.next();
            if ( ((Product) pair.getKey()).getProductId() == productId )
                return (Product) pair.getKey();
        }
        return null;
    }
}
