import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private List<Food> menu;


    public FoodMenu(){
        menu = new ArrayList<>();
        menu.add(new Food("pizza","It is really good", 20));
        menu.add(new Food("xashi","its ight twin",15));
        menu.add(new Food("bikentias qababi","IT IS LEGENDARY",9));
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Menu:\n");
        for (int i = 0; i < menu.size(); i++) {
            Food food = menu.get(i);
            stringBuilder.append(" " + i).append(". ").append(food.toString());
        }
        return stringBuilder.toString();
    }

    public Food getFood(int index){
        if(menu.size() <= index){
            return null;
        }
        return menu.get(index);
    }

    public Food getLowestCostFood(){
        if(menu.isEmpty()){
            return null;
        }
        Food min = menu.get(0);
        for(int i = 1;i<menu.size();i++){;
            if(menu.get(i).getPrice() < min.getPrice()){
                min = menu.get(i);
            }
        }
        return min;
    }
    public int getMenuItemCount() {
       return menu.size();
    }
}
