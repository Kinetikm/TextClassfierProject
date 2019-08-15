/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *
 * @author Danny
 */
public class B implements Serializable{   
    public void serialization(Class A){
       Class cl=A.class; 
       Field[] field=cl.getDeclaredFields();
       for(Field f:field){
           Ser ser=f.getAnnotation(Ser.class);
           if(ser==null){
               try(ObjectOutputStream ois=new ObjectOutputStream(new FileOutputStream("PathToFile"))){
                   ois.writeObject(f);
               }
               catch(Exception ex){
                   ex.printStackTrace();
               }
           }        
       }
    }
}
