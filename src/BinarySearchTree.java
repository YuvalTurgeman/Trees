import java.util.Comparator;
import java.util.NoSuchElementException;

public class BinarySearchTree<T> extends BinaryTree<T> {

    //fields
    private Comparator<T> comparator;

    //constructor
    public BinarySearchTree(Comparator<T> cmp){
        super();
        comparator = cmp;
    }/// not sure if need super here, ask roi

    //methods
    public Comparator<T> getComparator(){
        return comparator;
    }

    public void insert(T element){
        if(element == null)
            throw new IllegalArgumentException();
        if(isEmpty())
            root = new BinarySearchNode<>(element, comparator);
        else
            root.insert(element);
    }

    public boolean contains(T element){
        if(isEmpty())
            return false;
        return root.contains(element);
    }

    public void remove(T element){
        if(isEmpty())
            throw new NoSuchElementException();
        root = root.remove(element);
    }

    public boolean equals(Object other){
        if(!(other instanceof BinarySearchTree<?>))
            return false;
        Iterator<?> thisIter = this.iterator();
        Iterator<?> otherIter = ((BinarySearchTree<?>)other).iterator();
        while(thisIter.hasNext() && otherIter.hasNext())
            if(!thisIter.next().equals(otherIter.next()))
                return false;
        return thisIter.hasNext() == otherIter.hasNext();
    }

}
