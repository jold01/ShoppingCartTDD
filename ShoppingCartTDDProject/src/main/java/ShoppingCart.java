import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> cart = new HashMap<>();

    public ShoppingCart() {
    }

    public ShoppingCart(Map cart) {
        this.cart = cart;
    }

    public int getCartSize(){
        return cart.size();
    }

    public void addItemToCart(Item item){
        cart.put(item.getItemName(), item);
    }

    public double getSubtotal(){
        double subtotal = 0;
        for(Item item : cart.values()){
            subtotal += item.getItemPrice();
        }

        return subtotal;
    }


}
