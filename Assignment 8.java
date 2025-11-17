import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
     public static void main(String[] args){
        String line;
        List<String> list = new ArrayList<>();
        File inputfile = new File("practice.txt");
        try {
            Scanner input = new Scanner(inputfile);
            while(input.hasNext()) {
                line = input.nextLine();
                list.add(line);
            }
            //loop that checks the gpa of each student relying on the formatting of the file
            //the loop skips over the names and only parses and checks the gpa values
            List<String> gpaNames = new ArrayList<>();
            for (int i = 1; i < list.size(); i+=2) {
                if(Double.parseDouble(list.get(i)) >= 3.5) {
                    gpaNames.add(list.get(i-1));
                }
            }
            // simply to organize the output better than printing each name individually
            System.out.println("\nStudents with a GPA of 3.5 or higher:");
            for (int i = 0; i < gpaNames.size(); i++) {
                System.out.print(gpaNames.get(i));
                if (i < gpaNames.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //simple way to count names in the file but assumes that the file is formatted correctly (no blank or extra lines)
        System.out.println("\nThere are " + list.size()/2 + " names in the file\n");
    }
}

// this assignment gave me more practice with arraylists and working within (reading) files separate from main.
// also more practice parsing strings to other data types and looping in specific ways, all within a try-catch.