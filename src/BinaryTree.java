public class BinaryTree<T> implements Iterable<T>{

    //fields
    protected BinaryNode<T> root = null;

    //constructors
    public BinaryTree(){};

    //methods
    public boolean isEmpty(){
        return root == null;
    }

    public void insert(T element){
        if(element == null)
            throw new IllegalArgumentException();
        if(isEmpty())
            root = new BinaryNode(element);
        else
            root.insert(element);
    }

    public void remove(T element){
        if(element == null)
            throw new IllegalArgumentException();
        if(!isEmpty())
            root = root.remove(element);

    }

    public boolean contains(T element){
        if(isEmpty())
            return false;
        return root.contains(element);
    }

    public int height(){
        if(isEmpty())
            return -1;
        return root.height();
    }

    public int size(){
        if(isEmpty())
            return 0;
        return root.size();
    }

    public boolean equals(Object other){
        if(!(other instanceof BinaryTree<?>))
            return false;
        BinaryTree<?> otherTree = (BinaryTree<?>)other;
        if(isEmpty())
            return otherTree.isEmpty();

        return root.equals(otherTree.root);

    }

    public String toString(){
        if(isEmpty())
            return "Empty Tree";
        return root.toString();
    }

    public void inOrder(){
        if(!isEmpty())
            root.inOrder();
    }

    public void preOrder(){
        if(!isEmpty())
            root.inOrder();
    }

    public Iterator<T> iterator(){
        return new BinaryTreeInOrderIterator<>(root);
    }

    public Iterator<T> BFTIterator(){
        return new BinaryTreeBFSIterator<>(root);
    }
}
