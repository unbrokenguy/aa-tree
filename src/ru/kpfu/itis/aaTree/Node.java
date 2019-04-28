package ru.kpfu.itis.aaTree;

import java.util.Objects;

public class Node<T>{
    public int level;
    public Node<T> left;
    public Node<T> right;
    public T value;

    public Node(T value, Node<T> left, Node<T> right){
        this.level = 1;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Node))
            return false;
        Node<?> node = (Node<?>)o;
        return level == node.level && Objects.equals(left, node.left) && Objects.equals(right, node.right) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(level, left, right, value);
    }

    public Node(T value){
        this(value, null, null);
    }

    public Node(){
        this.level = 0;
        this.value = null;
        this.left = this.right = this;
    }
}
