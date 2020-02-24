package Bataille_navale;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Writer {
	public void save(File file,Board p1) {
		try
	    {    
	        //Saving of object in a file 
	        FileOutputStream f = new FileOutputStream(file); 
	        ObjectOutputStream out = new ObjectOutputStream(f); 
	          
	        // Method for serialization of object 
	        out.writeObject(p1); 
	          
	        out.close(); 
	        f.close(); 
	          
	        System.out.println("Game Saved"); 

	    } 
	
    catch(IOException ex) 
    { 
        System.out.println("IOException is caught"); 
    } 
	}	
	
	public Board load(File filename) {
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              Board p1= null;
	            // Method for deserialization of object 
	            p1= (Board) in.readObject();  
	            in.close(); 
	            file.close();
	            return p1; 
	        } 
		 
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught/File Not found"); 
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        }
		return null;
		
	  

	}
	
}

