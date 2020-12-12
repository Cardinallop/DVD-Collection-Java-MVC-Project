/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DVDapp;

import DVDcontroller.Controller;
import DVDdataaccessobject.DataAccessObject;
import DVDdataaccessobject.DataAccessObjectFileImplementation;
import DVDuserinterface.UserIO;
import DVDuserinterface.UserIOImplementation;
import DVDuserinterface.View;

/**
 *
 * @author boburmurtozaev
 */
public class App {
    
    public static void main(String[] args) {
        
        //System.out.println("Problem with Scanner!\nLogic problem in editDVD method");
        
        UserIO myio = new UserIOImplementation();
        View view = new View(myio);
        DataAccessObject dao = new DataAccessObjectFileImplementation();
        Controller ctrl = new Controller(dao, view);
        ctrl.run();
        
    }
    
}
