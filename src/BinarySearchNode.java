import java.util.Comparator;

public class BinarySearchNode<T> extends BinaryNode<T> {

    //fields
    private Comparator<T> comparator;

    //constructors
    public BinarySearchNode(T element, Comparator<T> comp) {
        super(element);
        comparator = comp;
    }

    public void insert(T element) {
        if (comparator.compare(data, element) < 0) {
            if (right == null)
                right = new BinarySearchNode<T>(element, comparator);
            else
                right.insert(element);
        } else {
            if (left == null)
                left = new BinarySearchNode<T>(element, comparator);
            else
                left.insert(element);
        }
    }

    public boolean contains(T element) {
        int compResult = comparator.compare(data, element);
        if (compResult == 0)
            return true;
        if (compResult < 0)
            return right != null && right.contains(element);
        return left != null && left.contains(element);
    }

    public BinaryNode<T> remove(T element) {
        int compResult = comparator.compare(data, element);
        if (compResult > 0) {
            if (left != null)
                left.remove(element);
        } else if (compResult < 0) {
            if (right != null)
                right.remove(element);
        } else { // Need to remove the data in this node.
            if (data.equals(element))
                if (left == null || right == null) { // The base cases.
                    if (left == null)
                        return right;
                    else
                        return left;
                } else { // This node has two children
                    data = ((BinarySearchNode<T>) right).findMin();
                    right = right.remove(element);
                }
            else {
                if (left != null)
                    left.remove(element);
            }
        }
        return this;
    }

    public T findMin() {
        BinaryNode<T> currNode = this;
        while (currNode.left != null) {
            currNode = currNode.left;
        }
        return currNode.data;
    }
}
