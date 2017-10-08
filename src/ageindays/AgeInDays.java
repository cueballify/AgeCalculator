/* 
 * Copyright (C) 2017 Diego Trujillo <diego.trujillo@alumni.nmt.edu>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ageindays;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.GregorianCalendar;

/**
 *
 * @author Diego Trujillo <diego.trujillo@alumni.nmt.edu>
 * CIS 406 - CH3, p148, #27
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
         
        
        //Ask the user for input
        System.out.println("Hello. Type your Birthday (YYYY MM DD):");
        //get the input
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        //confirm the input
        System.out.println("Birthday:\nYear: "+year+" Month: "+month+" Day: "+day);
        
        //System.out.println("you entered: "+input);
        
        
        
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
        
        //TODO calendar.compareTo to verify birth date does not occur in the future
        /*  Returns 0 if calendars are equal
            Returns -1 if the time of the current is less than arguement
            returns 1 of the time of current is greater than arguement
        */
        
        if(now.compareTo(birth)< 0){
            //now is less than birth, birthday is in the future
            System.out.println("Time Traveler detected. Don't worry."
                    + "\nYour secret is safe with me.");
            return;
        }
        
        //getTimeInMillis returns a LONG
        long AGE = now.getTimeInMillis() - birth.getTimeInMillis();
        
        
        //convert from milliseconds to days
        //1 second == 1000 milliseconds
        //1 minute == 60 seconds
        //1 hour == 60 minutes
        //1 day == 24 hours
        
        //The beauty here is that partial days are rounded off
        Long ageInDays = AGE / 1000 / 60 / 60 / 24;
        
        
        //System.out.println("AGE: "+AGE);  //age since EPOCH
        System.out.println("Age in Days: "+ageInDays);
        System.out.println("Years: "+(ageInDays / 365));  //sanity check
        
    }
    
}
