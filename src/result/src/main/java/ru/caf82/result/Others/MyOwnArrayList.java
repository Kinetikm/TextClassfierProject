/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.src.main.java.ru.caf82.result.Others;

import java.lang.reflect.Array;

/**
 *
 * @author Наташа
 * @param <T>
 */
public class MyOwnArrayList<T> {
    private T[] T;
    private int capacity;
    private int size;
    private Class<?> inCl;
    
public MyOwnArrayList(){
    capacity = 10;
    size = 0;
}
public MyOwnArrayList(int capa) {
    capacity =  capa;
    size = 0;
}

    /**
     *
     * @param inCl
     * @param capa
     */
    public MyOwnArrayList(Class<?> inClass, int capa) {
    capacity = capa;
    size = 0;
    inCl = inClass;
}

   

    public void ensureCapacity() {
    if (capacity < size + 1) {
        T[] oldArray = (T[])Array.newInstance(inCl, size);
        capacity = (capacity*3)/2+1;
        T[] elementData = (T[])Array.newInstance(inCl, capacity);
        System.arraycopy(oldArray, 0, elementData, 0, size);
    }
    else System.out.println("Место есть");
}
    
    public void ensureCapacity(int index, T value) {
        if (capacity < size + 1) {
            T[] oldArray;
            oldArray = (T[])Array.newInstance(inCl.getClass(), size);
            capacity = (capacity*3)/2+1;
            T[] elementData = (T[]) new Object[capacity];
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
            elementData[index] = value;
            size++;
        }
    }

    /**
     *
     * @param value
     */
    
    public void add(T value) {
    if (inCl==null) {
       inCl = value.getClass();
    }
    else 
        if (inCl != value.getClass()) {
        System.out.println("Типы данных отличаются, работать не могу");
    }
    else System.out.println("Всё ОК");
    ensureCapacity();
    T[] oldArray = (T[])Array.newInstance(inCl, size);
    oldArray = T;
    /*T[] elementData = (T[])Array.newInstance(inCl, capacity);
        System.arraycopy(oldArray, 0, elementData, 0, size);*/
        T = (T[])Array.newInstance(inCl, capacity);
        
        //System.arraycopy(oldArray, 0, T, 0, size+1);
        for (int i = 0; i<size; i++) 
            T[i] = oldArray[i];
        size++;
    T[size-1] = value; 
    
    
}
    public void printArray () {
        for (int i=0; i<size; i++) 
            System.out.println(T[i]);
    }
    public void add(T value, int index) {
        if (inCl == null) {
       inCl = value.getClass();
    }
    else 
        if (inCl.getClass() == value.getClass()) {
        System.out.println("Типы данных отличаются, работать не могу");
    }
    else System.out.println("Всё ОК");
       ensureCapacity(index, value);
        
    }
    
    
    public int indexOf (T value){
        int ind = -1;
        for (int i = 0; i<size; i++) {
        if (T[i] == value) {
            ind = i;
        }
        else System.out.println("Этот элемент не равен");
    }
        System.out.println("Нет этого элемента в массиве, если вернулось -1");
        return ind;
    }
    public boolean contains(T value) {
        for (int i = 0; i<size; i++) {
            if (T[i] == value) {
                return true;
            }
            else System.out.println("Не равен, к сожалению");
        }
        return false;
    }
    
    public void set(T value, int index) {
        T[index] = value;
    }
    public void remove(int index) {
        int scop = size - index -1;
        System.arraycopy(T, index + 1, T, index, scop);
        T[--size] = null;
    }
    public void remove(T value) {
        for (int i = 0; i<size; i++) {
            if (T[i] == value) {
                int scop = size - i -1;
                System.arraycopy(T, i + 1, T, i, scop);
                T[--size] = null;
            }
            else System.out.println("Не судьба");
        }
    }
    public void clear(T[] prelest){
        for (int i = 0; i<size; i++) {
            prelest[i] = null; 
        } 
        size = 0;
        capacity = 0;
    }

    public static void main (String[] args) {
    MyOwnArrayList prelest = new MyOwnArrayList();
    prelest.add("hugh");
    prelest.add("vi");
    prelest.add("jifj");
    prelest.add("jbhi");
    prelest.printArray();
    prelest.add("yugy");
    prelest.printArray();
    prelest.remove(1);
    prelest.printArray();
    }
}