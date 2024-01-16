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

            int reg;

            System.out.print("Enter your cars registration number(+ to add, - to retrieve): ");
            reg = kb.nextInt();

            if(reg == 0)
                specialEvent = false;

            if(reg > 0) { // Positive number, PARK car
                if (driveway.search(reg) == -1) { // If the car is not there already
                    driveway.push(reg);
                } else {                           // Refuse entry
                    System.out.println("That's weird this car is already here...\nYou should leave.\n");
                }
            }

            if(reg < 0 && !driveway.isEmpty()) // Negative number, RETRIEVE car
            {
                reg = Math.abs(reg); // change reg from negative to positive
                if(driveway.peek() == reg) {
                    driveway.pop();
                } else {
                    // Move cars that are in the way to the street stack
                    int indexToRemove = driveway.search(reg) - 1;
                    for(int i = 0; i < indexToRemove; i++) {
                        street.push(driveway.pop());
                    }

                    // remove the owners car from the driveway stack
                    driveway.pop();

                    // add the cars that were on the street to the driveway stack
                    int streetCars = street.size();
                    for(int j = 0; j < streetCars; j++) {
                        driveway.push(street.pop());
                    }
                }
            }
            printStack(driveway);
        }
    }

    public static void printStack(Stack<Integer> stack) {
        System.out.println(stack.toString());
    }
}
