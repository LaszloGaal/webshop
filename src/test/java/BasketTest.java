import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by laszlogaal on 2016. 12. 05..
 */

// TODO: 1. use Builder pattern instead of Factory
// TODO: 2. create OrderItem calss to store product+quantity
// TODO: 3. refactore Basket to use Collection of OrderItem
// TODO: 4. use BidDecimal instead
// TODO: 5. update Basket.toString to use Product.toString

public class BasketTest {

    Basket basket;
    ProductFactory productFactory;

    @Before
    public void setUp() {
        basket = new Basket();
        productFactory = new ProductFactory();
    }

    @Test
    public void testAdd() {
        basket.add(productFactory.getProduct("BOOK", 3500), 2);
        basket.add(productFactory.getProduct("BOOK", 1500));
        basket.add(productFactory.getProduct("CLOTHES", 2500), 1);
        System.out.println(basket.toString());
        assertEquals(4, basket.getCount());
    }

    @Test
    public void testModify() {
        basket.add(productFactory.getProduct("BOOK", 3500), 2);
        basket.modify(4, 10);
        System.out.println(basket.toString());
        assertEquals(10, basket.getCount());
    }

    @Test
    public void testRemove() {
        basket.add(productFactory.getProduct("BOOK", 3500), 2);
        basket.add(productFactory.getProduct("CLOTHES", 2500), 1);
        basket.remove(5);
        System.out.println(basket.toString());
        assertEquals(1, basket.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException(){
        basket.add(productFactory.getProduct("KONYV", 3500), 2);
    }

}