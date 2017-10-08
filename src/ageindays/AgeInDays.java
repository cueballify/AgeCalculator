/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ageindays;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.GregorianCalendar;

/**
 *
 * @author Diego Trujillo <diego.trujillo@alumni.nmt.edu>
 */
public class AgeInDays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ask the user to input their birthday
        
        Scanner scanner = new Scanner(System.in);
        //String input="";
        //Scanner stringScanner = new Scanner(input);
        //scanner.useDelimiter("-");
        
        //format input dates to friendly day of week
        SimpleDateFormat dayOfWeek = new SimpleDateFormat("EEEE"); 
        
        //Ask the user for input
        System.out.println("Hello. Type your Birthday (YYYY MM DD):");
        //get the input
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        //confirm the input
        System.out.println("Birthday:\nYear: "+year+" Month: "+month+" Day: "+day);
        
        //System.out.println("you entered: "+input);
        
        //calendar.compareTo to verify birth date does not occur in the future
        
        /* The Plan:
            convert user input into a calendar object representing their BDAY
            Instantiate another calendar representing NOW
            Compare the two to verify birthday isnt in teh future
            
            THE COMPUTATION:
            Using the birthday as a zero time representing a point time from 
            EPOCH to birth; The current time representing EPOCH to Present. 
        
            If we subtract Birthday from the current time, we are left with the 
            age of the individual. 
        
            This method assusmes the individual was born after EPOCH. 
            Need to verifiy that this will work with old people. 
        
        */
        
        //(year, month, day of month) constructor
        GregorianCalendar birth = new GregorianCalendar(year, month, day);  
        
        //DEFAULT constructor creates a calendar representing now
        GregorianCalendar now = new GregorianCalendar();
        
        //getTimeInMillis returns a LONG
        long AGE = now.getTimeInMillis() - birth.getTimeInMillis();
        
        
        //convert from milliseconds to days
        //1 second == 1000 milliseconds
        //1 minute == 60 seconds
        //1 hour == 60 minutes
        //1 day == 24 hours
        
        //The beauty here is that partial days are rounded off
        Long ageInDays = AGE / 1000 / 60 / 60 / 24;
        
        
        //System.out.println("AGE: "+AGE);
        System.out.println("Age in Days: "+ageInDays);
        //System.out.println("Years: "+(ageInDays / 365));  //sanity check
        
    }
    
}
