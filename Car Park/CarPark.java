public class CarPark {
    private Car[] spaces;
    private String name;

    public CarPark(int n){
        this.spaces = new Car[n];
    }

    public CarPark(Car[] cars){
        this.spaces = cars;
    }

    public Car[] getSpaces() {
        return spaces;
    }

    public void setSpaces(Car[] spaces) {
        this.spaces = spaces;
    }

    public void GiveCar(Car c){
        Car[] temp = new Car[spaces.length + 1];
        temp[spaces.length] = c;
        for (int i = 0; i < spaces.length ; i++) {
            temp[i] = spaces[i];

            this.spaces = temp;        }
    }

    public int park(Car c){
        for (int i = 0; i < spaces.length; i++) {
            if(spaces[i] == null){
                spaces[i] = c;
                return i;
            }
        }
        return -1;
    }

    public int search(LicensePlate lp){
        for (int i = 0; i < spaces.length ; i++) {
            if(spaces[i] != null && spaces[i].getLicensePlate().equals(lp)){
                return i;
            }
        }
        return -1;
    }

    public Car driveOff(LicensePlate lp) {
        int position = search(lp);
        if (position == -1) {
            return null;
        } else {
            Car car = spaces[position];
            spaces[position] = null;
            return car;
        }
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Car Park:\n");
        for (int i = 0; i < spaces.length; i++) {
            builder.append(i).append(": [");
            if (spaces[i] != null) {
                builder.append(spaces[i]);
            }
            builder.append("]\n");
        }
        return builder.toString();
    }


}
