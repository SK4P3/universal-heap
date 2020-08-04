import java.util.ArrayList;
import java.util.Comparator;

public class Heap {

    private ArrayList<Object> list;
    private Comparator<Object> cmp;

    public Heap(Comparator<Object> cmp) {

        this.list = new ArrayList<>();
        this.cmp = cmp;

    }

    public Heap(ArrayList<Object> items, Comparator<Object> cmp) {
        this.list = items;
        this.cmp = cmp;
        buildHeap();
    }

    public void insert(Object item) {

        list.add(item);
        int lastIdx = list.size() - 1;
        int parentIdx = getParentIdx(lastIdx);

        while (parentIdx != lastIdx && cmp.compare(list.get(lastIdx), list.get(parentIdx)) < 0) {

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

    public Object extractFirst() {

        if (list.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        } else if (list.size() == 1) {

            Object obj = list.remove(0);
            return obj;
        }

        Object obj = list.get(0);
        Object lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);

        heapify(0);

        return obj;
    }

    private void heapify(int i) {

        int leftIdx = getLeftIdx(i);
        int rightIdx = getRightIdx(i);
        int num = -1;

        if (leftIdx <= list.size() - 1 && cmp.compare(list.get(leftIdx), list.get(i)) < 0) {
            num = leftIdx;
        } else {
            num = i;
        }

        if (rightIdx <= list.size() - 1 && cmp.compare(list.get(rightIdx), list.get(num)) < 0) {
            num = rightIdx;
        }

        if (num != i) {

            swap(i, num);
            heapify(num);
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