package ru.caf82.result;

public class Node<E> {
    private E data; //Содержимое элемента
    private Node<E> next; // Ссылка на следующий элемент

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() { //Возвращает содержимое элемента
        return data;
    }

    public void setData(E data) { //Устанавливаем содержимое элемента
        this.data = data;
    }

    public Node<E> getNext() { //Возвращает следующий элемент
        return next;
    }

    public void setNext(Node<E> next) { //Перенаправляем ссылку next на заданный элемент
        this.next = next;
    }
}
