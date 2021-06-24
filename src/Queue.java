public interface Queue<T> {

    //returns true iff the queue is empty.
    public boolean isEmpty();

    //inserts a new element to the end of the queue.
    public void enqueue(T element);

    //removes and returns the element at the front of the queue. (FIFO - First In First Out).
    public T dequeue();

    //returns the element at the front of the queue without removing it.
    public T peek();
}
