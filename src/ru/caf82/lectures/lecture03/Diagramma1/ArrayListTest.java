/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.lectures.lecture03.Diagramma1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import static javax.management.Query.value;

/**
 *
 * @author Наташа
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList();
        intList.add(5);
        intList.add(Integer.valueOf(15));
        intList.add(new Integer(10));
        HashMap<String, Integer> hm = new HashMap<>();
         hm.put("gyj", 1);
         hm.put("jtik", 2);
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("herk", 1);
        tm.put("hjf", 2);
        System.out.println(tm.toString());
    }
    
    
    
}
class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}