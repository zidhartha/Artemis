import java.util.HashSet;
import java.util.Iterator;
public class Main{
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(12);
        set.add(14);
        set.add(10);
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}