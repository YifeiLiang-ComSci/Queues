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
        if (head.equals(tail)) {
            tail = null;
            head = null;
        } else {


            head = head.next;
            head.previous = null;
        }
        size--;
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
        if (head.equals(tail))
        {
            tail = null;
            head = null;
        } else {
            tail = tail.previous;
            tail.next = null;

        }
        size--;
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
            if (!hasNext())
            {
                throw new java.util.NoSuchElementException();
            }
            Item temp = current.data;
            current = current.next;
            return temp;

        }
        public void remove() {
            throw new UnsupportedOperationException();
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


        que.addFirst(1);
        que.addFirst(2);

        que.removeLast();
        que.removeFirst();
    }

}