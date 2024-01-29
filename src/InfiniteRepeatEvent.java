public class InfiniteRepeatEvent extends Event{
    int period;

    public InfiniteRepeatEvent(int day,String description,String place,int period){
        super(day,description,place);
        this.period = period;
    }

    public int diff(int day){
       if(day < getDay()){
           return day - getDay();
       }
       return (super.diff(day) % period - period)% period ;
    }
}
