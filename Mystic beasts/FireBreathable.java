public interface FireBreathable{
    public String getClassName();

    public default void breatheFire(){
        System.out.println(getClassName() + " can breathe fire.");
    }
}
