import java.sql.SQLOutput;

public class Vivarium {
    private int area;
    private int constructionYear;
    private Animal[] inhabitants;

    public Vivarium(Animal[] inhabitants,int area,int constructionYear){
        this.area = area;
        this.constructionYear = constructionYear;
        this.inhabitants = inhabitants;
    }
    public int getCosts() {
        int costs = 0;
        for (int i = 0; i < inhabitants.length; i++) {
            costs += inhabitants[i].getFoodCosts();
        }
        return costs + getMaintenance();
    }

    private int getMaintenance(){
        return 900 + area * 100 + area * (2023 - constructionYear) * 5;
    }
    public String toString() {
        String result = "[area: " + area + ", constructionYear: " + constructionYear + ", animals: ";
        for (int i = 0; i < inhabitants.length; i++) {
            result += inhabitants[i].toString();
            if (i < inhabitants.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}

}
