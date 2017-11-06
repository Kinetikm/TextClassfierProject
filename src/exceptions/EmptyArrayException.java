/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author 1
 */
public class EmptyArrayException extends Exception {

    private String message;
    private Throwable cause;

    public EmptyArrayException () {

    }

    public EmptyArrayException (String message) {
        this.message = message;
    }

    public EmptyArrayException (Throwable cause) {
        this.cause = cause;
    }

    public EmptyArrayException (String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }
}