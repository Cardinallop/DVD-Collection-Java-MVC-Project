/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDdataaccessobject;

import DVDdatatransferobject.DataTransferObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author boburmurtozaev
 */
public class DataAccessObjectFileImplementation implements DataAccessObject {
    
    private Map<String, DataTransferObject> dvds = new HashMap<>();
    
    public static final String DVD_FILE = "DVD-Collection.txt";
    public static final String DELIMITER = "::";

    @Override
    public DataTransferObject addDVD(String title, DataTransferObject dto) throws DataAccessException {
        
        loadCollection();
        DataTransferObject prevDVD = dvds.put(title, dto);
        writeCollection();
        
        return prevDVD;
    }

    @Override
    public List<DataTransferObject> getAllDVD() throws DataAccessException {
        loadCollection();
        return new ArrayList<DataTransferObject>(dvds.values());
    }

    @Override
    public DataTransferObject getDVD(String title) throws DataAccessException {
       
        loadCollection();
        return dvds.get(title);
    }

    @Override
    public DataTransferObject removeDVD(String title) throws DataAccessException {
        
        loadCollection();
        DataTransferObject removedDVD = dvds.remove(title);
        writeCollection();
        return removedDVD;
    }

    @Override
    public DataTransferObject searchDVD(String title) throws DataAccessException{
        loadCollection();
        return dvds.get(title);
    }

    @Override
    public void editDVD(String title) throws DataAccessException{
        loadCollection();
        writeCollection();
        
         //dvds.get(title);
         
    }
    
    private DataTransferObject unmarshallDVD(String dvdAstext){
        
        String [] dvdTokens = dvdAstext.split((DELIMITER));
        
        String title = dvdTokens[0];
        
        DataTransferObject dvdFromFile = new DataTransferObject(title);
        
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setRatingMPAA(dvdTokens[2]);
        dvdFromFile.setDirectorName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserRating(dvdTokens[5]);
        
        return dvdFromFile;
    }
    
    private void loadCollection() throws DataAccessException {
        
        Scanner scan;
        
        try{
            scan = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
            
        }catch(FileNotFoundException e){
            throw new DataAccessException("-_- Data load failed", e);
        }
        
        String currline;
        DataTransferObject currDVD;
        
        while(scan.hasNextLine()){
            
            currline = scan.nextLine();
            currDVD = unmarshallDVD(currline);
            
            dvds.put(currDVD.getTitle(), currDVD);
            
        }
        
        scan.close();
    }
    
    private String marshallDVD(DataTransferObject dvd){
        
        String dvdText = dvd.getTitle()+DELIMITER;
        
        dvdText+=dvd.getReleaseDate()+DELIMITER;
        dvdText+=dvd.getRatingMPAA()+DELIMITER;
        dvdText+=dvd.getDirectorName()+DELIMITER;
        dvdText+=dvd.getStudio()+DELIMITER;
        dvdText+=dvd.getUserRating()+DELIMITER;
        
        return dvdText;
        
    }
    private void writeCollection() throws DataAccessException {
            
        PrintWriter scanner;
        try {
            scanner = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (FileNotFoundException e) {
            throw new DataAccessException( "-_- Could not load DVD data into memory.", e);
        } catch (IOException i){
            throw new DataAccessException("-_- File not found");
        }
        String currentLine;
        for(Map.Entry<String, DataTransferObject> thisStudent: dvds.entrySet()){
            scanner.println(marshallDVD(thisStudent.getValue()));
        }
        scanner.close();
    
    }

}
   