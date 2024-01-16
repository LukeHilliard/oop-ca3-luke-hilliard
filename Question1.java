import java.util.Scanner;
import java.util.Stack;

public class Question1 {

    /**
     * A homeowner rents out parking spaces in a driveway during special events. The driveway is
     * a “last-in, first-out” LIFO stack. Of course, when a car owner retrieves a vehicle that wasn’t
     * the last one in, the cars blocking it must temporarily move to the street so that the
     * requested vehicle can leave. Write a program that models this behaviour, using one stack for
     * the driveway and one stack for the street. Use integer values as license plate numbers (e.g.
     * 1,2,3,4…). Positive numbers add a car (1,2,3…), negative numbers remove a car(-2,-1,…), zero
     * stops the simulation. Print out the stack after each operation is complete.
     * So, entering “1” means – add car number 1 to the driveway, entering “
     * -2” means - retrieve
     * car number 2 from the driveway.
     */

    public static void main(String[] args) {
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        Scanner kb = new Scanner(System.in);

        boolean specialEvent = true;
        System.out.println("The Special Event Car Park\n");

        while(specialEvent) {
            int input;

            System.out.print("Enter your cars registration number: ");
            input = kb.nextInt();

           if(driveway.search(input) == -1) { // if the car is not there already
               driveway.push(input);
           } else {
               System.out.println("That's weird this car is already here...\nYou should leave.\n");
           }

            if(input == 0)
                specialEvent = false;
        }

    }

}
