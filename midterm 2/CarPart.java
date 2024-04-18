import java.util.Objects;

public class CarPart {
    private final String name;
    private final int price;


    public CarPart(String name,int price) throws IllegalArgumentException{
        if(price <=0 || name == null){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
    }

    public int hashCode(){
           return Objects.hash(this.name);
    }

    public boolean equals(CarPart other) {
        return this.name.hashCode() == other.name.hashCode();
    }
}
