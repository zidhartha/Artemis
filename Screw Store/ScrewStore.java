import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ScrewStore {
    private final HashMap<Screw, Integer> stock;
    private final LinkedList<Screw> orders;

    public ScrewStore() {
        stock = new HashMap<>();
        orders = new LinkedList<Screw>();
    }

    public void addItem(Screw type, int amount) {
        Integer current = stock.get(type);
    if(current == null){
        stock.put(type,amount);
    }else{
        stock.put(type,amount + current);
    }
    }

    public void takeOrder(Screw type, int amount) {
        if (amount > 0 && type != null) {
            for (int i = 0; i < amount; i++) {
                orders.addFirst(type);
            }
        }
    }
    public boolean executeOrder() {
        if (stock.isEmpty()) {
            return false;
        }
        Order order = orders.getFirst();
        Integer amount = stock.get(order.getScrew());
        if (amount != null) {
            if (amount == order.getAmount()) {
                stock.remove(order.getScrew());
                return true;
            }
            if (amount > order.getAmount()) {
                stock.put(order.getScrew(), amount - order.getAmount());
                return true;
            }
        }
            return false;

    }

       public void inflation(double percent){
           for(Screw key : stock.keySet()){
               key.setPrice(key.getPrice() * (1 + percent));
           }
        }

        public int count(){
        int count = 0;
        for(int i : stock.values())
            count += i;
        return count;
        }

        public double value(){
            double amount = 0;
            for (Map.Entry<Screw, Integer> entry : stock.entrySet())
                amount += entry.getKey().getPrice() * entry.getValue();
            return amount;
            }

}
