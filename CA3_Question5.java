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

        Queue<String> takeoffQueue = new LinkedList<String>();
        Queue<String> landingQueue = new LinkedList<String>();

        boolean exit = false;
        Scanner kb = new Scanner(System.in);
        String command = "";

        System.out.println("----- Flight Control Tower -----\n");

        do {
            System.out.print("Command: ");
            command = handleCommandInput(kb.nextLine());

            System.out.println("Entered Command -> " + command);

        }while(!exit);
    }

    public static String handleCommandInput(String input) {
        Scanner kb = new Scanner(System.in);

       while(!checkCommandInput(input)) {
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
