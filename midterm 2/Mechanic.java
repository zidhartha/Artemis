public class Mechanic extends Customer{
    int reduction;
    public Mechanic(String name, int money,int reduction) {
        super(name, money);
        if(reduction > 100){
            throw new IllegalArgumentException();
        }
        this.reduction = reduction;
    }

    @Override
    public boolean BuyItemsFromCart() {

            int moneyToBePaidByMechanic = super.getCart().calculatePrice() -
                    (super.getCart().calculatePrice() * (reduction/100));
            if(super.getMoney() < moneyToBePaidByMechanic)
                return false;
            super.setMoney(super.getMoney() - moneyToBePaidByMechanic);
            super.getCart().checkOut(moneyToBePaidByMechanic);
            return true;
        }
    }

