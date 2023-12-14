package com.pluralsight;

import java.util.Scanner;
import static com.pluralsight.DataManager.*;
public class MenuManager {
    public static Scanner scan = new Scanner(System.in);

    public static void menuOrder(){
        greeting();
        newShipperMenu();
        displayAllMenu();
        updateShipperMenu();
        displayAllMenu();
        deleteShipperMenu();
        displayAllMenu();
        exit();
    }

    public static void greeting() {
        System.out.print("Welcome to the Northwind Shippers Manager!\n\n");
    }

    public static void exit(){
        System.out.println("\nThank you for using the Northwind Shippers Manager! See you again soon!");
    }

    public static void newShipperMenu(){
        try {
            System.out.print("Please enter the NAME of your new Shipper (Ex: 'Super Shipping').\n" +
                    "User Input: ");
            String newName = scan.nextLine();
            System.out.print("Please enter the NUMBER of your new Shipper (Ex: '(123) 456-7890').\n" +
                    "User Input: ");
            String newPhone = scan.nextLine();
            System.out.println("\nSuccessfully Added! \n\nNew Shipper Key: " + newShipper(newName, newPhone));
        }
        catch(Exception inputError){
            System.out.println("INPUT ERROR");
            inputError.printStackTrace();
        }
    }

    public static void displayAllMenu() {
        System.out.print("\nNow Displaying All Shippers...\n\n");
        allShippers();
    }

    public static void updateShipperMenu(){
        try {
            System.out.print("\nPlease enter the ID of the Shipper to update (Ex: '6').\n" +
                    "User Input: ");
            String idChoice = scan.nextLine();
            System.out.print("\nPlease enter the NUMBER of a Shipper to update (Ex: '(123) 456-7890').\n" +
                    "User Input: ");
            String updatedPhone = scan.nextLine();
            updateShipper(idChoice, updatedPhone);
            System.out.println("\nSuccessfully Updated! ");
        }
        catch(Exception inputError){
            System.out.println("INPUT ERROR");
            inputError.printStackTrace();
        }
    }

    public static void deleteShipperMenu(){
        try{
            System.out.print("\nPlease enter the ID of the Shipper to delete (Ex: '8').\n" +
                    "User Input: ");
            String idChoice = scan.nextLine();
            if(Integer.parseInt(idChoice) <= 3){
                System.out.println("Oops! Chosen ID must be above 3. Please try again!");
                deleteShipperMenu();
            }
            else{
                deleteShipper(Integer.parseInt(idChoice));
                System.out.println("\nSuccessfully Deleted! ");
            }
        }
        catch(Exception inputError){
            System.out.println("INPUT ERROR");
            inputError.printStackTrace();
        }
    }
}
