public class Order {
    private int amount;
    private Screw screw;

    public Order(Screw screw,int amount) {
        this.amount = amount;
        this.screw = screw;
    }

    public int getAmount() {
        return amount;
    }

    public Screw getScrew() {
        return screw;
    }
}
