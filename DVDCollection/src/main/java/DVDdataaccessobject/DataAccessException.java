/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDdataaccessobject;

/**
 *
 * @author boburmurtozaev
 */
public class DataAccessException extends Exception {
    
    public DataAccessException(String message){
        super(message);
    }
    
    public DataAccessException(String message, Throwable cause){
        super(message);
    }
    
}
