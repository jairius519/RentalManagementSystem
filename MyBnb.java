import java.io.*;
import java.util.*;

/*
    Date: October 4, 2023
    Program Description: MyBnb is used for renting and has various rooms followed by staff.
    Name: Jairius Burks
 */

/*
MyBnb.java was implemented entirely by me as part of CSCI 2073(Data Structures).
*/

 /**
    * MyBnb is ued for renting and has various rooms followed by staff.
    * Anyone can chose their own unique room
*/
public class MyBnb { 

   /**
      * A list of rental room objects
   */
   List<RentalRoom> elements = new ArrayList<>();
   
   /**
      * Mybnb constructor that reads from a file and stores that data into a arrayList
      * @param fileName file name of the room id and beds 
      */
   public MyBnb(String fileName) {
   
      try {
         Scanner keyboard = new Scanner(new File(fileName));
        
         while(keyboard.hasNext()) {
            String information = keyboard.next();
            int bedNumbers = keyboard.nextInt();
            elements.add(new RentalRoom(information, bedNumbers));
               
         }
           
      }
      
      catch(FileNotFoundException e ) {
         System.out.println("File Not Found");
      }
        
                  
   }
    
    /**
      * Loops through all of the rooms and if the number of beds equals the beds, accumulate.
      * @param beds beds in the Bnb
      * @return the count 
     */
   public int numberOfRooms(int beds) {
      int  count = 0;
      
      for(int i = 0; i < elements.size(); i++) {
         if(elements.get(i).getNumBeds()== beds)
            count++;
             
      }
   
      return count;
   }
       
    /**
      * Loops through the rooms and chooses the first room that's available with
      * at least the minnimum number of beds.
      * @param minBeds The minimum number of beds
      * @return the room ID. returns NONE if no room is available 
       
     */
   public String chooseRoom(int minBeds) {
   
      boolean choice = false;
    
      for(int index = 0; index < elements.size(); index++) {
         RentalRoom room = elements.get(index);
      
         if(room.getNumBeds() >= minBeds && room.isAvailable())  {
            room.setAvailable(choice);
            return room.getID();
         }
      
            
      }
      return "NONE";
   }

    /**
     * returns the number of staff needed to clean the rooms that are not available
     * two staff members are needed to clean each room with three or more beds
     * one staff member is needed for each group of three one-bed rooms
     * @return the number of staff needed to clean the rooms that are occupied
     */
   public int numberOfStaffNeeded() {
   
      int threeBedRooms = 0;
      int oneBedRooms = 0;
      int twoBedRooms = 0;
      
      for(RentalRoom rooms : elements) {
         if(rooms.getNumBeds() >= 3)
            threeBedRooms++;
         
         else if(rooms.getNumBeds() == 1)
            oneBedRooms++;
         
         else if(rooms.getNumBeds()== 2)
            twoBedRooms++;
      }
   
      int staff = 1 * threeBedRooms + (int)Math.ceil((oneBedRooms + 2  * twoBedRooms ) /3) ;
      return staff;
   
        
   
   }
    
}  



