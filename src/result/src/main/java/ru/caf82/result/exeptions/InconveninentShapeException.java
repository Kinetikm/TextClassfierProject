package result.src.main.java.ru.caf82.result.exeptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Наташа
 */
public class InconveninentShapeException extends Exception {
    public InconveninentShapeException() {
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

    /**
     *
     * @param x
     * @param y
     * @throws InconveninentShapeException
     */
    public static void dotProductExample(double[] x, double[] y) throws InconveninentShapeException {
    if (x.length != y.length) throw new InconveninentShapeException("Массивы разной длины");
}

    public static void main () throws InconveninentShapeException{
    try{
        double[] a = {1.23, 2.12, 1};
        double[] b = {2, 3, 5.6, 45,2};
        dotProductExample(a,b);
    } catch (InconveninentShapeException e){
    System.out.println("Массивы разной длины");   
}  
}
}
