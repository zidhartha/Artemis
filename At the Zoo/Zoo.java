public class Zoo {

    private Vivarium[] vivaria;

    public Zoo(Vivarium[] vivaria){
    this.vivaria = vivaria;
    }
    public int getCosts(){
        int sum = 0;
        for (int i = 0; i <vivaria.length;i++) {
            sum += vivaria[i].getCosts();
        }
        return sum;
    }
    public String toString(){
        String result;
        result ="{";
        for (int i = 0; i < vivaria.length ; i++) {
            result += vivaria[i].toString();
            if (i != vivaria.length - 1)
                result += ", ";
        }
            result += "}";
            return result;
        }
    }

