import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class CA3_Question1 {
    public static void main(String[] args) {
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        Scanner kb = new Scanner(System.in);

        boolean specialEvent = true;
        System.out.println("The Special Event Car Park\n");


        while(specialEvent) {

            printDriveway(driveway); // display the current state of the driveway

            int reg;
            System.out.print("Enter your cars registration number(+ to add, - to retrieve): ");
            while(!kb.hasNextInt()) {
                System.out.println("--* A number plate consists of positive whole numbers *--");
                System.out.print("Enter your cars registration number: ");
                kb.next();
            }
            reg = kb.nextInt();

            // exit program
            if(reg == 0) {
                System.out.println("\n--* The special event has ended. *--");
                specialEvent = false;

            }

            // positive number, PARK car
            if(reg > 0) {
                if (driveway.search(reg) == -1) { // If the car is not there already
                    driveway.push(reg);
                } else {                           // Refuse entry
                    System.out.println("That's weird this car is already here...\nYou should leave.");
                }
            }

            // checking if the input reg is in the driveway to be retrieved
            boolean regFound = false;
            for(Integer element : driveway) {
                if(element == Math.abs(reg)) {
                    regFound = true;
                    break;
                }
            }
            if(!regFound && specialEvent) { // checking if specialEvent is true so this wont display when 0 is entered
                System.out.println("\n- - --*| There is no car currently in the driveway with the registration --> " + Math.abs(reg));
            }

            if(reg < 0 && !driveway.isEmpty() && regFound) // Negative number, RETRIEVE car
            {
                // change reg from negative to positive
                reg = Math.abs(reg);

                if(driveway.peek() == reg) {
                    System.out.println("You were the last one in. Lucky for us we don't have to move anybody's car to get yours.");
                    driveway.pop();
                } else {
                    // Move cars that are in the way to the street stack
                    int indexToRemove = driveway.search(reg) - 1;
                    System.out.println("\n- - - - --*| Moving cars from DRIVEWAY to STREET to retrieve car: " + reg + " |*-- - - - -");
                    for(int i = 0; i < indexToRemove; i++) {
                        street.push(driveway.pop());

                        printDriveway(driveway);
                        printStreet(street);
                    }

                    System.out.println("\t\t* * *| Car: " + driveway.peek() + " can now leave |* * *");
                    driveway.pop(); // remove the owners car from the driveway stack

                    System.out.println("\n- - - - --*| Moving cars from STREET to DRIVEWAY |*-- - - - -");
                    // add the cars that were on the street to the driveway stack
                    int streetCars = street.size();
                    for(int j = 0; j < streetCars; j++) {
                        driveway.push(street.pop());

                        printDriveway(driveway);
                        printStreet(street);
                    }
                }
            }
            System.out.println("\n");
        }
    }

    public static void printDriveway(Stack<Integer> driveway) {
        Iterator<Integer> drivewayIter = driveway.iterator();

        System.out.print("DRIVEWAY --* ");
        while(drivewayIter.hasNext()) {
            int carReg = drivewayIter.next();
            System.out.print("| Reg: " + carReg + " |");
        }
        if(driveway.isEmpty())
            System.out.println("There are no car's here.");
        System.out.println();
    }

    public static void printStreet(Stack<Integer> street) {
        Iterator<Integer> streetIter = street.iterator();

        System.out.print("STREET   --* ");
        while(streetIter.hasNext()) {
            int carReg = streetIter.next();

            System.out.print("| Reg: " + carReg + " |");
        }
        if(street.isEmpty())
            System.out.println("There are no car's here.");
        System.out.println("\n");
    }
}
