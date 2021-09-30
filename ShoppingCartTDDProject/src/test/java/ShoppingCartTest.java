//import org.junit.jupiter.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;

public class ShoppingCartTest {

    ShoppingCart sc = new ShoppingCart();

//    @BeforeClass
//    public static void setup() {
//        ShoppingCart sc = new ShoppingCart();
//    }
    @Test
    public void getCartSize(){
        System.out.println("Get initial cart size");
        int size = sc.getCartSize();
        assertEquals(0, size);
    }

    @Test
    public void checkPriceSubTotal(){
        System.out.println("Add item and check subtotal of item");
        sc.addItemToCart(new Item("Bread", 2.50, 1));

        assertEquals(2.50, sc.getSubtotal() );
    }



}
