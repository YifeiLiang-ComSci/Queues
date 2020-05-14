# Randomized Queue and Normal Deque
The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.
Dequeue. A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports adding and removing items from either the front or the back of the data structure. 



**API for Deque:**  

    public class Deque<Item> implements Iterable<Item> {

    // construct an empty deque
      public Deque()

    // is the deque empty?
      public boolean isEmpty()

    // return the number of items on the deque
      public int size()

    // add the item to the front
      public void addFirst(Item item)

    // add the item to the back
     public void addLast(Item item)

    // remove and return the item from the front
     public Item removeFirst()

    // remove and return the item from the back
     public Item removeLast()

    // return an iterator over items in order from front to back
     public Iterator<Item> iterator()

    // unit testing (required)
     public static void main(String[] args)

    }
    
**API for Randomized Queue:**  


    public class RandomizedQueue<Item> implements Iterable<Item> {

    // construct an empty randomized queue
     public RandomizedQueue()

    // is the randomized queue empty?
     public boolean isEmpty()

    // return the number of items on the randomized queue
     public int size()

    // add the item
     public void enqueue(Item item)

    // remove and return a random item
     public Item dequeue()

    // return a random item (but do not remove it)
     public Item sample()

    // return an independent iterator over items in random order
     public Iterator<Item> iterator()

    // unit testing (required)
     public static void main(String[] args)

    }



## Prerequisites

Perfered to use IntelliJ As the IDE to run this program. Simply open the Readmet folder with intellJ.


**Note:  Be aware that if not using itellJ some of the import file is in the .lift/algs4.jar,and if there is a import error try to move them to the same directory as the java File.**  


## Contributing

This is a Assignment base on the course Of algorithm：https://www.coursera.org/learn/algorithms-part1


## Authors

* **Yifei Liang** - Deque.java, RandomizedQueue.java, Permutation.java

## Acknowledgments

* Testing code were provided by the course
