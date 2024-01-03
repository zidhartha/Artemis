public class Animal {
    int foodCost;
    String name;

    public Animal(String name,int foodCost){
        this.foodCost = foodCost;
        this.name = name;
    }


    public String getName(){

        return name;
}

public int getFoodCost(){

        return foodCost;
}

public  String toString(){

        return "Name: " + getName() + ", FoodCosts(in dollers):" + getFoodCost();
    }
}
