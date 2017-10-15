package ru.caf82.result;

import java.util.Collection;


public class MyOwnLinkedList<E> {
    private Node<E> lastNode; // последний элемент списка
    private Node<E> firstNode; // последний элемент списка
    private int size; // количество элементов списка

    /**
     * Конструктор по умолчанию
     */
    public MyOwnLinkedList() {
    }

    /**
     * Создаем список с последующем добавлением заданной коллекции
     * @param c коллекцию, которую добавим в только что созданный список
     */
    public MyOwnLinkedList(Collection <? extends E> c) {
        this(); // Вызываем конструктор по умоланию, расположенный выше
        addAll(c); }

    /**
     * Добавляем заданный элемент в конец списка
     * @param element
     * @return true
     */
    public boolean add (E element) {
      add(size, element);
      return true;
    }

    /**
     * Возвращает элемент, стоящий в заданной позиции
     * Вспомогательный метод
     * @param index
     * @return элемент
     */
    private Node<E> node(int index) {
       Node<E> node = firstNode;
       if (index != 0) {
           for (int i = 1; i <= index; i++) {
               node = node.getNext();
           }
       }
       return node;
    }

    /**
     * Добавляем заданный элемент в заданную позицию списка
     * @param index позиция, в которую поставим заданный элемент
     * @param element
     */
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

    /**
     * Метод проверяет,содержит ли список заданный элемент
     * @param element
     * @return true, если заданный элемент есть в списке, иначе false
     */
    public boolean contains(E element) {
      return indexOf(element) != -1 ? true : false;
    }

    /**
     * Удаляет элемент из списка по заданной позиции,
     * элементы, стоящие справа от удаляемого элемента, сдвигаются вправо
     * @param index Позиция, из которой удаляем элемент
     * @return сам элемент
     */
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

    /**
     * Возвращает индекс первого вхождения заданного элемента
     * @param element
     * @return позицию первого вхождения
     */
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

    /**
     * Удаляем заданный элемент из списка
     * @param element заданный элемент
     * @return true, если список изменился, иначе false
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
     * Устанавливаем новое значение элемента в заданной позиции
     * @param index Индекс, в котором устанавливаем новоен значение элемента за место старого
     * @param element Элемент,которой хотим установить
     * @return Новый элемент
     */
    public E set(int index, E element) {
        node(index).setData(element);
        return element;
    }

    /**
     * Извлекаем, но не удаляем голову из списка
     * @return голову списка
     */
    public E peek() {
        if (isEmpty()) {
           return null;
        }
        return firstNode.getData();
    }

    /**
     * Добавляем все элементы заданной коллекции в конец списка
     * @param c коллекция
     * @return true
     */
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size,c);
    }

    /**
     * Добавляем все элементы заданной колекции в заданную позицию
     * @param index Позиция, в которую добавим ПЕРВЫЙ элемент из коллекции
     * Следующие элементы добавляем по порядку после ПЕРВОГО
     * @param c Коллекция
     * @return true
     */
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

    /**
     * Извлекаем и удаляем ПЕРВЫЙ элемент (голову) списка
     * @return голову списка
     */
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove(0);
    }

    /**
     * Проверяем пустой ли список
     * @return true, если пустой
     * иначе false
     */
    public boolean isEmpty() {
       return size == 0;
    }

    /**
     * @return количество элементов списка
     */
    public int size() {
        return size;
    }

    /**
     * Возвращаем элемент из заданной позиции
     * @param index заданная позиция
     * @return Элемент из заданной позиции
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return node(index).getData();
    }

    /**
     * @return Строковое представление списка в формате [elem1, elem2,...,elemN]
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Node<E> node = firstNode; node !=null; node = node.getNext()) {
            stringBuilder.append(node.getData()).append(",").append(" ");
        }
        return stringBuilder.delete(stringBuilder.lastIndexOf(", "),stringBuilder.length()).append("]").toString();
    }

}
