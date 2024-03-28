


public class ParallelMergeSort extends RecursiveAction {
    private final Comparable[] array;
    private final Comparable[] helper;
    private final int low;
    private final int high;

    public ParallelMergeSort(Comparable[] array) {
        this(array, 0, array.length - 1);
    }

    public ParallelMergeSort(final Comparable[] array, final int low, final int high) {
        this.array = array;
        helper = new Comparable[array.length];
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if (low < high) {
            final int middle = (low + high) / 2;
            final ParallelMergeSort left = new ParallelMergeSort(array, low, middle);
            final ParallelMergeSort right = new ParallelMergeSort(array, middle + 1, high);
            invokeAll(left, right);
            MergeSort.merge(array, helper, low, middle, high);
        }
    }
}
