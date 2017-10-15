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
public class EmptyArrayException extends Exception {
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
    public static void arrayNull(String[] x) throws EmptyArrayException {
        for (String x1 : x) {
            if (x1 == null) {
                throw new EmptyArrayException("Существуют пустые ячейки");
            }
            break;
        }
    }
    public void main (String[] args) throws EmptyArrayException{
        try{
            String[] x = {"hrue", "hhr",""};
            arrayNull(x);
        }catch (EmptyArrayException e){
            System.out.println("Ошибка!");
        }
    }
}
