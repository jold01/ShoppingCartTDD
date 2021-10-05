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

    public Item getItemFromCart(String key){
        return cart.get(key);
    }

    public void addItemToCart(Item item){

        if(cart.containsKey(item.getItemName())){
            Item cartItem = cart.get(item.getItemName());
            int newQuantity = cartItem.getQuantity() + item.getQuantity();
            item.setQuantity(newQuantity);
            cart.replace(item.getItemName(), cartItem, item);

        }
        else{
            cart.put(item.getItemName(), item);
        }
    }

    public double getSubtotal(){
        double subtotal = 0;
        for(Item item : cart.values()){
            double value = item.getItemPrice() * item.getQuantity();
            subtotal += value;
        }

        return subtotal;
    }

//    public String viewCart(){
//        String result = "";
//        for(Item item: cart.values()){
//            result += item.toString();
//        }
//        return result;
//    }

    public String viewCart(){
        String sb = "";
        for(Item item: cart.values()){

            if(item.isOnSale()){
                sb += "*ON SAlE* "+ item.getItemName()+" $"+ item.getItemPrice() + " Qty: " + item.getQuantity() +"\n";
            }
            else{
                sb += item.getItemName()+" $"+ item.getItemPrice() + " Qty: " + item.getQuantity() +"\n";
            }
        }
        return sb;
    }

    public void removeItemFromCart(String itemName){
        Item cartItem = cart.get(itemName);
        if(cartItem != null){
            if(cartItem.getQuantity() > 1) {
                cartItem.setQuantity((cartItem.getQuantity() - 1));
            }else{
                cart.remove(itemName);
            }
        }
    }




}
