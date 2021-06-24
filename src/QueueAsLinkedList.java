import java.util.NoSuchElementException;

public class QueueAsLinkedList<T> implements Queue<T> {

    //fields
    private List<T> list;

    //constructor
    public QueueAsLinkedList(){
        list = new LinkedList<T>();
    }

    //methods
    public boolean isEmpty(){
        return isEmpty();
    }

    public void enqueue(T element){
        list.add(element);
    }
    //There is no need to check if the element is null here because List.add already checks the element.

    public T dequeue(){
        if(isEmpty())
            throw new NoSuchElementException();
        return list.remove(0);
    }
    //List.remove is returning null if the list is empty and we and we want to throw an exception.

    public T peek(){
        if(isEmpty())
            return null;
        return list.get(0);
    }
}
