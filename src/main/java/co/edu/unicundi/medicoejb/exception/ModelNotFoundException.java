/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.exception;

/**
 *
 * @author Julián Vásquez, Daniel Perez
 * @version 1.0.0
 * @since 11/03/2021
 */
public class ModelNotFoundException extends Exception{
 
    public ModelNotFoundException(String mensaje){
        
        super(mensaje);
    }
}
