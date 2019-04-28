package ru.kpfu.itis.aaTree;

public class Tree<T extends Comparable<T>> implements aaTree<T>{
    private Node<T> root;
    private Node<T> deletedNode;
    private Node<T> lastNode;
    private long it;

    long getIt(){
        return it;
    }

    void setIt(){
        this.it = (long)0;
    }
    public boolean isEmpty(){
        return this.root == null;
    }
    public Tree(){
        it = 0;
        this.root = null;
    }

    public void print(){
        if(this.root != null)
            print(this.root);
    }

    private void print(Node t){
        if(t == null)
            return;
        if(t.left != null)
            print(t.left);
        System.out.print(t.value + " ");
        if(t.right != null)
            print(t.right);
    }

    @Override
    public void clear(){
        root = null;
    }

    @Override
    public Node<T> skew(Node<T> t){
        if(t == null)
            return null;
        else if(t.left == null)
            return t;
        else if(t.left.level == t.level){
            Node<T> left = t.left;
            t.left = left.right;
            left.right = t;
            return left;
        } else
            return t;
    }

    @Override
    public Node<T> split(Node<T> t){
        if(t == null)
            return null;
        else if(t.right == null || t.right.right == null)
            return t;
        else if(t.level == t.right.right.level){
            Node<T> right = t.right;
            t.right = right.left;
            right.left = t;
            right.level = right.level + 1;
            return right;
        } else
            return t;
    }

    @Override
    public void insert(T value){
        this.root = insert(value, this.root);
    }

    private Node<T> insert(T value, Node<T> parent){
        it++;
        if(parent == null)
            parent = new Node<>(value, null, null);
        else if(value.compareTo(parent.value) < 0)
            parent.left = insert(value, parent.left);
        else if(value.compareTo(parent.value) > 0)
            parent.right = insert(value, parent.right);
        else
            return parent;
        parent = skew(parent);
        parent = split(parent);
        return parent;
    }

    @Override
    public void delete(T value){
        deletedNode = null;
        this.root = this.delete(value, this.root);
    }

    private Node<T> delete(T value, Node<T> t){
        it++;
        if(t != null && t.left != null && t.right != null){
            lastNode = t;
            if(value.compareTo(t.value) < 0)
                t.left = delete(value, t.left);
            else{
                deletedNode = t;
                t.right = delete(value, t.right);
            }
            if(t == lastNode){
                if(deletedNode == null)
                    return t;
                deletedNode.value = t.value;
                t = t.right;
            } else if(t.left.level < t.level - 1 || t.right.level < t.level - 1){
                if(t.right.level > --t.level)
                    t.right.level = t.level;
                t = skew(t);
                t.right = skew(t.right);
                t.right.right = skew(t.right.right);
                t = split(t);
                t.right = split(t.right);
                it += 5;
            }
        }
        return t;
    }

    @Override
    public boolean search(T value){
        return search(this.root, value);
    }

    private boolean search(Node<T> t, T value){
        while((t != null)){
            it++;
            T tValue = t.value;
            if(value.compareTo(tValue) < 0)
                t = t.left;
            else if(value.compareTo(tValue) > 0)
                t = t.right;
            else{
                return true;
            }
        }
        return false;
    }
}
