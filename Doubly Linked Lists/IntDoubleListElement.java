
public class IntDoubleListElement {
    private int info;

    public void setInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    // The attributes are public since they are essentially modified only by List
    // and getters/setters thus would incure unnecessary overhead
    public IntDoubleListElement next;
    public IntDoubleListElement prev;

    public IntDoubleListElement(int info) {
        this.info = info;
        next = null;
        prev = null;
    }

    public boolean isEqual(IntDoubleListElement other) {
        return other != null && info == other.info;
    }
}
