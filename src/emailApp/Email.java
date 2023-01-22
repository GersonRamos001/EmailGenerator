package emailApp;

import java.util.*;
import java.io.*;

public class Email {

    public Scanner scan = new Scanner(System.in);
    private String fName;
    private String lName;
    private String dept;
    private String email;
    private String password;
    private String alterEmail;
    private int mailCapacity = 500;
    
    //Constructor

    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        System.out.println("New employee: " + this.fName + " " + this.lName);
        this.dept=this.setDept();
        this.password = this.generatePassword(8);
        this.email = this.generateEmail();
    }


    private String generateEmail() {
        return this.fName.toLowerCase() + "." + this.lName.toLowerCase() + "@" + this.dept.toLowerCase() + ".company.com";
    }

    private String setDept() {
        System.out.println("Deparment codes \n1 for sales \n2 for development \n3 for accounting \n0 for none");
        boolean flag = false;
        do {
            System.out.println("Enter department code");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";

                default:
                    System.out.println("Invalid choice please choose it again");
            }
        } while (!flag);

        return null;
    }
    
    //GenerateRandomPassword
    private String generatePassword(int length){
        Random r = new Random();
        String capitalChart="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetter="abcdefghijklmnopqrstuvwxyz";
        String numbers="0123456789";
        String symbols ="!#@$%&?";
        String values = capitalChart+smallLetter+numbers+symbols;
        String password = "";
        
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));   
        }
        return password;
    }
    
    //change password methods
    public void setPassword(){
        boolean flag=false;
        
        do {            
            System.out.println("Do you want to change your password!(Y/N)");
            char choice = scan.next().charAt(0);
            if(choice =='Y' || choice == 'y'){
                flag = true;
                System.out.println("Enter current password: ");
                String temp = scan.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter a new Password");
                    this.password = scan.next();
                    System.out.println("Password changed successfully");
                }else{
                    System.out.println("Incorrect password");
                }
            }else if(choice =='N' || choice =='n'){
                flag = true;
                System.out.println("Password changed option cancelled!");
            }else{
                System.out.println("Enter Valid choice");
            }
        } while (!flag);
        
    }
    
    //set mailbox capacity method
    public void setMailCapacity(){
        System.out.println("Current capacity= "+ this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity");
        this.mailCapacity = scan.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
        
        }
    
    //set alternate mail
    
    public void alternativeEmail(){
          System.out.println("Enter new alternative email");
          this.alterEmail = scan.next();
          System.out.println("Alternative email is set");
        
        
    }
    
    //display user information method
    public void getInfo(){
        System.out.println("New: " + this.fName+" "+this.lName);
        System.out.println("Deparment: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox Capacity: " + this.mailCapacity+"mb");
        System.out.println("Alternate mail: "+ this.alterEmail);
    }
    
    //store file
    
    public void storeFile(){
        try {
            FileWriter in = new FileWriter("C:\\Users\\ramos\\Documents\\NetBeansProjects\\ApplicationGenerateEmail\\files\\info.txt");
            in.write("First name: " + this.fName);
            in.append("\nLast Name: " + this.lName);
            in.append("\nEmail: " + this.email);
            in.append("\nPassword: " + this.password);
            in.append("\nCapacity: " + this.mailCapacity);
            in.append("\nAlternate mail: " + this.alterEmail);
            in.close();
            System.out.println("Data Stored...");
            
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
        }
    }
    
    //Reading File
    public void readFile(){
        
        try {
            FileReader f1 = new FileReader("C:\\Users\\ramos\\Documents\\NetBeansProjects\\ApplicationGenerateEmail\\files\\info.txt");
            int i;
            while ((i=f1.read())!=-1) {
                System.out.print((char)i);  
               
            }
            System.out.println("File read Successfully");
             f1.close();
        } catch (Exception e) {
            System.err.println("Error"+e.getMessage());
        }
    }
    
}
