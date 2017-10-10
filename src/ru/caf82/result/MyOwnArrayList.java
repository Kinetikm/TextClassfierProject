package ru.caf82.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyOwnArrayList<E>  {
    private Object[] arrayOfData;
    private int size;
    private final static int DEFAULT_CAPACITY = 10;

    public MyOwnArrayList() {
        arrayOfData = new Object[DEFAULT_CAPACITY];
    }


    public void ensureCapacity(int minCapacity) {
        if (arrayOfData.length < minCapacity) {
            arrayOfData = Arrays.copyOf(arrayOfData, minCapacity);
        }
    }

    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (arrayOfData[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object element) {

        for (int i = 0; i < size; i++) {
            if (arrayOfData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] copyArrayBeforeIndex = Arrays.copyOfRange(arrayOfData,0,index);
        Object[] copyArrayAfterIndex = Arrays.copyOfRange(arrayOfData,index,size);
        Object[] newArrayOfData = new Object[++size];

        for (int i = 0; i < copyArrayBeforeIndex.length; i++) {
            newArrayOfData[i] = copyArrayBeforeIndex[i];
        }

        newArrayOfData[copyArrayBeforeIndex.length] = element;

        for (int i = 0; i < copyArrayAfterIndex.length; i++) {
            newArrayOfData[i + copyArrayBeforeIndex.length + 1] = copyArrayAfterIndex[i];
        }
        arrayOfData = newArrayOfData;
    }

    public boolean add(E element) {
        int capacity = arrayOfData.length;
        if (size == capacity) {
            ensureCapacity(++capacity);
        }
        arrayOfData[size++] = element;
        return true;
    }

    public int size() {
        return size;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return  (E) arrayOfData[index];
    }

    public E set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arrayOfData[index] = element;
        return element;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            arrayOfData[i] = null;
        }
        size = 0;
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E element = (E) arrayOfData[index];
        Object[] copyArrayBeforeIndex = Arrays.copyOfRange(arrayOfData,0,index);
        Object[] copyArrayAfterIndex = Arrays.copyOfRange(arrayOfData,index + 1,size);
        Object[] newArrayOfData = new Object[--size];

        for (int i = 0; i < copyArrayBeforeIndex.length; i++) {
            newArrayOfData[i] = copyArrayBeforeIndex[i];
        }
        for (int i = 0; i < copyArrayAfterIndex.length; i++) {
            newArrayOfData[i + copyArrayBeforeIndex.length] = copyArrayAfterIndex[i];
        }
        arrayOfData = newArrayOfData;
        return element;
    }

    public boolean remove(Object element) {
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(arrayOfData[i]).append(",").append(" ");
        }
        return stringBuilder.delete(stringBuilder.lastIndexOf(", "),stringBuilder.length()).append("]").toString();
    }

    public static void main(String[] args) {
//Тестим add
        MyOwnArrayList<Integer> myOwnArrayList = new MyOwnArrayList<>();
        myOwnArrayList.add(1);
        myOwnArrayList.add(2);
        myOwnArrayList.add(4);
        System.out.println(myOwnArrayList);
        myOwnArrayList.add(2,3);
        System.out.println(myOwnArrayList);
        System.out.println(myOwnArrayList.indexOf(1));
    }
}
