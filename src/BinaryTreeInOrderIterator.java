import java.util.NoSuchElementException;

public class BinaryTreeInOrderIterator<T> implements Iterator<T> {

    //fields
    private Stack<BinaryNode<T>> stack;

    //constructor
    public BinaryTreeInOrderIterator(BinaryNode<T> root){
        stack = new StackAsDynamicArray<>();
        prepareNext(root);
    }

    //methods
    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public T next(){
        if(!hasNext())
            throw new NoSuchElementException();
        BinaryNode<T> node = stack.pop();
        if(node.right != null)
            prepareNext(node.right);
        return node.data;
    }

    public void prepareNext(BinaryNode<T> node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
