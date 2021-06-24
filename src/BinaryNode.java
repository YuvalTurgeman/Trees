public class BinaryNode<T> {

    //fields
    protected T data;
    protected BinaryNode<T> left = null;
    protected BinaryNode<T> right = null;

    //constructors
    public BinaryNode(T data){
        if(data == null)
            throw new IllegalArgumentException();
        this.data = data;
    }

    //methods
    public void insert(T element){
        if(Math.random()<0.5){
            if(left == null) left = new BinaryNode<>(element);
            else left.insert(element);
        }
        else{ if(right == null) right = new BinaryNode<>(element);
              else right.insert(element);
        }
    }

    public BinaryNode<T> remove(T element){
        BinaryNode<T> output = this;

        if(data.equals(element)){
            if(left != null){
                data = left.data;
                left = left.remove(data);
            }
            else if(right != null){
                data = right.data;
                right = right.remove(data);
            }
            else output = null;
        }
        else{
            if(left != null && left.contains(element))
                left = left.remove(element);
            else if(right != null)
                right = right.remove(element);
        }
        return output;
    }

    public boolean contains(T element){
        return data.equals(element) ||
                (left!= null && left.contains(element)) ||
                (right != null && right.contains(element));
    }

    public boolean contains2(T element){
        if(data.equals(element))
            return true;
        if(left != null && left.contains2(element))
            return true;
        if(right != null && right.contains2(element))
            return true;
        return false;
    }

    public int height(){
        int leftH = -1, rightH = -1;
        if(left != null)
            leftH = left.height();
        if(right != null)
            rightH = right.height();
        return 1 + Math.max(leftH, rightH);
    }

    public int size(){
        int leftS = 0, rightS = 0;
        if(left != null)
            leftS = left.size();
        if(right != null)
            rightS = right.size();
        return leftS + rightS + 1;
    }

    public boolean equals(Object other){
        if(!(other instanceof BinaryNode<?>))
            return false;
        BinaryNode<?> otherNode =(BinaryNode<?>)other;

        //check data
        if(!data.equals(otherNode.data))
            return false;
        //check left
        if((left == null | otherNode.left == null) & (left != otherNode.left))
            return false;
        if(left != null && !left.equals(otherNode.left))
            return false;
        //check right
        if((right == null | otherNode.right == null) & (right != otherNode.right))
            return false;
        if(right != null && !right.equals(otherNode.right))
            return false;

        return true;
    }

    public String toString(){
        return this.toString("\n", "\\-- ").substring(1);
    }
    //here we take off the first char because we do not want to move down a line in
    //before the root of the tree.

    private String toString(String spaces, String sign){
        String acc = spaces + sign + data;
        if(right != null)
            acc += right.toString(spaces + "    " , "|-- " );
        if(left != null)
            acc += left.toString(spaces + "    " , "\\-- " );
        return acc;
    }

    public void inOrder(){
        if(left != null)
            left.inOrder();
        System.out.println(data);
        if(right != null)
            right.inOrder();
    }

    public void preOrder(){
        System.out.println(data);
        if(left != null)
            left.preOrder();
        if(right != null)
            right.preOrder();
    }


}
