
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;
import java.nio.file.*;

public class Kiuflix<V extends Video> {
    private Stream<V> stream;
    private List<V> downloads;
    private int budget, cost;
    public Kiuflix(Stream<V> s, int b, int c){
        stream = s;
        budget = b;
        cost = c;
        downloads = new ArrayList<>();
    }

    public void bulkView(Predicate<V> pred){
        stream.filter(pred)
                        .forEach(a -> {
                            if(a != null && budget >= 0 && a.title().length() % 4 == 1){
                                downloads.add(a);
                                budget -= cost;
                                a.view();
                            }
                        });

        System.out.printf("\nRemaining budget:\t" + budget);
    }

    public static void main(String[] args) throws IOException {
        class MyVideo implements Video {
            private String title;
            public MyVideo(String title){
                this.title = title;
            }

            public String title(){
                return title;
            }

            public void view(){
                System.out.println(title);
            }

            public void skip(){}
        }
        Kiuflix<MyVideo> kiuflix = new Kiuflix<>(Files.lines(Path.of(args[0]))
                .map(MyVideo::new), 100, 15);
        kiuflix.bulkView((t) -> t.title().length() % 4 == 1);
    }


}
