
public class Square extends BaseArea {
    private double length;
    public Square(double length){
        this.length = length;

    }

    public double circumference(){
        return this.length*4;
    }
    public Square toSquare() {
        return new Square(length);
    }
    public boolean isSquare(){
        return true;
    }
    public double area(){
        return Math.pow(this.length,2);
    }

    public String toString(){
        return "Square: {Side's Length: " + this.length + super.toString() +"}";

    }
    public double getLength(){
        return this.length;
    }
    public void setLength(){
        this.length = length;
    }


}