
import java.util.Scanner;
/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        /*
            Suppose you buy 100 shares of a stock at $12 per share, then another 100 at $10 per share,
            and then sell 150 shares at $15. You have to pay taxes on the gain, but exactly what is the
            gain? In the United States,
            the FIFO rule holds:
            1) You first sell all shares of the first batch for a profit of $300,
            2) then 50 of the shares from the second batch, for a profit of $250,
            3) yielding a total profit of $550.

            Write a program that can make these calculations for arbitrary
            purchases and sales of shares in a single company. The user enters commands
            buy quantity price, and sell quantity (which causes the gain to be displayed), and quit.
            Hint:
            Keep a queue of objects of a class Block that contains the quantity and price of a block of
            shares.
         */

       Scanner in = new Scanner(System.in);
        String command="";
            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();

            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();


            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}