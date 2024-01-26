
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
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
        Queue<Share> shareQueue = new LinkedList<>();

            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();

                // add new buy to the queue
                shareQueue.add(new Share(qty, price));

            }
            else if(command.equals("sell"))
            {
                int sellQty = in.nextInt();
                double price = in.nextDouble();
                int qty = sellQty;
                double gain = 0.00;
                double cost = 0.00;
                double profit = 0.00;
                /*
                 if the last entry to the queue is <= sellingQty          shareQueue.getQuantity

                 profit = price * shareQueue.getQuantity
                 sellQty -= shareQueue.getQuantity

                 loop until sellQty = 0
                 */
                while(!shareQueue.isEmpty() && qty > 0) {
                   Share shareToBeSold = shareQueue.peek();

                   if(shareToBeSold.getQuantity() <= qty) {
                       gain += price * shareToBeSold.getQuantity();
                       qty -= shareToBeSold.getQuantity();
                       cost += shareToBeSold.getQuantity() * shareToBeSold.getPrice();
                       shareQueue.remove();
                   } else {
                       gain += price * qty;
                       shareToBeSold.setQuantity(shareToBeSold.getQuantity() - qty);
                       cost += shareToBeSold.getQuantity() * shareToBeSold.getPrice();
                       qty = 0;
                   }
                }
                profit = gain - cost;
                System.out.println("Sold " + sellQty + " shares, with a total profit of €" + profit);
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}