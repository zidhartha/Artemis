import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart<T extends MarketItem> {
    HashMap<Integer, ArrayList<T>> cart = new HashMap<Integer,ArrayList<T>>();



    public void addItem(T item, int n) throws IllegalArgumentException{
        if(n<=0 || item == null){
            throw new IllegalArgumentException();
        }
        int itemHashCode = item.hashCode();
        if(!cart.containsKey(item)){
            ArrayList<T> newCart = new ArrayList<>();
            for (int i = 0; i <n; i++) {
                newCart.add(item);
            }
            cart.put(item.hashCode(),newCart);
        }
        ArrayList<T> shoppingCart = cart.get(item.hashCode());
        for(int i = 0;i<n;i++){
            shoppingCart.add(item);
        }
        cart.put(item.hashCode(),shoppingCart);
    }

    public boolean RemoveItem(T item,int n) throws IllegalArgumentException{
        if(item == null || n == 0 || !cart.containsKey(item.hashCode())){
            throw new IllegalArgumentException();
        }
        List<T> example = cart.get(item.hashCode());
        if(n == example.size()){
            cart.remove(item.hashCode());
            return true;
        }
        if(n> example.size()){
            return false;
        }else{
            for (int i = 0; i < n ; i++) {
                example.remove(item);
            return true;
            }
        }
        return false;
    }

    public int calculatePrice(){
        int price = 0;
        for(Map.Entry<Integer, ArrayList<T>> entry : cart.entrySet()){
            for(T t : entry.getValue()){
                price += t.getPrice();
            }
        }
        return price;
    }


    public int checkOut(int money) throws IllegalArgumentException {
        if (money >=calculatePrice()) {
            money -= calculatePrice();
            cart.clear();
            return money;
        }
        throw new IllegalArgumentException();
    }

}
