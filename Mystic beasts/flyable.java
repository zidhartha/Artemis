public interface flyable {
   public String getClassName();

   public default void fly(){
       System.out.println(getClassName() + " can fly");
   }


}
