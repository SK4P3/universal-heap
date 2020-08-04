import java.util.ArrayList;
import java.util.Comparator;

public class Heap {

    private ArrayList<Object> list;
    private Comparator<Object> cmp;

    public Heap(Comparator<Object> cmp) {

        this.list = new ArrayList<>();
        this.cmp = cmp;

    }

    public Heap(ArrayList<Object> items) {

        this.list = items;
        buildHeap();
    }

    public void insert(Object item) {

        list.add(item);
        int lastIdx = list.size() - 1;
        int parentIdx = getParentIdx(lastIdx);

        while (parentIdx != lastIdx && cmp.compare(list.get(lastIdx), list.get(parentIdx)) < 0) { //list.get(lastIdx).getFrequency() < list.get(parentIdx).getFrequency()) {

            swap(lastIdx, parentIdx);
            lastIdx = parentIdx;
            parentIdx = getParentIdx(lastIdx);
        }
    }

    public void buildHeap() {
        for (int i = list.size() / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    public Object extractMin() {

        if (list.size() == 0) {

            throw new IllegalStateException("Heap is EMPTY");
        } else if (list.size() == 1) {

            Object min = list.remove(0);
            return min;
        }

        // remove the last item ,and set it as new root
        Object min = list.get(0);
        Object lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);

        // bubble-down until heap property is maintained
        heapify(0);

        // return min key
        return min;
    }

    private void heapify(int i) {

        int leftIdx = getLeftIdx(i);
        int rightIdx = getRightIdx(i);
        int smallest = -1;

        // find the smallest key between current node and its children.
        if (leftIdx <= list.size() - 1 && cmp.compare(list.get(leftIdx), list.get(i)) < 0) { //list.get(leftIdx).getFrequency() < list.get(i).getFrequency()) {
            smallest = leftIdx;
        } else {
            smallest = i;
        }

        if (rightIdx <= list.size() - 1 && cmp.compare(list.get(rightIdx), list.get(smallest)) < 0) { //list.get(rightIdx).getFrequency() < list.get(smallest).getFrequency()) {
            smallest = rightIdx;
        }

        // if the smallest key is not the current key then bubble-down it.
        if (smallest != i) {

            swap(i, smallest);
            heapify(smallest);
        }
    }

    private int getRightIdx(int i) {

        return 2 * i + 2;
    }

    private int getLeftIdx(int i) {

        return 2 * i + 1;
    }

    private int getParentIdx(int i) {

        if (i % 2 == 1) {
            return i / 2;
        }

        return (i - 1) / 2;
    }

    private void swap(int i, int parent) {
        Object temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }

    public int getSize() {
        return this.list.size();
    }

    public Object getObject(int idx) {
        return list.get(idx);
    }

    public void removeObject(Object obj) {
        int idx = list.indexOf(obj);
        int lastIdx = list.size() - 1;
        swap(idx, lastIdx);
        list.remove(lastIdx);
        heapify(idx);
    }

}