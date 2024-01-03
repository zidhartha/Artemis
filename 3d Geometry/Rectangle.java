

public class Rectangle extends BaseArea {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return height * width;
    }

    public boolean isSquare() {
        return width == height;
    }

    public Square toSquare() {
        if(this.height == this.width){
            return new Square(height);
        }
        return null;
    }

    public double circumference() {
        return (width + height) * 2;
    }



    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;

    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height;

    }
    public String toString() {
        return "Rectangle: { width :" + this.width + ", height: " + this.height + super.toString() + '}';
    }
}

