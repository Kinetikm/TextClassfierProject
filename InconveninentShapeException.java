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
 class InconveninentShapeException  extends Exception{
  public InconveninentShapeException(){
      super();
  }
public InconveninentShapeException(String message){
   super(message); 
}
public InconveninentShapeException(String message, Throwable cause){
super(message, cause);
}
public InconveninentShapeException(Throwable cause){
super(cause);
}
  
 public static void dotProduct(double[] a, double[] b) throws InconveninentShapeException{
     if (a.length != b.length) { 
         throw new InconveninentShapeException("Разные размеры массивов");
     }
 }
 public static void main(String[] args) {
     double[] a = {1, 2, 3, 4};        
     double[] b = {1, 1, 1, 1, 2};
     InconveninentShapeException sed = new InconveninentShapeException();
        try { sed.dotProduct(a,b);
            
     
     } catch(InconveninentShapeException e){
            System.out.println("Мы поймали ошибку!");
     }
            
 }
 }
 