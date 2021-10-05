//import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

public class ShoppingCartTest {

    ShoppingCart sc;

    @BeforeEach
    public void setup() {
        sc = new ShoppingCart();
    }
    @Test
    public void getCartSize(){
        //System.out.println("Get initial cart size");
        int size = sc.getCartSize();
        assertEquals(0, size);
    }

    @Test
    public void checkPriceSubTotal(){
        //System.out.println("Add item and check subtotal of item");
        sc.addItemToCart(new Item("Bread", 2.50, 1));

        assertEquals(2.50, sc.getSubtotal() );
    }

    @Test
    public void checkPriceSubTotalMultiItem(){
        //sc.getCartSize();
        sc.addItemToCart(new Item("Bread", 2.50, 1));
        sc.addItemToCart(new Item("Chicken", 1.00, 2));
        assertEquals(4.50, sc.getSubtotal());
    }

    @Test
    public void checkItemQuantityMultiEntries(){
        sc.addItemToCart(new Item("Bread", 2.50, 1));
        sc.addItemToCart(new Item("Bread", 2.50, 2));
        Item item = sc.getItemFromCart("Bread");
        assertEquals(3, item.getQuantity());
    }

    @Test
    public void listItemsInCart(){
        sc.addItemToCart(new Item("Bread", 2.50, 1));
        sc.addItemToCart(new Item("Chicken", 1.00, 2));
        sc.addItemToCart(new Item("Bread", 2.50, 2));


        assertEquals("Chicken $1.0 Qty: 2\nBread $2.5 Qty: 3\n", sc.viewCart());
    }

    @Test
    public void listItemsInCartOnSale(){
        sc.addItemToCart(new Item("Bread", 2.50, 1));
        sc.addItemToCart(new Item("Chicken", 1.00, 2, true));
        sc.addItemToCart(new Item("Bread", 2.50, 2));


        assertEquals("*ON SAlE* Chicken $1.0 Qty: 2\nBread $2.5 Qty: 3\n", sc.viewCart());
    }

    @Test
    public void getSubTotalOfItemsInCart(){
        sc.addItemToCart(new Item("Bread", 2.50, 1));
        sc.addItemToCart(new Item("Chicken", 1.00, 2));
        sc.addItemToCart(new Item("Bread", 2.50, 2));

        assertEquals(9.50, sc.getSubtotal());
    }

    @Test
    public void removeItemFromCart(){
        sc.addItemToCart(new Item("Bread", 2.50, 1));
        sc.addItemToCart(new Item("Bread", 2.50, 1));
        sc.removeItemFromCart("Bread");
        assertEquals(1, sc.getItemFromCart("Bread").getQuantity());

    }

    @Test
    public void removeLastItemFromCart(){
        sc.addItemToCart(new Item("Bread", 2.50, 1));
        sc.removeItemFromCart("Bread");
        assertEquals(null, sc.getItemFromCart("Bread"));
    }



}
