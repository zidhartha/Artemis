public class RegularPolygon extends BaseArea {
    private int n;
    private double length;

    public RegularPolygon(int n,double length){
        this.n = n;
        this.length = length;
    }

    public void setN(int n){
        this.n = n;
    }
    public void setLength(double length){
        this.length = length;
    }
    public int getN(){
        return n;
    }
    public double getLength(){
        return length;
    }
    public String toString(){
        return "Polygon has: " + this.n + " sides, " + "which have " + this.length + " length " + "}";
    }
    public double circumference(){
        return length * n;
    }
    public double area(){
        double A = Math.pow(length,2) * n;
        double B =4 * Math.tan(Math.PI/n);
        return A/B;
    }
    public Square toSquare() {
        if (this.n == 4) {
            return new Square(this.length);
        } else {
            return null;
        }
    }


    public boolean isSquare() {
        if (this.n == 4) {
            return true;
        } else {
            return false;
        }
    }
}