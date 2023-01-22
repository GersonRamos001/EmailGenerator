package Main;

import java.util.*;
import emailApp.Email;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //user info
        System.out.println("Enter first name");
        String fName = scan.next();
        System.out.println("Enter last name");
        String lName = scan.next();

        //creating object for email class
        Email em1 = new Email(fName, lName);
        int choice = -1;
        do {
            System.out.println("\n*************\nEnter your choice "
                    + "\n1.Show Info"
                    + "\n2.Change password"
                    + "\n3.Change email"
                    + "\n4.Set alternate email"
                    + "\n5.Store Data on file"
                    + "\n6.Display data from file"
                    + "\n7.Exit");

            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.setPassword();
                    break;
                case 3:
                    em1.setMailCapacity();
                    break;
                case 4:
                    em1.alternativeEmail();
                    break;
                case 5:
                    em1.storeFile();
                    break;
                case 6:
                    em1.readFile();
                    
                    break;
                case 7:
                    System.out.println("Thank you for using this application");
                    break;
                default:
                    System.out.println("Error invalid choice");
            }
        } while (choice != 7);

    }

}
