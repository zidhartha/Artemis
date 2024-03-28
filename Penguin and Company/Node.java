import java.util.ArrayList;
import java.util.List;

public class Node<T>{

    private List<Node<T>> children;
    private Node<T> parent;
    private T data;
    public Node(T data) {
        this.data = data;
        children = new ArrayList<>();
    }
    public void insert(Node<T> value) {
        value.parent = this;
        this.children.add(value);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public int size() {
        if (this.isLeaf())
            return 1;
        int cnt = 0;
        for (int k = 0; k < this.children.size(); k++)
            cnt += children.get(k).size();
        return cnt;
    }

    public void remove() {
        if (this.parent == null) {
            return;
        }
        this.parent.children.remove(this);
        for (Node<T> node : this.children) {
            node.parent = this.parent;
            this.parent.children.add(node);
        }

    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public void traversal(Node<T> root) {
        if (root == null)
            return;
        System.out.println(root.data + " ");
        for (Node<T> data : root.children) {
            traversal(data);
        }
    }

}

