import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexTree <T> implements Iterable<T> {
    private Node<T> tree;
    public int size(){
        if (tree == null) return 0;
        return tree.size();
    }

    public T get(int i) {
        return tree.get(i);
    }

    public void update(int i, T x) {
        tree.update(i, x);
    }

    public Node<T> insert(int i, T x) {
        if (tree == null){
            tree = new Leaf<>(x);
        }
        return tree.insert(i, x);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pointer = 0;
            Node<T> next = tree;
            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                else {
                    T l = (T) tree.get(pointer);
                    pointer += 1;
                    return  l;
                }
            }
        };
    }

}
