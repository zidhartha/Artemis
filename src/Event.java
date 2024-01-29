public class Event {
    int day;
    String description;
    String place;


    public Event(int day,String description,String place) {
        this.day = day;
        this.description = description;
        this.place = place;
    }
    public int getDay(){
        return this.day;
    }


    public int diff(int day){
        return getDay() - day;
    }

    public String getDescription() {
        return description;
    }

    public String getPlace() {
        return place;
    }

}
