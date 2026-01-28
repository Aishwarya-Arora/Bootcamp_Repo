package SelfStudy2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class User {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    public User(String firstName, String lastName, int age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + age + "," + phoneNumber;
    }
}

public class Ques2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        //FileWriter is a I/O class used to write character data into a file
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            //here we are opening users.txt and passing true so that we can append at the end of the existing file
            while (true) {

                System.out.print("Enter First Name: ");
                String firstName = sc.nextLine();

                System.out.print("Enter Last Name: ");
                String lastName = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Phone Number: ");
                String phoneNumber = sc.nextLine();

                // Create User object
                User user = new User(firstName, lastName, age, phoneNumber);

                // Append user data to file
                writer.write(user.toString());
                writer.write(System.lineSeparator());
                writer.flush();

                System.out.println("User saved successfully!");

                // Prompt to continue
                System.out.print("Do you want to continue creating users? (Type QUIT to exit): ");
                choice = sc.nextLine();

                if (choice.equalsIgnoreCase("QUIT")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        sc.close();
        System.out.println("Program terminated.");
    }

    }

