/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.result.exceptions;

/**
 *
 * @author Вика
 */
public class EmptyArrayException extends Exception{
  public EmptyArrayException(){
      super();
  }
public EmptyArrayException(String message){
   super(message); 
}
public EmptyArrayException(String message, Throwable cause){
super(message, cause);
}
public EmptyArrayException(Throwable cause){
super(cause);
}
   public static void dotProduct(double[] a, double[] b) throws EmptyArrayException{
     
     if ((b.length == 0) || (a.length == 0) ) {
         throw new EmptyArrayException("Нулевые массивы");
     }
 } 
   public static void main(String[] args) {
     double[] a = {};        
     double[] b = {1};
     EmptyArrayException sed = new EmptyArrayException();
        try { sed.dotProduct(a,b);
            
     
     } catch(EmptyArrayException e){
            System.out.println("Мы поймали ошибку!");
     }

}
}