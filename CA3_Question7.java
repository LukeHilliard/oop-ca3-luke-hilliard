import java.util.*;

/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question7
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
            Extend Question 6 to a program that can handle shares of multiple companies. The user
            enters commands buy symbol quantity price and sell symbol quantity. Hint: Keep a
            Map<String, Queue<Block>> that manages a separate queue for each stock symbol.
         */

        Scanner in = new Scanner(System.in);
        String command;
        Queue<Share> shareQueue = new LinkedList<>();
        // Hash map initialized, using Hash Map over a Tree map as the order of the companies does
        // not matter and I will be able to be able to get the data faster.
        Map<String, Queue<Share>> companyPortfolios = new HashMap<>();


        System.out.println("- - - - - Somewhere in Wall St New York, NY, USA - - - - -\n");
        System.out.println("\t\t\t\tCommands: | buy | sell |\n");
        do {

            if(!companyPortfolios.isEmpty()) {
                System.out.println("\n");
                displayAllPortfolios(companyPortfolios);
                System.out.println("\n");
            }

            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                String compName;
                System.out.print("Company symbol: ");
                compName = in.next();

                System.out.print("Stock Quantity: ");
                while(!in.hasNextInt()) {
                    System.out.println("* * * Bad quantity input, enter an amount to buy * * *");
                    in.next();
                    System.out.print("\nStock Quantity: ");
                }
                int qty = in.nextInt();

                System.out.print("Stock Price: ");
                while(!in.hasNextInt() || !in.hasNextDouble()) {
                    System.out.println("* * * Bad quantity input, enter a currency amount to buy * * *");
                    in.next();
                    System.out.print("\nStock Price: ");
                }
                double price = in.nextDouble();

                Share newShare = new Share(qty, price);

                if(!companyPortfolios.containsKey(compName)) {
                    Queue<Share> newShareQueue = new LinkedList<>();
                    newShareQueue.add(newShare);
                    companyPortfolios.put(compName, newShareQueue);
                } else {
                    companyPortfolios.get(compName).add(newShare);
                }

            }
            else if(command.equals("sell"))
            {
                String compName;
                System.out.print("Company symbol: ");
                compName = in.next();

                System.out.print("Stock Quantity: ");
                while(!in.hasNextInt()) {
                    System.out.println("* * * Bad quantity input, enter an amount to buy * * *");
                    in.next();
                    System.out.print("\nStock Quantity: ");
                }
                int sellQty = in.nextInt();

                System.out.print("Stock Price: ");
                while(!in.hasNextDouble()) {
                    System.out.println("* * * Bad quantity input, enter a currency amount to buy * * *");
                    in.next();
                    System.out.print("\nStock Price: ");
                }
                double price = in.nextDouble();

                // create a new Queue to hold the selected companies shares
                Queue<Share> portfolioShares = companyPortfolios.get(compName);

                int qty = sellQty;
                double gain = 0.00;
                double cost = 0.00;
                while(!portfolioShares.isEmpty() && qty > 0) {
                    Share shareToBeSold = portfolioShares.peek();
                    System.out.println(shareToBeSold.getQuantity() + " " + shareToBeSold.getPrice());
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
                double profit = gain - cost;
                System.out.println("Sold " + sellQty + " shares, with a total profit of €" + profit);

            } else {
                System.out.println("* * * Bad command input * * *");
            }
        }while(!command.equalsIgnoreCase("quit"));
    }

    public static void displayAllPortfolios(Map<String, Queue<Share>> companyPortfolios) {

        System.out.println("| Company Symbol | Quantity | Price  |");

    }

    public static void displayIndividualPortfolio(Map<String, Queue<Share>> companyPortfolios, String key) {
        System.out.println("| " + key + "  | Quantity | Price  |");

    }

}