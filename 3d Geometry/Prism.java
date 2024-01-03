public class Prism {
    private BaseArea base;
    private double height;
    public Prism(BaseArea base, double height){
        this.base = base;
        this.height=height;
    }
    public double surface() {
        return height * base.circumference() + 2 * base.area();
    }
    public double volume() {
        return height * base.area();
    }

    public boolean isCube(){
        return base.isSquare() && base.toSquare() != null && height == base.toSquare().getLength();
    }
    public BaseArea getBase(){
        return base;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height;
    }
}



