public class Customer {
    private String name;
    private int money;
    Cart<MarketItem> cart;

    public Customer(String name,int money){
        this.money = money;
        this.name = name;
        cart = new Cart();
    }

    public int getMoney() {
        return money;
    }

    public Cart<MarketItem> getCart() {
        return cart;
    }

    public void setCart(Cart<MarketItem> cart) {
        this.cart = cart;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addItemToCart(MarketItem item, int n) throws IllegalArgumentException{
        cart.addItem(item, n);
    }


    public void removeItemFromCart(MarketItem item,int n) throws IllegalArgumentException{
        cart.RemoveItem(item,n);
    }

    public boolean BuyItemsFromCart(){
        if(this.money < cart.calculatePrice()){
            return false;
        }
        cart.checkOut(this.money);
        return true;
    }
}
