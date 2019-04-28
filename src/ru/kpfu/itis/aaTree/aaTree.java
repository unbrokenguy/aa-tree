package ru.kpfu.itis.aaTree;

public interface aaTree<T extends Comparable<T>>{
    void clear();

    boolean isEmpty();

    Node<T> skew(Node<T> t);

    Node<T> split(Node<T> t);

    void insert(T value);

    boolean search(T value);

    void delete(T value);
}
