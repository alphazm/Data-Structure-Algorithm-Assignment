/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Managment;

import ADT.CircularLinkedList;
import Entity.Donation;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author Heng Wei Long
 */
public class DonationManagement {
    static Scanner s = new Scanner(System.in);
    
    // trying make circular linked list storing circular linked list
    static CircularLinkedList cll = new CircularLinkedList();
    static Donation donation = new Donation();
    
    public static void main(String[] args) {
        dataInput();
        donationMenu();
    }
    
    public static void donationMenu(){
        //clearJavaConsoleScreen();
        //from donor
        int donorId = 0;
        int choice;
        boolean cont = true;
        do{
        do{
            System.out.println("Donation Management Main Menu");
            System.out.println(" 1. Add Donation");
            System.out.println(" 2. Remove Donation");
            System.out.println(" 3. Search Donation");
            System.out.println(" 4. Amend Donation");
            System.out.println(" 5. Track Donation");
            System.out.println(" 6. List Donor By Donation");
            System.out.println(" 7. List All Donation");
            System.out.println(" 8. Generate Donation Management Report");
            System.out.println(" 0. Exit");
            System.out.print(" Enter Your Choice: ");
            try{
                choice = s.nextInt();
                s.nextLine();
                switch (choice) {
                    case 1:     // addDonation
                        clearJavaConsoleScreen();
                        addDonation(donorId);
                        cont = true;
                        break;
                    case 2:     // removeDonation
                        clearJavaConsoleScreen();
                        removeDonation();
                        cont = true;
                        break;
                    case 3:     // searchDonation
                        clearJavaConsoleScreen();
                        searchDonation();
                        cont = true;
                        break;
                    case 4:     // amendDonation
                        clearJavaConsoleScreen();
                        amendDonation();
                        cont = true;
                        break;
                    case 5:     // trackDonation
                        clearJavaConsoleScreen();
                        trackDonation();
                        cont = true;
                        break;
                    case 6:     // listDonorByDonationId
                        clearJavaConsoleScreen();
                        listDonorByDonationId();
                        cont = true;
                        break;
                    case 7:     // listAllDonation
                        clearJavaConsoleScreen();
                        listAllDonation();
                        cont = true;
                        break;
                    case 8:     // generateDonationManagementReport
                        clearJavaConsoleScreen();
                        generateDonationManagementReport();
                        cont = true;
                        break;
                    case 0:     // exit
                        exit();
                        break;
                    case 10:
                        break;
                    default:
                        System.out.println("(Main1)Invalid!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("(Main2)Invalid!");
                choice = 10;
                cont = false;
                break;
            }
        }while (cont);
        }while (choice != 0);
    }
    
    public static void dataInput(){
        // Add 20 donations
        insertDonation(240801, 1001, new Donation("Funds", "Cash", 1, 100.00));
        insertDonation(240802, 1001, new Donation("Supplies", "Food: Bread", 10, 0.00));
        insertDonation(240803, 1002, new Donation("Funds", "Online Bank In", 1, 1000.00));
        insertDonation(240804, 1003, new Donation("Supplies", "Food: Maggie", 50, 0.00));
        insertDonation(240805, 1004, new Donation("Funds", "Card Payment", 1, 500.00));
        insertDonation(240806, 1004, new Donation("Supplies", "Drinks: Water", 100, 0.00));
        insertDonation(240807, 1005, new Donation("Funds", "Cash", 1, 150.00));
        insertDonation(240808, 1005, new Donation("Supplies", "Food: Rice", 20, 0.00));
        insertDonation(240809, 1006, new Donation("Funds", "Online Bank In", 1, 2000.00));
        insertDonation(240810, 1007, new Donation("Supplies", "Food: Beans", 30, 0.00));
        insertDonation(240811, 1008, new Donation("Funds", "Cash", 1, 50.00));
        insertDonation(240812, 1008, new Donation("Supplies", "Drinks: Juice", 25, 0.00));
        insertDonation(240813, 1009, new Donation("Funds", "Card Payment", 1, 250.00));
        insertDonation(240814, 1009, new Donation("Supplies", "Food: Pasta", 15, 0.00));
        insertDonation(240815, 1010, new Donation("Funds", "Online Bank In", 1, 1200.00));
        insertDonation(240816, 1011, new Donation("Supplies", "Food: Flour", 40, 0.00));
        insertDonation(240817, 1012, new Donation("Funds", "Cash", 1, 300.00));
        insertDonation(240818, 1012, new Donation("Supplies", "Drinks: Soda", 60, 0.00));
        insertDonation(240819, 1013, new Donation("Funds", "Card Payment", 1, 700.00));
        insertDonation(240820, 1014, new Donation("Supplies", "Food: Biscuits", 35, 0.00));
    }
    
    public static int getNewtestDonationId() {
        return 0;
    }
    
    public static void addDonation(int donorId){
        int donationId = getNewtestDonationId();
        Donation donation = new Donation();
        int x = chooseCategory();
        switch(x) {
            case 1:
                donation.setDonationCategory("Funds");
                donation.setItemDescription(enterFundsType());
                break;
            case 2:
                donation.setDonationCategory("Supplies");
                donation.setItemDescription(chooseSupplies());
                break;
            default:
                System.out.println("Add Donation Fail!");
                break;
        }
        if (x != 0) {
            System.out.println("Enter Item Quantity: ");
            int qty = s.nextInt();
            s.nextLine();
            donation.setItemQuantity(qty);

            System.out.println("Enter Amount: ");
            double amt = s.nextDouble();
            s.nextLine();
            donation.setAmount(amt);

            System.out.println("Donation Id\tDonor Id\tDonation Category\tItem Description\tItem Quantity\t    Amount");
            System.out.format("%d\t\t%d\t\t", donationId, donorId);
            System.out.println(donation.toString());
            System.out.println("Please enter 1 to confirm adding the donation, or 0 to cancel: ");
            int choice = s.nextInt();
            s.nextLine();
            if (choice == 1) {
                insertDonation(donationId, donorId, donation);
            }
        }
    }
    
    public static String enterFundsType() {
        System.out.println("Enter ItemDescription: ");
        String a = s.nextLine();
        return a;
    }
    
    public static String chooseSupplies() {
        String a;
        System.out.println("Supplies");
        System.out.println("1. Food");
        System.out.println("2. Drinks");
        System.out.println("3. Other");
        System.out.print("Choose supplies type: ");
        int x = s.nextInt();
        s.nextLine();
        
        switch(x) {
            case 1:
                System.out.println("Supplies: Food");
                System.out.print("Enter description: ");
                a = s.nextLine();
                return "Food:" + a;
            case 2:
                System.out.println("Supplies: Drinks");
                System.out.print("Enter description: ");
                a = s.nextLine();
                return "Drinks: " + a;
            case 3:
                System.out.println("Supplies: Other");
                System.out.print("Enter description: ");
                a = s.nextLine();
                return "Other: " + a;
        }
        return "";
    }
    
    public static int chooseCategory() {
        System.out.println("Category");
        System.out.println("1. Funds");
        System.out.println("2. Supplies");
        System.out.print("Choose donation category: ");
        int x = s.nextInt();
        s.nextLine();
        
        switch(x) {
            case 1:
                return 1;
            case 2:
                return 2;
        }
        return 0;
    }
    
    public static void insertDonation(int donationId, int donorId, Donation donation){
        // int donationID, int donorId, String donationCategory, String itemDescription, int itemQuantity, double amount
        CircularLinkedList clldata = new CircularLinkedList();
        clldata.add(donationId); // int donation id: year month id
        clldata.add(donorId); // int donator id: from donor
        clldata.add(donation);
        
        cll.add(clldata);
    }
    
    public static void insertDonation1(int donationId, int donorId, String donationCategory, String itemDescription, int itemQuantity, double amount){
        // int donationID, int donorId, String donationCategory, String itemDescription, int itemQuantity, double amount
        CircularLinkedList clldata = new CircularLinkedList();
        clldata.add(donationId); // int donation id: year month id
        clldata.add(donorId); // int donator id: from donor
        clldata.add(donationCategory); // string donationCategory: Funds, Supplies
        clldata.add(itemDescription); // string itemDescription: cash, online bank in, card; food, drinks
        clldata.add(itemQuantity); // int itemQuantity
        clldata.add(amount); // double amount
        
        cll.add(clldata);
    }
    
    public static void removeDonation(){
        System.out.print(" Enter the id: ");
        int inputDonationId = s.nextInt(); // accept input and store to inputDonationId
        s.nextLine(); // clear enter key
        
        if (cll.remove(inputDonationId)) {
            System.out.println("Successful Remove!");
        }
        else {
            System.out.println("Fail To Remove!");
        }
    }
    
    public static void searchDonation(){
        System.out.print(" Enter the id: ");
        int inputDonationId = s.nextInt(); // accept input and store to inputDonationId
        s.nextLine(); // clear enter key
        
        CircularLinkedList searchResult = (CircularLinkedList) cll.search("donationId",inputDonationId);
        if (searchResult != null) {
            searchResult.display();
        }
    }
    
    public static void amendDonation(){
        System.out.print(" Enter the id: ");
        int inputDonationId = s.nextInt(); // accept input and store to inputDonationId
        s.nextLine(); // clear enter key
        
        CircularLinkedList searchResult = (CircularLinkedList) cll.search("donationId",inputDonationId);
        if (!searchResult.isEmpty()) {
            CircularLinkedList newResult = updateDonation(searchResult);
            if (newResult != null) {
                cll.replace(searchResult, newResult);   
            }
        }
    }
    
    public static CircularLinkedList updateDonation(CircularLinkedList searchResult){
        CircularLinkedList newResult = new CircularLinkedList();
        // make old same with new
        newResult = searchResult;
        Donation donation = new Donation();
        
        int x = chooseUpdate();
        do {
            switch(x) {
                case 1:
                    System.out.println("Enter new Donor Id");
                    int a = s.nextInt();
                    s.nextLine();
                    newResult.replace("donorId", a);
                    break;
                case 2:
                    System.out.println("Enter new Category");
                    String b = s.nextLine();
                    newResult.replace("itemCate", b);
                    break;
                case 3:
                    System.out.println("Enter new Item Description");
                    String c = s.nextLine();
                    newResult.replace("itemDes", c);
                    break;
                case 4:
                    System.out.println("Enter new Item Quantity");
                    int d = s.nextInt();
                    s.nextLine();
                    newResult.replace("itemQty", d);
                    break;
                case 5:
                    System.out.println("Enter new Amount");
                    double e = s.nextInt();
                    s.nextLine();
                    newResult.replace("amount", e);
                    break;
                default:
                    System.out.println("Amend Donation Fail!");
                    return null;
            }
            x = chooseUpdate();
        } while (x != 0);
        return newResult;
    }
    
    public static int chooseUpdate(){
        System.out.println(" Amend which data");
        System.out.println(" 1. Donor Id");
        System.out.println(" 2. Category");
        System.out.println(" 3. Item Description");
        System.out.println(" 4. Item Quantity");
        System.out.println(" 5. Amount");
        System.out.println(" 0. Exit");
        System.out.print("Choose donation category: ");
        int x = s.nextInt();
        s.nextLine();
        switch(x) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
        }
        return 0;
    }
    
    public static void trackDonation(){
        int choice;
        CircularLinkedList searchResult;
        do{
            System.out.println(" Track Donation Menu");
            System.out.println(" 1. Funds");
            System.out.println(" 2. Supplies");
            System.out.println(" 0. Back");
            System.out.print(" Enter Your Choice: ");
            try{
                choice = s.nextInt();
                s.nextLine();
                switch (choice) {
                    case 1:
                        searchResult = (CircularLinkedList) cll.search("category","Funds");
                        searchResult.displayAll();
                        break;
                    case 2:
                        searchResult = (CircularLinkedList) cll.search("category","Supplies");
                        searchResult.displayAll();
                        break;
            }
            }catch (Exception e) {
                System.out.println("(Track)Invalid!");
                break;
            }
        }while(choice != 0);
    }
    
    public static void listDonorByDonationId(){
        System.out.println("Donation Id\tDonor Id\tDonation Category\tItem Description\tItem Quantity\t    Amount");
    }
    
    public static void listAllDonation(){
        System.out.println("Donation Id\tDonor Id\tDonation Category\tItem Description\tItem Quantity\t    Amount");
        cll.displayAll();
    }
    
    public static void filterDonation(){
        
    }
    
    public static void generateDonationManagementReport(){
        cll.generateDonationManagementReport();
    }

    private static void clearJavaConsoleScreen() {
        try{
            Robot rob = new Robot();
            try {
            rob.keyPress(KeyEvent.VK_CONTROL); // press "CTRL"
            rob.keyPress(KeyEvent.VK_L); // press "L"
            rob.keyRelease(KeyEvent.VK_L); // unpress "L"
            rob.keyRelease(KeyEvent.VK_CONTROL); // unpress "CTRL"
            Thread.sleep(1000); // add delay in milisecond, if not there will automatically stop after clear
            } catch (InterruptedException e) { e.printStackTrace(); }
        } catch(AWTException e) { e.printStackTrace(); }
    }
    
    public static void exit(){
        System.exit(0);
    }
}
