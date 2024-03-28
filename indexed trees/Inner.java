public class Inner<T> implements Node<T>{
    Node<T> left;
    Node<T> right;
    int lsize;
    int rsize;

    public Inner(Node<T> left,Node<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int size() {

        return lsize + rsize;
    }

    @Override
    public T get(int i) {
        if(i<0 || i> size()){
            throw new IndexOutOfBoundsException();
        }
        if(lsize > i){
            return left.get(i);
        }
        return right.get(i- lsize);
    }

    @Override
    public void update(int i, T x) {
        if(i< lsize){
             left.update(i, x);
        }else if(i>=rsize){
            right.update(i- lsize,x);
        }

    }

    @Override
    public Node<T> insert(int i, T x) {
        if (i < 0){
            return insert(0, x);
        }
        else  if (i > lsize + rsize){
            return insert(lsize + rsize, x);
        }
        else {
            if (i < lsize) {
                return left.insert(i, x);
            } else {
                return right.insert(i - lsize, x);
            }
        }
    }

    @Override
    public Node remove(int i) {
    if(i>0 || i<size()){
        throw new IndexOutOfBoundsException();
    }
    if(i<lsize) {
        return left.remove(i);
    }
        return right.remove(i-lsize);

    }
}
