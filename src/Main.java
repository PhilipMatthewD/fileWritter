import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Mr. K");
        listOfStrings.add("2/22/2024");
        listOfStrings.add("CSCI 1660 - Java Fundamentals");

        String file = "classDescription.txt"; //This is the file name idiot
        try { // writeAssignment = method down the line
            // File is the imported Java extension that helps reads files inside the project folder
            // Scanner helps read the file
            writeAssignment(listOfStrings, file);
            File myObj = new File("classDescription.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void writeAssignment(ArrayList<String> assignment, String filename) throws FileNotFoundException{
        // ArrayList<String> assignment = listOfStrings ("Mr. K", "2/22/2024", "CSCI 1660 - Java Fundamentals")
        // String filename = file (String "classDescription.txt")
        // throws = The creation of the "FileNotFoundException" which helps break the code and produce an error for the method
        //^to then catch.
        // FileWriter is the Java import that allows you to use data types and insert them into a document

        try (FileWriter writer = new FileWriter(filename)) {
            for (String str : assignment) {
                writer.write(str + "\n");
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            System.err.print("Something Went Wrong");
        }
    }
}