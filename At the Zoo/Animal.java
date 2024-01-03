public class Animal {
    private int foodCosts;
    private String name;

    public Animal(String name,int foodCost){
        this.foodCosts = foodCosts;
        this.name = name;
    }


    public String getName(){

        return name;
}

public int getFoodCosts(){
        return foodCosts;
}

public  String toString(){

        return "Name: " + getName() + ", FoodCosts(in dollers):" + getFoodCosts();
    }
}
