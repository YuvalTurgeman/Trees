import java.util.NoSuchElementException;

public class BinaryTreeBFSIterator<T> implements Iterator<T> {

    //fields
    private Queue<BinaryNode<T>> queue;

    //constructor
    public BinaryTreeBFSIterator(BinaryNode<T> root) {
        queue = new QueueAsLinkedList<>();
        if(root != null)
            queue.enqueue(root);
    }

    //methods
    public boolean hasNext(){
        return !queue.isEmpty();
    }

    public T next(){
        if(!hasNext())
            throw new NoSuchElementException();
        BinaryNode<T> node = queue.dequeue();
        if(node.left != null)
            queue.enqueue(node.left);
        if(node.right != null)
            queue.enqueue(node.right);
        return node.data;
    }
}
