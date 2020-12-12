/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDcontroller;

import DVDdataaccessobject.DataAccessException;
import DVDdataaccessobject.DataAccessObject;
import DVDdataaccessobject.DataAccessObjectFileImplementation;
import DVDdatatransferobject.DataTransferObject;
import DVDuserinterface.UserIO;
import DVDuserinterface.UserIOImplementation;
import DVDuserinterface.View;
import java.util.List;

/**
 *
 * @author boburmurtozaev
 */
public class Controller {
    
    //the brain of the operation
    private DataAccessObject dao;
    private View view;
    
    public Controller(DataAccessObject dao, View view){
        
        this.dao = dao;
        this.view = view;
        
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        while(keepGoing){
           
            menuSelection = getMenuSelection();
            
            switch(menuSelection){
                case 1:
                    listDVDs();
                    break;
                case 2:
                    addNewDVD();
                    break;
                case 3:
                    viewDVD();
                    break;
                case 4: 
                    removeDVD();
                    break;
                case 5: 
                    searchDVD();
                    break;
                case 6:
                    editDVD();
                    break;
                case 7: 
                    keepGoing = false;
                    break;
                default: 
                    unknownCommand();
            }
        } exitMessage();
    }catch(DataAccessException e){
        view.displayErroMessage(e.getMessage());
    }
    }
    
    
       private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
    
    private void addNewDVD()throws DataAccessException{
        
        view.displayAddDVDBanner();
        DataTransferObject nuDVD = view.getNewDVDInfo();
        dao.addDVD(nuDVD.getTitle(), nuDVD);
        view.displayAddSuccessBanner();
    }
    
    private void viewDVD()throws DataAccessException{
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DataTransferObject dto = dao.getDVD(title);
        view.displayDVD(dto);
    }
    
    private void editDVD()throws DataAccessException{
        view.displayEditDVDBanner();
        
        String title = view.getTitleChoice();
        DataTransferObject dvd1 = view.editDVD(dao.getDVD(title));
        dao.addDVD(dvd1.getTitle(), dvd1);
        view.displayEditDVDSuccessBanner();
    }
    
    private void removeDVD()throws DataAccessException{
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getTitleChoice();
        DataTransferObject reDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(reDVD);
    }
    
    private void listDVDs()throws DataAccessException{
        
        view.displayDisplayAllDVDsBannner();
        List<DataTransferObject> dvdList = dao.getAllDVD();
        view.displayDVDList(dvdList);
    }
    
    private void searchDVD()throws DataAccessException{
        
        view.displaySearchDVDBanner();
        String titl = view.getTitleChoice();
        DataTransferObject dto = dao.searchDVD(titl);
        view.displayDVD(dto);
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
    
}
