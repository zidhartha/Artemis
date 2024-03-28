
import java.util.concurrent.RecursiveAction;

public class BetterParallelMergeSort extends RecursiveAction {
    private static final int MAX = 1 << 16;
    private final Comparable[] array;
    private final Comparable[] helper;
    private final int low;
    private final int high;

    public BetterParallelMergeSort(Comparable[] array) {
        this(array, 0, array.length);
    }

    public BetterParallelMergeSort(final Comparable[] array, final int low, final int high) {
        this.array = array;
        helper = new Comparable[array.length];
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if (low < high) {
            if (high - low <= MAX) {
                MergeSort.mergesort(array, helper, low, high);
            } else {
                final int middle = (low + high) / 2;
                final BetterParallelMergeSort left = new BetterParallelMergeSort(array, low, middle);
                final BetterParallelMergeSort right = new BetterParallelMergeSort(array, middle + 1, high);
                invokeAll(left, right);
                MergeSort.merge(array, helper, low, middle, high);
            }
        }
    }
}
