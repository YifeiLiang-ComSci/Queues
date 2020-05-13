import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size;


    // construct an empty deque
    public Deque()
    {
        head = null;
        tail = null;
        size = 0;


    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return size == 0;

    }

    // return the number of items on the deque
    public int size()
    {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> temp = new Node<>(item);
        if(size == 0)
        {

            head = temp;
            tail = head;
        } else {
            Node<Item> preivousHead = head;

            head = temp;
            head.next = preivousHead;
            preivousHead.previous = head;
        }

        size++;

    }

    // add the item to the back
    public void addLast(Item item)
    {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> temp = new Node<>(item);
        if(size == 0)
        {
            head = temp;
            tail = head;
        } else {
            Node<Item> preivousTail = tail;
            tail = temp;
            preivousTail.next = tail;
            tail.previous = preivousTail;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst()
    {
        if (isEmpty())
        {
           throw new java.util.NoSuchElementException();
        }
        Item item = head.data;
        head = head.next;
        head.previous = null;


        return item;


    }

    // remove and return the item from the back
    public Item removeLast()
    {
        if (isEmpty())
        {
            throw new java.util.NoSuchElementException();
        }
        Item item = tail.data;
        //System.out.println("run "+tail.previous.data);
        tail = tail.previous;
        tail.next = null;

        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
        return new DequeIterator();

    }
    private class DequeIterator implements Iterator<Item>
    {
        private Node<Item> current = head;

        public boolean hasNext() {

            return current != null;
        }

        public Item next() {
            Item temp = current.data;
            current = current.next;
            return temp;

        }
    }

    private class Node<T>
    {
        Node<T> next = null;
        Node<T> previous = null;

        T data;
        public  Node(T item)
        {
            data = item;
        }
    }
    // unit testing (required)
    public static void main(String[] args)
    {

        int size = 100;
        Deque<Integer> que = new Deque<>();

        for (int i = 0; i < size; i++)
        {
            que.addFirst(i);
        }
        que.removeFirst();
        que.removeLast();
        que.removeFirst();
        que.removeLast();
        for (int x:que)
        {
            System.out.println(x);
        }
    }

}