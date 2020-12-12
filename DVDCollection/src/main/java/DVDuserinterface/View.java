/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDuserinterface;

import DVDdatatransferobject.DataTransferObject;
import java.util.List;

/**
 *
 * @author boburmurtozaev
 */
public class View {
    
    private UserIO io;
    
    public View(UserIO io){
        
        this.io = io;
    }
    
    public int printMenuAndGetSelection(){
        
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add New DVD");
        io.print("3. View DVD");
        io.print("4. Remove DVD");
        io.print("5. Search DVD");
        io.print("6. Edit DVD");
        io.print("7. Exit");
        
        return io.readInt("Please select from the above choices", 1, 7);
    }
    
    public DataTransferObject getNewDVDInfo(){
        
        String title = io.readString("Please enter DVD title");
        
        String releaseDate = io.readString("Please enter release date");
        
        String ratingMPAA = io.readString("Please enter MPAA rating");
        
        String directorName = io.readString("Please enter director's name");
        
        String studio = io.readString("Please enter studio name");
        
        String userRating = io.readString("Please enter your own rating");
        
        DataTransferObject newDVD = new DataTransferObject(title);
        
        newDVD.setReleaseDate(releaseDate);
        newDVD.setRatingMPAA(ratingMPAA);
        newDVD.setDirectorName(directorName);
        newDVD.setStudio(studio);
        newDVD.setUserRating(userRating);
        
        return newDVD;
        
    }
    
    public void displayDVDList(List<DataTransferObject> dvdList){
        
        for(DataTransferObject dvd : dvdList){
            String dvdInfo = String.format("#%s : %s %s", 
                    dvd.getTitle(),
                    dvd.getReleaseDate(),
                    dvd.getRatingMPAA(),
                    dvd.getDirectorName(),
                    dvd.getStudio(),
                    dvd.getUserRating());
            io.print(dvdInfo);
        }
        
        io.readString("Please hit enter to continue");
    }
    
    public String getTitleChoice(){
        return io.readString("Please enter the DVD title");
    }
    
    public void displayDVD(DataTransferObject dvd){
        
        if(dvd!=null){
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getDirectorName()); 
            io.print(dvd.getStudio());
        }else{
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue");
    }
    
    public DataTransferObject editDVD(DataTransferObject dvd){
        
        DataTransferObject obj = null;
        
        if(dvd!=null){
            //dvd.setTitle(io.readString("Type new title"));
            dvd.setReleaseDate(io.readString("Type new release date"));
            dvd.setDirectorName(io.readString("Type new director name"));
            dvd.setStudio(io.readString("Type new Studio"));
            obj =  dvd;
        }else{
            io.print("No such DVD");
        } io.readString("Please hit enter to continue");
        return obj;
    } 
    
    
    
    public void displayAddDVDBanner(){
        io.print("=== ADD NEW DVD ===");
    }
    
    public void displayAddSuccessBanner(){
        io.readString("DVD has successfully been added to the collection. "
                + "Please hit enter to continue");
    }
    
    public void displayDisplayAllDVDsBannner(){
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDisplayDVDBanner(){
        io.print("=== Display DVD ===");
    }
    
    public void displayEditDVDBanner(){
        io.print("=== Edit DVD info ===");
    }
    
     public void displayEditDVDSuccessBanner(){
        io.print("=== DVD info has been edited ===");
    }
     
     public void displayRemoveDVDBanner(){
         io.print("=== Remove DVD ===");
     }
     public void displayRemoveResult(DataTransferObject dto){
         
         if(dto!=null){
             io.print("DVD successfully removed");
         }else{
             io.print("No such DVD");
         }
         io.readDouble("Please hit enter to continue");
     }
     
     public void displaySearchDVDBanner(){
         io.print("=== Searching DVD ===");
     }
     
     public void displayExitBanner(){
         io.print("Good Bye!!!");
     }
     
     public void displayUnknownCommandBanner(){
         io.print("Unknown Command!!!");
     }
     
     public void displayErroMessage(String error){
         io.print("=== Error ===");
         io.print(error);
     }
        
              
}
