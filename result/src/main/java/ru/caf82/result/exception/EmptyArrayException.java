/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.result.exception;

/**
 *
 * @author admin
 */
public class EmptyArrayException extends Exception {
    
    public EmptyArrayException(){
    
}
    public EmptyArrayException(String message){
        super(message);
    }

    public EmptyArrayException (String message,Throwable cause){
        super(message, cause);
    }
    
    public EmptyArrayException (Throwable cause){
        super(cause);
    }
}
    