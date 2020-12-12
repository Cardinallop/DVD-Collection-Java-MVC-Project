/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDdatatransferobject;

/**
 *
 * @author boburmurtozaev
 */
public class DataTransferObject {
    
    private String title;
    private String releaseDate;
    private String ratingMPAA;
    private String directorName;
    private String studio;
    private String userRating;
    
    public DataTransferObject(String title){
        this.title = title;
    }
    
    public void setTitle(String messa){
        this.title = messa;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getReleaseDate(){
        return releaseDate;
    }
   
    public void setReleaseDate(String date){
        this.releaseDate = date;
    }
    
    public String getRatingMPAA(){
        return ratingMPAA;
    }
    
    public void setRatingMPAA(String message){
        this.ratingMPAA = message;
    }
    
    public String getDirectorName(){
        return directorName;
    }
    
    public void setDirectorName(String messages){
        this.directorName = messages;
    }
    
    public String getStudio(){
        return studio;
    }
    
    public void setStudio(String message){
        this.studio = message;
    }
    
    public String getUserRating(){
        return userRating;
    }
    
    public void setUserRating(String message){
        this.userRating = message;
    }
    
    
    
}
