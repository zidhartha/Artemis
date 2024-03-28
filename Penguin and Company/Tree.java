
import java.util.LinkedList;
import java.util.Queue;

public class Tree<T> {

    private Node<T> root;

    public Tree (T data) {
        root = new Node(data);
    }

    public void insert(T value, T parent) {
        Node posToInsert = nodeWithGivenKey(this.root, parent);
        if (this.containsKey(value))
            return;
        if (posToInsert == null)
            return;

        posToInsert.insert(new Node(value));
    }

    public void remove(T value) {
        Node<T> node = nodeWithGivenKey(root, value);
        if (node == null)
            return;
        node.remove();
    }
    private Node<T> nodeWithGivenKey(Node<T> root, T key) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> front = queue.remove();
            if (front.getData() == key)
                return front;
            for (Node<T> data : front.getChildren())
                queue.add(data);
        }
        return null;
    }

    // Implementation of following function could be done in O(logn) using binary lifting
    // however time complexity is not this courses concern
    public T LCA(T a, T b) {
        Node leftVal = nodeWithGivenKey(this.root,a);
        Node rightVal = nodeWithGivenKey(this.root,b);
        if (isInSubtree(leftVal,rightVal))
            return (T) leftVal.getData();
        if (isInSubtree(rightVal,leftVal))

            return (T) rightVal.getData();
        while(rightVal != null) {
            if (isInSubtree(rightVal,leftVal)) {
                return (T) rightVal.getData();
            }
            rightVal = rightVal.getParent();
        }
        return null;
    }

    // determines if b is in the subtree of a
    // this could've been detected in O(1) time if we store time_in and time_out for each of the nodes
    // a is in subtree of b if time_in[a] <= time_in[b] && time_out[b] <= time_out[a]
    private boolean isInSubtree(Node<T> a, Node<T> b) {
        boolean ans = false;
        if (a == null)
            return false;
        if (a == b)
            return true;
        for (Node<T> node : a.getChildren())
            ans = ans | isInSubtree(node,b);
        return ans;
    }

    public int distanceBetweenNodes(T a, T b) {
        T lca = this.LCA(a,b);
        Node<T> lcaNode = nodeWithGivenKey(root,lca);
        Node<T> aNode = nodeWithGivenKey(root,a);
        Node<T> bNode = nodeWithGivenKey(root,b);
        int ans = 0;
        while (aNode != lcaNode) {
            ans++;
            aNode = aNode.getParent();
        }
        while (bNode != lcaNode) {
            ans++;
            bNode = bNode.getParent();
        }
        return ans;
    }
    public Node<T> getRoot() {
        return this.root;
    }
    public boolean containsKey(T key) {
        Node<T> node = nodeWithGivenKey(root,key);
        return node != null;
    }

    public void traversal() {
        root.traversal(root);
    }

}
