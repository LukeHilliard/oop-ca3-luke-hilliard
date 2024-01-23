import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
 */

public class CA3_Question5
{

    public static void main(String[] args)
    {

        Queue<String> takeoffQueue = new LinkedList<>();
        Queue<String> landingQueue = new LinkedList<>();

        takeoffQueue.add("Flight-001");
        takeoffQueue.add("Flight-002");
        takeoffQueue.add("Flight-003");
        takeoffQueue.add("Flight-004");

        landingQueue.add("Flight-101");
        landingQueue.add("Flight-102");
        landingQueue.add("Flight-103");
        landingQueue.add("Flight-104");
        landingQueue.add("Flight-105");


        boolean lastAddedWasTakeoff = false;
        boolean exit = false;
        String command;
        Scanner kb = new Scanner(System.in);

        System.out.println("----- Flight Control Tower -----\n");

        do {
            String flightSymbol;
            System.out.print("\nCommand: ");
            command = handleCommandInput(kb.nextLine()); // take command input and handle any invalid inputs

            if(command.equals("quit")) { // exit clause
                System.out.println("\n\nSimulation ending...");
                exit = true;
            }

            if(command.equalsIgnoreCase("takeoff")) {

                // input validation for Flight Symbol
                String temp;
                System.out.print("Flight Symbol (e.g. '432', '124'): ");
                temp = kb.nextLine();
                while(temp.length() != 3) {
                    System.out.print("A flight symbol should be 3 characters in length.\n-> ");
                    temp = kb.nextLine();
                }
                flightSymbol = "Flight-" + temp; // actual flight symbol

                //push this flight to the takeoff queue
                takeoffQueue.add(flightSymbol);
                lastAddedWasTakeoff = true;


            }
            if(command.equalsIgnoreCase("land")) {

                // input validation for Flight Symbol
                String temp;
                System.out.print("Flight Symbol ");
                temp = kb.nextLine();
                while(temp.length() != 3) {
                    System.out.print("A flight symbol should be 3 numbers in length.\n-> ");
                    temp = kb.nextLine();
                }
                flightSymbol = "Flight-" + temp; // actual flight symbol

                //push this flight to the takeoff queue
                landingQueue.add(flightSymbol);
                lastAddedWasTakeoff = false;
            }

            if(command.equalsIgnoreCase("next")) {

                /* check if landingQueue is empty, they have priority.
                    if !landingQueue.isEmpty()
                        land the next plane

                    else if there is anything in the takeoffQueue
                        let them take off

                    return
                */
                runSimulation(takeoffQueue, landingQueue, lastAddedWasTakeoff);
            }

        }while(!exit);
    }

    public static void runSimulation(Queue<String> takeoff, Queue<String> landing, boolean lastAddedWasTakeoff) {

        displayFlightOrder(takeoff, landing);
        System.out.println("\nSimulating :\n");

        if(lastAddedWasTakeoff) { // if the last plane added was planned to takeoff, let it
            System.out.println(takeoff.remove() + " is taking off from runway 1");

        } else {// let the other planes land
            while(!landing.isEmpty()) {
                System.out.println("Landing " + landing.remove());
            }
        }

        while(!landing.isEmpty()) {
            System.out.println("Landing " + landing.remove());
        }

        while(!takeoff.isEmpty()) { //
            System.out.println(takeoff.remove() + " is taking off from runway 1");
        }



    }

    public static void displayFlightOrder(Queue<String> takeoff, Queue<String> landing) {
        Iterator<String> takeoffIter = takeoff.iterator();
        Iterator<String> landingIter = landing.iterator();


        System.out.println("-- Current Flight Order --");
        System.out.println("Landing\t\t\tTakeoff");

        while (takeoffIter.hasNext() || landingIter.hasNext()) {
            // Display landing if available
            if (landingIter.hasNext()) {
                System.out.print(landingIter.next() + "\t\t\t");
            } else {
                System.out.print("\t\t\t"); // Empty space if no landing
            }
            // Display takeoff if available
            if (takeoffIter.hasNext()) {
                System.out.print(takeoffIter.next());
            }
            System.out.println(); // Move to the next line for the next pair of flights
        }

    }

    public static String handleCommandInput(String input) {
        Scanner kb = new Scanner(System.in);

       while(!checkCommandInput(input)) { // simple method which returns a boolean that checks the current input against 4 different commands
           System.out.println("*** Invalid command --> " + input + " ***\n");
           System.out.print("Command: ");
           input = kb.nextLine();
       }
        return input;
    }
    public static boolean checkCommandInput(String input) {
        return input.equalsIgnoreCase("takeoff") || input.equalsIgnoreCase("land") ||
                input.equalsIgnoreCase("next") || input.equalsIgnoreCase("quit");
    }

}
