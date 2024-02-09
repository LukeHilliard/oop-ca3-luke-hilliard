import java.io.*;
import java.util.*;

/**
 *  Name: Luke Hilliard
 *  Class Group: SD2b
 */

public class CA3_Question3
{

    public static void readFile(String fileName) throws FileNotFoundException
    {
       File file = new File(fileName);
       Scanner sc = new Scanner(file);

        // A map with the identifier as the key and a List of integers to keep track of the multiple line numbers an identifier may occur on
        Map<String, List<Integer>> identifierMap = new HashMap<>();
        int lineNumber = 0;

        while(sc.hasNext()) { // while the LINE has next
            lineNumber++;
            String line = sc.nextLine();
            Scanner lineScnr = new Scanner(line);
            lineScnr.useDelimiter("[^A-Za-z0-9_]+");   // tokenize the scanner

            while(lineScnr.hasNext()) // while the WORD has next
            {
               String identifier = lineScnr.next();
               // if the found identifier is not already in the map, add it
               if(!identifierMap.containsKey(identifier)) {
                   identifierMap.put(identifier, new ArrayList<>());
               }
               // get the corresponding entry from the map using the key and add the line number to the List
               identifierMap.get(identifier).add(lineNumber);
            }
       }


        System.out.println("----- Java Identifier Count -----");
        System.out.println("From -> " + fileName + "\n");

        // Display Identifiers and their line numbers
        for(Map.Entry<String, List<Integer>> entry : identifierMap.entrySet()) {
            String key = entry.getKey();
            List<Integer> lineNumbers = entry.getValue();

            System.out.println(key + " -> " + lineNumbers.toString());
        }
    }
    public static void main(String[] args)throws IOException {
        readFile("CA3_Question1.java");

    }
}
