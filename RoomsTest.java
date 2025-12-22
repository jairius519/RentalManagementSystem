import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
   Program to test the basic functionality of the MyBnb class written by my professor.
*/
public class RoomsTest
{
   public static void main(String [] args) throws FileNotFoundException
   {
      MyBnb rentals = new MyBnb("rental1.txt");
      Scanner scan = new Scanner(new File("rental1.txt"));
      while (scan.hasNextLine()) {
         String elements = scan.nextLine();
         System.out.println(elements);
      }

        
      System.out.printf("Number of rooms with 2 bed(s): %d\n", 
                                      rentals.numberOfRooms(2));    // Expected: 3
    
      System.out.println(rentals.chooseRoom(3));                    // Expected: AB1213
      System.out.println(rentals.numberOfStaffNeeded());            // Expected: 2
      System.out.println(rentals.chooseRoom(1));                    // Expected: AB1212
      System.out.println(rentals.numberOfStaffNeeded());            // Expected: 3
      System.out.println(rentals.chooseRoom(1));                    // Expected: AB233
      System.out.println(rentals.numberOfStaffNeeded());            // Expected: 3
       
      
   }
}


