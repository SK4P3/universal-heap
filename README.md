# universal-heap
A universal applicable heap of objects implemented in Java.


Use this as a simple Heap implementation. There are only very few things you need to change/adapt to make it work for your project.

  1) Import the Heap.java file into your project.
  
  2) Create a comparator class you want to use for your heap. You can use this as an example:
  ```
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
         */
        
        return 0;
    }
}
  ```
  Depending on your comparator, it will either be a max or a min heap!

  3) When you use it create a new Instance of it like:
  ```
  Heap heap = new Heap(new compare());
  ```
  or
  ```
  Heap heap = new Heap(list, new compare()); //list is an ArrayList with the desired Objects
  ```
  
  4) Use insert() to add new Objects to the heap and use extractFirst() to get the Object that is on top of the heap.
