package SelfStudy2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ques3 {

    public static void main(String[] args) {

        // Check command-line arguments if not then end the code
        if (args.length != 2) {
            System.out.println("Give 2 command arguments..");
            return;
        }
        //first arguement is the file name and second one is the word to count
        String fileName = args[0];
        String wordToFind = args[1];
        int count = 0;
        //buffferedReader is used to read a file because it is more efficient than fileReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {

                // Split line into words
                String[] words = line.split("\\W+");
                //now checking the arrray whether we have the word that is given in commandline argument
                for (String word : words) {
                    if (word.equalsIgnoreCase(wordToFind)) { //ignoreCase is used to ignore the case and give us true whenever we want to check the string ignoring the case
                        count++;
                    }
                }
            }

            System.out.println("Occurrences of '" + wordToFind + "': " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
