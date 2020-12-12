/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDdataaccessobject;


import DVDdatatransferobject.DataTransferObject;
import java.util.List;

/**
 *
 * @author boburmurtozaev
 */
public interface DataAccessObject {
    
    DataTransferObject addDVD (String title, DataTransferObject dto) throws DataAccessException;
    
    List<DataTransferObject> getAllDVD() throws DataAccessException;
    
    DataTransferObject getDVD(String title)throws DataAccessException;
    
    DataTransferObject removeDVD(String title)throws DataAccessException;
    
    DataTransferObject searchDVD(String title)throws DataAccessException;
    
    void editDVD(String title)throws DataAccessException;
        
      
    
}
