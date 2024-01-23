import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner in = new Scanner(file);

        Stack<String> tagStack = new Stack<String>();

        while (in.hasNext()) {
            String currentTag = in.next();

            // if the current tag is not a closing tag
            if(!currentTag.startsWith("</")) {
                tagStack.push(currentTag);
            }

            // if the current tag is a closing tag
            if(currentTag.startsWith("</")) {

                // if the current closing tag matches the last entry of the stack, pop from the stack
                if(currentTag.substring(2).equals(tagStack.peek().substring(1))) {
                    //System.out.println("pop");
                    tagStack.pop();
                } else { // if false, tags do not match, return false
                    return false;
                }
            }

        }
        return true;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;
     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
