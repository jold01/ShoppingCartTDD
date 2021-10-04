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
        //System.out.println(sc.viewCart());
        assertEquals("Item{itemName='Chicken', itemPrice=1.0, quantity=2, onSale=false}" +
                "Item{itemName='Bread', itemPrice=2.5, quantity=3, onSale=false}", sc.viewCart());
    }

    @Test
    public void getSubTotalOfItemsInCart(){
        sc.addItemToCart(new Item("Bread", 2.50, 1));
        sc.addItemToCart(new Item("Chicken", 1.00, 2));
        sc.addItemToCart(new Item("Bread", 2.50, 2));

        assertEquals(9.50, sc.getSubtotal());
    }



}
