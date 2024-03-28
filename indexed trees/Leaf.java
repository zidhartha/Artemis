public class Leaf<T> implements Node<T> {
    private T value;
    public Leaf(T value){
        this.value = value;
    }

    public int size() {
            return 1;
    }

    @Override
    public T get(int i) {
        if(i == 0){
            return value;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void update(int i, T x) {
        if(i==0){
            value = x;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Node<T> insert(int i, T x) {
        if(i<=0){
            return new Inner<T>(new Leaf<T>(x),this);
        }
        return new Inner<T>(this,new Leaf<>(x));
    }

    @Override
    public Node<T> remove(int i) {
        if(i==0){
            return null;
        }
        throw new IndexOutOfBoundsException();
    }

}