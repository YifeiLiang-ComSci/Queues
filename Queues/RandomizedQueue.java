import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size;
    private Item[] items;
    private int capacity;
    private int head;
    private int tail;
    // construct an empty randomized queue
    public RandomizedQueue()
    {

        items = (Item[]) new Object[1];
        size = 0;
        capacity = 1;
        head = 0;
        tail = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty()
    {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size()
    {
        return size;
    }

    // add the item
    private void reSize(int num)
    {
        Item[] temp = (Item[]) new Object[num];

        for (int i = 0; i < size; i++)
        {
            temp [i] = items[(head + i) % capacity];
        }
        capacity = num;
        items = temp;
        head = 0;
        tail = size;
    }
    public void enqueue(Item item)
    {
        if (item == null) {
            throw new IllegalArgumentException();
        }


        if (size >= capacity)
        {
           reSize(capacity*2);
        }
        size++;
        items[tail % capacity] = item;
        tail++;

    }

    // remove and return a random item
    public Item dequeue()
    {
        if (isEmpty())
        {
            throw new java.util.NoSuchElementException();
        }

        int index = (StdRandom.uniform(size) + head) % capacity;
        Item item = items[index];
        items[index] = items[tail - 1];
        items[tail - 1] = null;
        tail--;
        size--;




        if (capacity != 1 && capacity/4 == size)
        {
            reSize(capacity/2);
        }

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample()
    {
        if (isEmpty())
        {
            throw new java.util.NoSuchElementException();
        }
        int index = StdRandom.uniform(size) + head;
        return items[index%capacity];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
    {
        return new QueueIterator();
    }
    private class QueueIterator implements Iterator<Item>
    {
        private int last = size - 1;
        private int count = 0;
        private Item[] iteratorItems;

        public QueueIterator()
        {
            iteratorItems = (Item[]) new Object[size];
            for (int i = 0; i < size; i++)
            {
                iteratorItems[i] = items[(i + head)% capacity];
            }
        }
        public boolean hasNext()
        {

            return last != -1;
        }

        public Item next() {
            if (!hasNext())
            {
                throw new java.util.NoSuchElementException();
            }
            int index = StdRandom.uniform(last + 1);
            Item item = iteratorItems[index];
            iteratorItems[index] = iteratorItems[last];
            iteratorItems[last] = null;
            last--;





            return item;

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    // unit testing (required)
    public static void main(String[] args)
    {

        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();










        // que.enqueue(1);
        // que.enqueue(2);
        // que.enqueue(1);

    }

}