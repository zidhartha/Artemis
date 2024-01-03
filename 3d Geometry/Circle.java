public class Circle extends BaseArea {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle: { Radius:" + this.radius + "}";
    }
    public double circumference(){
        return Math.PI*2*this.radius;
    }
    public double area(){
        return Math.PI*Math.pow(radius,2);
    }
}
