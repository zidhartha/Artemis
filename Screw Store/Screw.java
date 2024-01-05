public class Screw {
  final ScrewDrive head;
  private final double diameter;
  private final double length;
  private double price;

    public Screw(ScrewDrive head, double diameter, double length,double price) {

        this.head = head;
        this.diameter = diameter;
        this.length = length;
        this.price = price;
    }

    public double getDiameter() {
        return diameter;
    }

    public ScrewDrive getHead() {
        return head;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int hashCode(){
        return getHead().hashCode() + 9 * Double.hashCode(diameter) + 81 * Double.hashCode(length);
    }
    public boolean isEqual(Object object){
        if(object == null || !(object instanceof Screw)){
            return false;
        }
        Screw other = (Screw) object;
        return getHead().equals(other.head) && length == other.length && diameter == other.diameter;
    }
}