/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.result.others;

import java.util.ArrayList; 
import java.lang.Exception; 
import java.util.Iterator;
/** 
* 
* @author User 
*/ 
public class MyOwnArrayList <E> implements Iterable<Object>{ 
private Object[] ElementData; 
MyOwnArrayList(){ 
this(10); 
} 
MyOwnArrayList(int i){ 
if (i < 0) 
throw new IllegalArgumentException("Illegal Capacity: "+i); 
this.ElementData=new Object[i]; 
} 
public void add(Object ob){ 
int i=0; 
for(i=0;i<ElementData.length;i++)if(ElementData[i]==null)break; 
if(i==ElementData.length)ensureCapacity(ElementData.length+1); 
ElementData[i]=ob; 
} 
public int size(){ 
int length=ElementData.length; 
return length; 
} 
public int indexOf(Object ob){ 
int index = 0; 
for(int i=0;i<ElementData.length;i++)if(ob.equals(ElementData[i]))return i; 
return -1; 
} 
public boolean contains(Object ob){ 
return indexOf(ob)>0; 
} 
public void remove(int index){ 
System.arraycopy(ElementData, index+1, ElementData, index, ElementData.length-index-1); 
ElementData[ElementData.length-1] = null; 
Object[] NewElementData=new Object[ElementData.length-1]; 
System.arraycopy(ElementData, 0, NewElementData, 0, ElementData.length-1); 
ElementData=new Object[NewElementData.length]; 
ElementData=NewElementData; 

} 
public void remove(Object ob){ 
int index=0; 
for(int i=0;i<ElementData.length;i++)if(ob.equals(ElementData[i])){ 
index=i; 
break; 
} 
remove(index); 
} 
public void set(int index,Object ob){ 
ElementData[index]=ob; 
} 
public void clear(){ 
for(int i=0;i<ElementData.length;i++)ElementData[i]=null; 
ElementData=new Object[0]; 
} 
private void ensureCapacity(int copacity){ 
if(copacity-ElementData.length>0){ 
Object[]NewElementData=new Object[ElementData.length+1]; 
System.arraycopy(ElementData, 0, NewElementData, 0, ElementData.length); 
ElementData=new Object[NewElementData.length]; 
ElementData=NewElementData; 
} 
} 
/* 
Для проверки методов 
*/ 
public void showAll(){ 
for(Object x:ElementData)System.out.println("Element: "+x); 
} 

@Override
public Iterator<Object> iterator() {
    return new Iterator() {
        int i;
        @Override
        public boolean hasNext() {
           return i!=ElementData.length;     
        }

        @Override
        public Object next() {
           i++;
           return ElementData[i-1];
        }
        
    };
}
}
