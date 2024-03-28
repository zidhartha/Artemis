public abstract class Animal {
    public abstract String getClassName();

    public void eat(){
        System.out.println(getClassName() + " is eating");
    }
}
