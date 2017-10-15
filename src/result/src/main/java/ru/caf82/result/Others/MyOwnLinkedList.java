/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.src.main.java.ru.caf82.result.Others;

/**
 *
 * @author Наташа
 * @param <T>
 */
public class MyOwnLinkedList<T> {
    private int size;
    private Entry<T> head;
    private Entry<T> tail; 
   
     
    public MyOwnLinkedList(){
    size = 0 ;
    tail = head = null;
    }    
    
    public void addEnd(T element) {
        Entry el = new Entry(element);
        if (tail == null) {
            head = tail = el;
        }
        else tail.next = el; tail = el;
        size++;
    }
    
    public void addStart(T value) {
        Entry el = new Entry(value);
        if (head == null) {
            head = el;
            tail = el;
        }      
        else el.next = head; 
             el = head;
            
    }
        
    public void addMid(T element, int index) {
        Entry el = new Entry(element);
        Entry head2 = head;
        if (size < index) {
            System.out.println("Сорри, не сущесвует элемента с таким индексом, запихиваем в конец");
        }
        else System.out.println("Окей, будем запихивать");
        
            for (int i = 0; i < index; i++) {
                head2 = head2.next;
            }
            el.next = head2.next;
            head2.next = el;
        }
    public void removeBegin() {
        if (head == null) {
            System.out.println("Итак там ничего нет");
        }
        else System.out.println("Продолжим наше дело");
           Entry head2 = head;
           head.next = head2;
           head = null;
    }
    public void removeEnd() {
        if (tail == null) {
            System.out.println("Ничего делать не надо");
        }
        else tail = null;
                size--;
    }
    public void removeValue (T value) {
        Entry head2 = head.next;
        Entry head3 = head;
        if (head.element == value){
            head.element = null;
            head.next = head;
            size--;
        }
        else
        while (head2.element != value) {
            head2.next = head2;
            head3.next = head3;       
        }
            head3.next = head2.next;
            head2.element = null;
            size--;
        
    }
    public void removeIndex(int index) {
        if (index == 0) {
            head.next = head;
            head.element = null;
        }
        else System.out.println("Индекс не ноль, идём дальше");
            int i = 1;
            Entry head2 = head;
            Entry head3 = head.next;
            if (size < index) {
                System.out.println("Нет такого индекса");
         }
            else System.out.println("Что-то точно удалим");
                while (i!= index) {
                i++;
                 head2.next = head2;
                 head3.next = head3;
                 }
                    head2.next = head3.next;
                    head3.element = null;   
    }
    public boolean contains(T value) {
        Entry head2 = head;
        boolean ver = false;
        for (int i = 0; i<size; i++) {
            if (head.element == value) {
               ver = true; 
            }
            else head2.next = head2;
        }
        return ver;
    }        
    
    public void set(int index, T value) {
        if (index > size) {
            System.out.println("Не можем вставить, не существует элемента с данным индексом");
        }
        else System.out.println("Продолжаем");
            Entry head2 = head;
            for (int i = 0; i < size; i++){
                head2.next = head2;
            }
            head2.element = value;
    }
    
    public T peek(int index){
        int i = 0;
        Entry head2 = head;
      if (index > size) {
            System.out.println("Не можем вставить, не существует элемента с данным индексом");
        }
      else System.out.println("Продолжаем");
         while (i != index) {
             head2.next = head2;
             i++;
         }
         T ver = (T) head2.element;
            return ver;
    }
    
    public T poll(int index) { 
      int i = 1;
      if (index == 0){
           T ver = (T) head.element;
           head.next = head;
           head.element = null;
       }
       else System.out.println("Индекс не равен нулю, продолжаем работу");
        Entry head2 = head;
        Entry head3 = head.next;
        if (index > size) {
             System.out.println("Не можем вставить, не существует элемента с данным индексом");
        }
        else System.out.println("Продолжаем");
            while (i != index) {
                i++;
                head2.next = head2;
                head3.next = head3;
            }
            head2.next = head3.next;
            T ver = (T) head3.element;
            head3.element = null;
    return ver;        
    }
    public void printList() {
        //Entry head2 = head;
        while (head != null) {
            System.out.println(head.element);
            head = head.next;
        }
    }
    
    
    
    public static void main (String[] args) {
       MyOwnLinkedList prel = new MyOwnLinkedList(); 
       //prel.addEnd("behu");
       //prel.printList();
       System.out.println("Первый пошёл");
       prel.addStart("gygc");
       prel.printList();
       System.out.println("Попробуем вставить по индексу");
       prel.addMid("jhk", 0);
    }

    private class Entry<T> {
    T element;
    Entry<T> next;
	
    Entry(T el)
    {
        element = el;
    }
}
}
