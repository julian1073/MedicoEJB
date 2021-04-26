/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.exception;

/**
 *
 * @author Julian
 */
public class EmptyModelException extends Exception{
    
    public EmptyModelException(String mensaje){
        
        super(mensaje);
    }
}
