
public class LicensePlate {
    private String regionalCode;
    private String letters;
    private int digits;
    public LicensePlate(String regionalCode,String letters,int digits){
        this.regionalCode = regionalCode;
        this.letters = letters;
        this.digits = digits;
    }

    public int getDigits() {
        return digits;
    }

    public String getLetters() {
        return letters;
    }

    public String getRegionalCode() {
        return regionalCode;
    }
    public String toString(){
        return regionalCode + ":" + letters +" " + digits;
    }
    public boolean isEqual(LicensePlate lp){
        return letters.equals(lp.getLetters()) && regionalCode.equals(lp.getRegionalCode()) && digits == lp.getDigits();
    }
}
