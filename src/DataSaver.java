import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver {
    public static void main(String[] args){

        ArrayList <String>csv = new ArrayList<>();
        csv.add("Sample data for our file writing example");
        csv.add("Sample data Line 2");
        csv.add("Sample data Line 3");
        csv.add("Sample data Line 4");
        csv.add("Sample data Line 5");
        Scanner obj = new Scanner(System.in);
        String userInput = " ";
        String firstName = " ";
        String lastName = " ";
        String idNumber = " ";
        String email = " ";
        int birthYear = 0;
        boolean fact = false;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");


        do {
            firstName = SafeInput.getNonZeroLenString(obj,"Input your first name.");
            lastName = SafeInput.getNonZeroLenString(obj,"Input your last name.");
            idNumber = SafeInput.getNonZeroLenString(obj,"Input your ID number.");
            email = SafeInput.getNonZeroLenString(obj,"Input your email.");
            birthYear = SafeInput.getInt(obj,"Input your birth year");
        }while (fact);


        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for (String rec : csv)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}