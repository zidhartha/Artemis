abstract class BaseArea{
     abstract double circumference();
     abstract double area();

     public boolean isSquare(){
         return false;
     }


     public Square toSquare(){
         return null;
     }
    public String toString() {
        return "circumference: " + circumference() + "; area: " + area() + "; square?: " + isSquare();
    }
}
