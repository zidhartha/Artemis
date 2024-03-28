public class Dragon extends Animal implements flyable,FireBreathable{
    @Override
    public String getClassName() {
        return "Dragon";
    }
    @Override
    public void fly(){
        System.out.println(getClassName() + "can fly");
    }
    public void BreatheFire(){
        System.out.println(getClassName() + " can breathe fire");
    }
}
