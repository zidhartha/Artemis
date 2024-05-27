public class Customer{
    private String name;
    private int money;
    public Customer(String name,int money){
        this.name = name;
        this.money = money;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name1){
        this.name = name1;
    }
    public void setMoney(int money1){
        this.money = money1;
    }
    public int getMoney(){
        return this.money;
    }
}
