/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.util.Iterator;

/**
 *
 * @author User
 */
public class MyOwnLinkedList<E> implements Iterable {

    private int size;
    private Entry<E> head;
    private Entry<E> pred;

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Entry<E> e = head;

            @Override
            public boolean hasNext() {
                return (e != null);
            }

            @Override
            public Object next() {
                Object ob = e.element;
                e = e.next;
                return ob;
            }

        };
    }

    private static class Entry<E> {

        Object element;
        Entry<E> next;
        Entry<E> prev;

        Entry(E element) {
            this.element = element;
        }
    }

    public void add(Object ob) {
        Entry<E> e = new Entry(ob);
        if (size == 0) {
            head = e;
            //head.next=e;
            //head.prev=e;
        } else {
            pred.next = e;
            e.prev = pred;
        }
        pred = e;
        //head.prev=e;
        size++;

    }

    public boolean contains(Object ob) {
        Entry<E> e = head;
        while (e.next != null) {
            if (e.element.equals(ob)) {
                return true;
            }
            e = e.next;
        }
        return false;
    }

    public void remove(Object ob) {
        Entry<E> e = head;
        size--;
        do {
            if (size == 0) {
                head = null;
                break;
            }
            if (e.element.equals(ob)) {
                if (head.element.equals(ob)) {
                    poll();
                    break;
                } else if (e.next == null) {
                    e.prev.next = null;
                    break;
                } else {
                    e.next.prev = e.prev;
                    e.prev.next = e.next;
                    break;
                }
            }
            e = e.next;
        } while (e != null);
    }

    public void set(int index, Object ob) {
        Entry<E> e = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                e.element = ob;
            }
            e = e.next;
        }
    }

    public Object peek() {
        return head.element;
    }

    public void addAll(Object[] ob) {
        for (Object x : ob) {
            add(x);
        }
    }

    public Object poll() {
        Entry<E> e = head;
        head = head.next;
        head.prev = null;
        return e.element;
    }

    /*
    Для проверки методов
     */
    public void showAll() {
        Entry<E> e = head;
        while (e.next != null) {
            System.out.println(e.element);
            e = e.next;
        }
        System.out.println(e.element);
    }
}
