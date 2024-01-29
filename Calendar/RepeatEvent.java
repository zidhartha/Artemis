public class RepeatEvent extends Event {
    private int end;

    public RepeatEvent(int day,String description,String place,int end){
        super(day, description, place);
        this.end = end;
    }


    public int diff(int day) {
        if (day > this.end) {
            return super.diff(day);
        } else {
            return end - day;
        }
    }
}
