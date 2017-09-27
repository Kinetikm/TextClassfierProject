/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.ru.caf82.result.exceptions;

/**
 *
 * @author 1
 */
public class InconveninentShapeException extends Exception{
    
    private String message;
    private Throwable cause;
    public InconveninentShapeException () {
        
    }
    
    public InconveninentShapeException (String message) {
        this.message = message;
    }
    
    public InconveninentShapeException (Throwable cause) {
        this.cause = cause;
    }
    
    public InconveninentShapeException (String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }
}
