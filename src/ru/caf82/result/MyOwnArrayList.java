package ru.caf82.result;

import java.util.Arrays;
import java.util.Iterator;

public class MyOwnArrayList<E> implements Iterable<E> {
    private E[] arrayOfData; //Статический массив элементов
    private int size; // количество элементов в массиве
    private final static int DEFAULT_CAPACITY = 10; // Длина массив по умолчанию, при вызове конструктора без аргументов

    /**
     * Конструктор без аргументов
     */
    public MyOwnArrayList() {
        arrayOfData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор
     * Создаем массив с указанной емкостью
     * @param initialCapacity
     */
    public MyOwnArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        arrayOfData = (E[]) new Object[initialCapacity];
    }

    /**
     * Устанавливает минимальную длину
     * @param minCapacity
     * массива
     * @see MyOwnArrayList#arrayOfData, если заданный параметр больше текущей длины массива
     */
    public void ensureCapacity(int minCapacity) {
        if (arrayOfData.length < minCapacity) {
            arrayOfData = Arrays.copyOf(arrayOfData, minCapacity);
        }
    }

    /**
     * Метод выясняет, содержит ли массив элемент
     * @param element
     * @return true, если элемент содержится в массиве
     * иначе false
     */
    public boolean contains(E element) {
      return indexOf(element) != -1 ? true : false;  //Упрощенная конструкция if-else
    }

    /**
     * Метод возвращает индекс аргумента в массиве
     * @param element
     * @return Индекс элемента, если элемента нету в массиве, то return -1
     */
    public int indexOf(E element) {

        for (int i = 0; i < size; i++) {
            if (arrayOfData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Добавляет переданный элемент на место, заданное индексом
     * @param index место, куда вставим элемент
     * @param element сам элемент
     */
    public void add(int index, E element){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        E[] copyArrayBeforeIndex = Arrays.copyOfRange(arrayOfData,0,index);
        E[] copyArrayAfterIndex = Arrays.copyOfRange(arrayOfData,index,size);
        E[] newArrayOfData = (E[]) new Object[++size];

        for (int i = 0; i < copyArrayBeforeIndex.length; i++) {
            newArrayOfData[i] = copyArrayBeforeIndex[i];
        }

        newArrayOfData[copyArrayBeforeIndex.length] = element;

        for (int i = 0; i < copyArrayAfterIndex.length; i++) {
            newArrayOfData[i + copyArrayBeforeIndex.length + 1] = copyArrayAfterIndex[i];
        }
        arrayOfData = newArrayOfData;
    }

    /**
     * Метод добавления элемента в конец массива
     * @param element сам элемент
     * @return true
     */
    public boolean add(E element) {
       add(size,element);
        return true;
    }

    /**
     *
     * @return количество элементов в массиве
     */
    public int size() {
        return size;
    }

    /**
     * Возвращаем элемента из массива по индексу
     * @param index Индекс, по которому возвращаем элемент
     * @return Элемент
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return  arrayOfData[index];
    }

    /**
     * Меняем значение элемента по заданному индексу
     * @param index Индекс, на месте которого меняем значение элемента
     * @param element Хотим установить на заданный индекс
     * @return Этот же элемент
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arrayOfData[index] = element;
        return element;
    }

    /**
     * Полностью очищает массив
     */
    public void clear() {
     arrayOfData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Удаляет элемент из массива по заданному индексу
     * Элементы, справа стоящие от удаляемого элемента, сдвигаем влево
     * @param index По которому мы удаляим элемент
     * @return Элемент, который удалили
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E element =  arrayOfData[index];
        E[] copyArrayBeforeIndex = Arrays.copyOfRange(arrayOfData,0,index);
        E[] copyArrayAfterIndex = Arrays.copyOfRange(arrayOfData,index + 1,size);
        E[] newArrayOfData = (E[]) new Object[--size];

        for (int i = 0; i < copyArrayBeforeIndex.length; i++) {
            newArrayOfData[i] = copyArrayBeforeIndex[i];
        }
        for (int i = 0; i < copyArrayAfterIndex.length; i++) {
            newArrayOfData[i + copyArrayBeforeIndex.length] = copyArrayAfterIndex[i];
        }
        arrayOfData = newArrayOfData;
        return element;
    }

    /**
     * Удаляем из массива заданный элемент
     * @param element Его удаляем
     * @return true, если массив изменился, иначе false
     */
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * @return Строковое представление нашего динамического массива в формате [elem1, elem2,...,elemN]
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(arrayOfData[i]).append(",").append(" ");
        }
        return stringBuilder.delete(stringBuilder.lastIndexOf(", "),stringBuilder.length()).append("]").toString();
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>() {
             int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {

                return arrayOfData[index++];
            }
        };
    }

}
