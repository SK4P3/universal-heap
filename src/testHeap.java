import java.util.Comparator;

public class testHeap {

    public static void main(String[] args) {

        Heap heap = new Heap(new compare());


        // numbers              35 33 42 10 14 19 27 44 26 31
        // min-heap should be   10 14 19 26 31 42 27 44 35 33
        // max-heap should be   44 42 35 33 31 19 27 10 26 14

        myObj o1 = new myObj(35);
        myObj o2 = new myObj(33);
        myObj o3 = new myObj(42);
        myObj o4 = new myObj(10);
        myObj o5 = new myObj(14);
        myObj o6 = new myObj(19);
        myObj o7 = new myObj(27);
        myObj o8 = new myObj(44);
        myObj o9 = new myObj(26);
        myObj o10 = new myObj(31);

        heap.insert(o1);
        heap.insert(o2);
        heap.insert(o3);
        heap.insert(o4);
        heap.insert(o5);
        heap.insert(o6);
        heap.insert(o7);
        heap.insert(o8);
        heap.insert(o9);
        heap.insert(o10);

        return;

    }
}

class myObj {
    int x;

    public myObj(int x) {
        this.x = x;
    }

}

class compare implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof myObj)                         // <---------------- use instanceof 'myObject' with the Object you want to use in your heap
            return compare((myObj) o1, (myObj) o2);     // <---------------- replace 'myObject' with the Object you want to use
        else
            return 0;
    }

    public int compare(myObj o1, myObj o2) {            // <---------------- replace 'myObject' with the Object you want to use

        /*
        --------------------------------
        Your compare function goes here!
        --------------------------------

        example:

        if(o1.x > o2.x)
            return -1;
        if(o1.x < o2.x)
            return 1;

        */

        return 0;
    }


}
