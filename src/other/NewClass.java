/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.util.Iterator;


/**
 *
 * @author Danny
 */
public class NewClass {
    public static void main(String[] args){
    MyOwnLinkedList moar=new MyOwnLinkedList();
    //Iterator it=moar.iterator();
    moar.add("SS");
    moar.add("dddddd");
    moar.add("ddd");
    //moar.showAll();
    Iterator it=moar.iterator();
    while(it.hasNext())System.out.println(it.next());
    }
}
