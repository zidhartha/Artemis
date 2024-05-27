import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PricedItem> {
   private Map<T, Integer> shoppingBag;
    public ShoppingBag(){
        this.shoppingBag = new HashMap<T,Integer>();
    }

    public void addItem(T item){
        if(shoppingBag.get(item) != null){
            shoppingBag.put(item,shoppingBag.get(item) + 1);
        }
        shoppingBag.put(item,1);
    }
    public int getTotalPrice() {
        int totalPrice = 0;
        for(Map.Entry<T, Integer> entry : shoppingBag.entrySet()){
            T item = entry.getKey();
            int quantity = entry.getValue();
            totalPrice+= (int)item.getPrice() * quantity;
        }
        return totalPrice;
    }

    public boolean isBagEmpty() {
        if(shoppingBag.isEmpty()){
            return true;
        }
        return false;
    }
}
