/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.result.others;

import java.util.Iterator;

/**
 *
 * @author Вика
 */
public class NewClass {
  public static void main(String[] args){ 
MyOwnLinkedList moar=new MyOwnLinkedList(); 
//Iterator it=moar.iterator(); 
moar.add("1"); 
moar.add("2"); 
moar.add("3"); 
moar.add("4"); 
moar.add("5"); 
moar.add("6"); 
moar.add("7"); 
moar.add("8"); 
moar.add("9"); 
moar.add("10"); 
moar.add("11"); 
moar.add("12"); 
moar.add("13"); 
moar.add("14"); 
moar.add("15"); 

//moar.showAll(); 
Iterator it=moar.iterator(); 
while(it.hasNext())System.out.println(it.next());   
}
}
