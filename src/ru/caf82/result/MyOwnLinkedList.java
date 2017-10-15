package ru.caf82.result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyOwnLinkedList<E> {
    private Node<E> lastNode;
    private Node<E> firstNode;
    private int size;

    public MyOwnLinkedList() {
    }

    public MyOwnLinkedList(Collection <? extends E> c) {
        this();
        addAll(c); }

    public boolean add (E element) {
      add(size, element);
      return true;
    }

    private Node<E> node(int index) {
       Node<E> node = firstNode;
       if (index != 0) {
           for (int i = 1; i <= index; i++) {
               node = node.getNext();
           }
       }
       return node;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = new Node<>(element,null);
        if (index == 0) {
            node.setNext(firstNode);
            firstNode = node;
            if (lastNode == null) {
                lastNode = node;
            }
        }
        else {
            Node<E> prevNode = node(index - 1);
            Node<E> nextNode = prevNode.getNext();
                prevNode.setNext(node);
                node.setNext(nextNode);
            if (nextNode == null) {
                lastNode = node;
            }
        }
        size++;
    }

    public boolean contains(E element) {
      return indexOf(element) != -1 ? true : false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = node(index);
        Node<E> nextNode = node.getNext();
        node.setNext(null);
        if (index == 0) {
            firstNode = nextNode;
            if (nextNode == null) {
                lastNode = null;
            }
        }
        else
        {
            Node<E> prevNode = node(index - 1);
            prevNode.setNext(nextNode);
            if (nextNode == null) {
                lastNode = prevNode;
            }
        }
        size--;
        return node.getData();
    }

    public int indexOf(E element) {
        int count = -1;
        for (Node<E> node = firstNode; node != null; node = node.getNext()) {
            count++;
            if (node.getData().equals(element)) {
                return count;
            }
        }
        return -1;
    }

    public boolean remove(E element) {
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public E set(int index, E element) {
        node(index).setData(element);
        return element;
    }

    public E peek() {
        if (isEmpty()) {
           return null;
        }
        return firstNode.getData();
    }

    public boolean addAll(Collection<? extends E> c) {
        return addAll(size,c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Object[] arrayFromC = c.toArray();
        for (Object element : arrayFromC) {
            add(index + count, (E) element);
            count++;
        }
        return true;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove(0);
    }

    public boolean isEmpty() {
       return size == 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return node(index).getData();
    }

    public static void main(String[] args) {
        MyOwnLinkedList<String> myOwnLinkedList = new MyOwnLinkedList<>();
        myOwnLinkedList.add("First");
        myOwnLinkedList.add("Second");
        myOwnLinkedList.add(1,"Third");
        myOwnLinkedList.add(0,"Fourth");


        for (int i = 0; i < myOwnLinkedList.size(); i++) {
            System.out.println(myOwnLinkedList.get(i));
        }
        System.out.println(myOwnLinkedList.indexOf("Second"));
    }
}
