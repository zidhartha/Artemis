public class PenguinDateGenerator {

    private Tree<Penguin> tree;

    public PenguinDateGenerator(Tree<Penguin> tree) {
        this.tree = tree;
    }

    public boolean canGoOnADate(Penguin p1, Penguin p2) {
        Penguin ancestor = tree.LCA(p1,p2);

        int distance1 = tree.distanceBetweenNodes(p1,ancestor);
        int distance2 = tree.distanceBetweenNodes(p2,ancestor);
        return distance1 >= p1.getAllowance() && distance2 >= p2.getAllowance();
    }

    public Tree<Penguin> getTree() {
        return this.tree;
    }

}

