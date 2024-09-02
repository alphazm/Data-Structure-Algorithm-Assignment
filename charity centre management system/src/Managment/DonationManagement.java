/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Managment;

import ADT.CircularLinkedList;
import Entity.Donation;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    
    public static void main(String[] args){
        dataInput();
        donationMenu();
    }
    
    public static void DonationManagement() {
        dataInput();
        donationMenu();
    }
    
    public static void donationMenu(){
        clearJavaConsoleScreen();
        //from donor
        int donorId = 0;
        String choice;
        boolean cont = true;
        do{
        do{
            System.out.println("Donation Management Main Menu");
            System.out.println(" 1. Add Donation");
            System.out.println(" 2. Search Donation");
            System.out.println(" 3. Track Donation");
            System.out.println(" 4. List Donation By Different Donor");
            System.out.println(" 5. List All Donation");
            System.out.println(" 6. Generate Donation Management Report");
            System.out.println(" 0. Exit");
            System.out.print(" Enter Your Choice: ");
            try{
                choice = s.nextLine();
                switch (choice) {
                    case "1":     // addDonation
                        clearJavaConsoleScreen();
                        addDonation(donorId); // pass donor Id here
                        cont = true;
                        break;
                    case "2":     // searchDonation
                        clearJavaConsoleScreen();
                        searchDonation();
                        cont = true;
                        break;
                    case "3":     // trackDonation
                        clearJavaConsoleScreen();
                        trackDonation();
                        cont = true;
                        break;
                    case "4":     // listDonorByDonationId
                        clearJavaConsoleScreen();
                        listDonationByDifferentDonor();
                        cont = true;
                        break;
                    case "5":     // listAllDonation
                        clearJavaConsoleScreen();
                        listAllDonation();
                        cont = true;
                        break;
                    case "6":     // generateDonationManagementReport
                        clearJavaConsoleScreen();
                        generateDonationManagementReport();
                        cont = true;
                        break;
                    case "0":     // exit
                        exit();
                        break;
                    default:
                        System.out.println("Invalid!");
                        cont = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid!");
                choice = "0";
                cont = false;
                break;
            }
        }while (cont);
        }while (!"0".equals(choice));
    }
    
    public static void dataInput(){
        // Add 50 donations
        insertDonation(10001, 1001, "2024-08-01 10:05:19", new Donation("Supplies", "Drinks: Water", 20, 0.00));
        insertDonation(10002, 1001, "2024-08-01 14:10:19", new Donation("Funds", "Online Bank Transfer", 1, 500.00));
        insertDonation(10003, 1001, "2024-08-02 12:15:19", new Donation("Supplies", "Drinks: Water", 20, 0.00));
        insertDonation(10004, 1002, "2024-08-02 15:20:19", new Donation("Supplies", "Food: Bread", 5, 0.00));
        insertDonation(10005, 1002, "2024-08-03 10:25:19", new Donation("Funds", "Cash", 1, 300.00));
        insertDonation(10006, 1003, "2024-08-04 12:30:19", new Donation("Funds", "Credit Card", 1, 1000.00));
        insertDonation(10007, 1003, "2024-08-04 15:35:19", new Donation("Supplies", "Food: Maggie", 10, 0.00));
        insertDonation(10008, 1004, "2024-08-04 19:40:19", new Donation("Funds", "Check", 1, 200.00));
        insertDonation(10009, 1004, "2024-08-05 11:45:19", new Donation("Supplies", "Drinks: Water", 50, 0.00));
        insertDonation(10010, 1005, "2024-08-06 14:50:19", new Donation("Funds", "Cash", 1, 150.00));
        insertDonation(10011, 1005, "2024-08-07 16:55:19", new Donation("Supplies", "Food: Canned Goods", 30, 0.00));
        insertDonation(10012, 1006, "2024-08-07 11:00:19", new Donation("Supplies", "Drinks: Juice", 10, 0.00));
        insertDonation(10013, 1006, "2024-08-08 14:05:19", new Donation("Funds", "Bank Deposit", 1, 250.00));
        insertDonation(10014, 1007, "2024-08-09 13:10:19", new Donation("Funds", "Online Payment", 1, 400.00));
        insertDonation(10015, 1007, "2024-08-10 11:15:19", new Donation("Supplies", "Food: Rice", 100, 0.00));
        insertDonation(10016, 1008, "2024-08-11 17:20:19", new Donation("Supplies", "Drinks: Soda", 15, 0.00));
        insertDonation(10017, 1008, "2024-08-12 15:25:19", new Donation("Funds", "Cash", 1, 700.00));
        insertDonation(10018, 1009, "2024-08-13 16:30:19", new Donation("Supplies", "Food: Fruits", 35, 0.00));
        insertDonation(10019, 1009, "2024-08-14 13:35:19", new Donation("Funds", "Online Bank Transfer", 1, 350.00));
        insertDonation(10020, 1010, "2024-08-14 14:40:19", new Donation("Funds", "Credit Card", 1, 600.00));
        insertDonation(10021, 1021, "2024-08-15 12:45:19", new Donation("Funds", "Credit Card", 1, 750.00));
        insertDonation(10022, 1022, "2024-08-16 10:50:19", new Donation("Supplies", "Drinks: Juice", 15, 0.00));
        insertDonation(10023, 1023, "2024-08-16 14:55:19", new Donation("Funds", "Bank Deposit", 1, 650.00));
        insertDonation(10024, 1024, "2024-08-17 12:00:19", new Donation("Supplies", "Food: Snacks", 40, 0.00));
        insertDonation(10025, 1025, "2024-08-18 12:05:19", new Donation("Supplies", "Drinks: Water", 30, 0.00));
        insertDonation(10026, 1004, "2024-08-19 12:10:19", new Donation("Funds", "Check", 1, 200.00));
        insertDonation(10027, 1009, "2024-08-20 12:15:19", new Donation("Funds", "Online Bank Transfer", 1, 350.00));
        insertDonation(10028, 1012, "2024-08-20 15:20:19", new Donation("Supplies", "Food: Cereal", 60, 0.00));
        insertDonation(10029, 1003, "2024-08-21 12:25:19", new Donation("Supplies", "Drinks: Soda", 10, 0.00));
        insertDonation(10030, 1006, "2024-08-22 12:30:19", new Donation("Supplies", "Food: Bread", 10, 0.00));
        insertDonation(10031, 1007, "2024-08-23 12:35:19", new Donation("Funds", "Online Payment", 1, 400.00));
        insertDonation(10032, 1002, "2024-08-23 15:40:19", new Donation("Funds", "Cash", 1, 300.00));
        insertDonation(10033, 1010, "2024-08-24 12:45:19", new Donation("Supplies", "Food: Pasta", 40, 0.00));
        insertDonation(10034, 1008, "2024-08-24 16:50:19", new Donation("Supplies", "Drinks: Water", 15, 0.00));
        insertDonation(10035, 1011, "2024-08-25 12:55:19", new Donation("Funds", "Check", 1, 800.00));
        insertDonation(10036, 1015, "2024-08-25 17:00:19", new Donation("Funds", "Credit Card", 1, 300.00));
        insertDonation(10037, 1020, "2024-08-25 13:05:19", new Donation("Funds", "Online Payment", 1, 900.00));
        insertDonation(10038, 1018, "2024-08-25 18:10:19", new Donation("Funds", "Online Bank Transfer", 1, 450.00));
        insertDonation(10039, 1005, "2024-08-26 10:15:19", new Donation("Supplies", "Food: Canned Goods", 30, 0.00));
        insertDonation(10040, 1024, "2024-08-26 13:20:19", new Donation("Funds", "Check", 1, 400.00));
        insertDonation(10041, 1019, "2024-08-27 10:25:19", new Donation("Funds", "Check", 1, 550.00));
        insertDonation(10042, 1014, "2024-08-27 13:30:19", new Donation("Supplies", "Drinks: Water", 15, 0.00));
        insertDonation(10043, 1021, "2024-08-28 16:35:19", new Donation("Supplies", "Food: Beverages", 20, 0.00));
        insertDonation(10044, 1007, "2024-08-28 17:40:19", new Donation("Supplies", "Food: Rice", 100, 0.00));
        insertDonation(10045, 1013, "2024-08-29 10:45:19", new Donation("Funds", "Bank Deposit", 1, 450.00));
        insertDonation(10046, 1022, "2024-08-30 13:50:19", new Donation("Funds", "Cash", 1, 200.00));
        insertDonation(10047, 1023, "2024-08-30 17:55:19", new Donation("Supplies", "Drinks: Juice", 25, 0.00));
        insertDonation(10048, 1008, "2024-08-31 14:00:19", new Donation("Funds", "Cash", 1, 700.00));
        insertDonation(10049, 1006, "2024-09-01 10:05:19", new Donation("Supplies", "Drinks: Soda", 10, 0.00));
        insertDonation(10050, 1001, "2024-09-01 14:10:19", new Donation("Supplies", "Drinks: Juice", 20, 0.00));
    }
    
    public static int getNewestDonationId() {
        // get last donation
        CircularLinkedList temp = (CircularLinkedList) cll.getEntry(cll.getNumberOfEntries());
        // get donation details
        int x = (Integer) temp.getEntry(1);
        return x+1;
    }
    
    public static void addDonation(int donorId){
        int donationId = getNewestDonationId();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        donation = new Donation();
        int inputInt = chooseCategory();
        switch(inputInt) {
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
        if (inputInt != 0) {
            System.out.print("Enter Item Quantity: ");
            int qty = s.nextInt();
            s.nextLine();
            donation.setItemQuantity(qty);

            System.out.print("Enter Amount: ");
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
                insertDonation(donationId, donorId, formattedDateTime, donation);
            }
        }
    }
    
    public static String enterFundsType() {
        System.out.println("Enter ItemDescription: ");
        String inputStr = s.nextLine();
        return inputStr;
    }
    
    public static String chooseSupplies() {
        String inputStr;
        System.out.println("Supplies");
        System.out.println("1. Food");
        System.out.println("2. Drinks");
        System.out.print("Choose supplies type: ");
        int inputInt = s.nextInt();
        s.nextLine();
        switch(inputInt) {
            case 1:
                System.out.println("Supplies: Food");
                System.out.print("Enter description: ");
                inputStr = s.nextLine();
                return "Food:" + inputStr;
            case 2:
                System.out.println("Supplies: Drinks");
                System.out.print("Enter description: ");
                inputStr = s.nextLine();
                return "Drinks: " + inputStr;
        }
        return "";
    }
    
    public static int chooseCategory() {
        System.out.println("Category");
        System.out.println("1. Funds");
        System.out.println("2. Supplies");
        System.out.print("Choose donation category: ");
        int inputInt = s.nextInt();
        s.nextLine();
        return inputInt;
    }
    
    public static void insertDonation(int donationId, int donorId, String dateTime,Donation donation){
        // int donationID, int donorId, String donationCategory, String itemDescription, int itemQuantity, double amount
        CircularLinkedList clldata = new CircularLinkedList();
        clldata.add(donationId); // int donation id: year month id
        clldata.add(donorId); // int donator id: from donor
        clldata.add(dateTime);
        clldata.add(donation);
        
        cll.add(clldata);
    }
    
    public static void removeDonation(int inputDonationId){
        System.out.print(" Enter the 1 to confirm: ");
        int inputInt = s.nextInt();
        s.nextLine();
        
        if (inputInt == 1) {
            if (cll.remove(inputDonationId) != null) {
                System.out.println("Successful Remove!");
            }
            else {
                System.out.println("Fail To Remove!");
            }
        }
        else {
            System.out.println("Cancel");
        }
    }
    
    public static void searchDonation(){
        System.out.print(" Enter the id: ");
        int inputDonationId = s.nextInt(); // accept input and store to inputDonationId
        s.nextLine(); // clear enter key
        
        CircularLinkedList searchResult = searchById(inputDonationId, cll);
        if (searchResult != null) {
            display(searchResult);
        }
        System.out.print("Did u want to amend this donation? (1 to amend, 2 to remove): ");
        int inputInt = s.nextInt();
        s.nextLine();
        if (inputInt == 1) {
            amendDonation(inputDonationId);
        }
        else if (inputInt == 2) {
            removeDonation(inputDonationId);
        }
    }
    
    // search by donationId
    public static CircularLinkedList searchById(int anEntry, CircularLinkedList inList){
        if (inList.isEmpty()) {
            System.out.println("The List Is Empty!");
            return null;
        }
        CircularLinkedList result = new CircularLinkedList();
        int numElementList = inList.getNumberOfEntries() + 1;
        int countList = 1;
        do {
            CircularLinkedList temp = (CircularLinkedList) inList.getEntry(countList);
            int numElement = temp.getNumberOfEntries() + 1;
            int count = 1;
            do {
                // get donation id of donation
                int i = (Integer) temp.getEntry(1);
                if (i == anEntry) {
                    return temp;
                }
                count += 1;
            } while (count != numElement);
            countList += 1;
        } while (countList != numElementList); 
        return result;
    }
    
    // search by category
    public static CircularLinkedList searchByCate(String anEntry, CircularLinkedList inList){
        if (inList.isEmpty()) {
            System.out.println("The List Is Empty!");
            return null;
        }
        CircularLinkedList result = new CircularLinkedList();
        int numElementList = inList.getNumberOfEntries() + 1;
        int countList = 1;
        do {
                CircularLinkedList temp = (CircularLinkedList) inList.getEntry(countList);
                // get donation's category from donation, every lastNode is donation, lastNode.next is donationId
                donation = (Donation) temp.getEntry(temp.getNumberOfEntries());
                if (donation.getDonationCategory().contains(anEntry)) {
                    result.add(temp);
                }
            countList += 1;
        } while (countList != numElementList);
        
        return result;
    }
    
    public static void amendDonation(int inputDonationId){
        CircularLinkedList searchResult = searchById(inputDonationId, cll);
        if (!searchResult.isEmpty()) {
            updateDonation(searchResult);
        }
    }
    
    public static void updateDonation(CircularLinkedList searchResult){
        // make old same with new
        CircularLinkedList newResult = searchResult;
        donation = new Donation();
        int inputInt = chooseUpdate();
        do {
            switch(inputInt) {
                case 1:
                    newResult = replaceMenu("donorId", newResult);
                    break;
                case 2:
                    newResult = replaceMenu("itemCate", newResult);
                    break;
                case 3:
                    newResult = replaceMenu("itemDes", newResult);
                    break;
                case 4:
                    newResult = replaceMenu("itemQty", newResult);
                    break;
                case 5:
                    newResult = replaceMenu("amount", newResult);
                    break;
                default:
                    System.out.println("Amend Donation Fail!");
            }
            inputInt = chooseUpdate();
        } while (inputInt != 0);
    }
    
    // replace a donation data
    public static CircularLinkedList replaceMenu(String entryType, CircularLinkedList inList) {
        if (inList.isEmpty()) {
            System.out.println("The List Is Empty!");
        }
        display(inList);
        donation = (Donation) inList.getEntry(inList.getNumberOfEntries());
        String inputStr;
        switch(entryType){
            case "donorId":
                System.out.println(" Enter new donor id: ");
                int inputId = s.nextInt();
                s.nextLine();
                inList.replace(2, inputId);
                break;
            case "itemCate":
                System.out.print(" Enter new category: ");
                inputStr = s.nextLine();
                donation.setDonationCategory(inputStr);
                break;
            case "itemDes":
                System.out.print(" Enter new description: ");
                inputStr = s.nextLine();
                donation.setItemDescription(inputStr);
                break;
            case "itemQty":
                System.out.print(" Enter new quantity: ");
                int inputInt = s.nextInt();
                s.nextLine();
                donation.setItemQuantity(inputInt);
                break;
            case "amount":
                System.out.print(" Enter new amount: ");
                double inputDouble = s.nextDouble();
                s.nextLine();
                donation.setAmount(inputDouble);
                break;
        }
        display(inList);
        return inList;
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
        int inputInt = s.nextInt();
        s.nextLine();
        return inputInt;
    }
    
    public static void trackDonation(){
        int inputInt;
        CircularLinkedList searchResult;
        do{
            System.out.println(" Track Donation Menu");
            System.out.println(" 1. Funds");
            System.out.println(" 2. Supplies");
            System.out.println(" 0. Back");
            System.out.print(" Enter Your Choice: ");
            inputInt = s.nextInt();
            s.nextLine();
            switch (inputInt) {
                case 1:
                    searchResult = searchByCate("Funds", cll);
                    System.out.println("Donation Id\tDonor Id\tDonation Date Time\t\tDonation Category\tItem Description\tItem Quantity\t    Amount");
                    displayAll(searchResult);
                    break;
                case 2:
                    searchResult = searchByCate("Supplies", cll);
                    System.out.println("Donation Id\tDonor Id\tDonation Date Time\t\tDonation Category\tItem Description\tItem Quantity\t    Amount");
                    displayAll(searchResult);
                    break;
            }
        }while(inputInt != 0);
    }
    
    public static void listDonationByDifferentDonor(){
        //System.out.println("Donor Id\tDonation Id\tDonation Category\tItem Description\tItem Quantity\t    Amount");
        CircularLinkedList result = arrangedAccordingDonorId(cll);
        int numElementList = result.getNumberOfEntries() + 1;
        int countList = 1;
        CircularLinkedList first = (CircularLinkedList) result.getEntry(1);
        int previousId = (Integer) first.getEntry(2);
        // print first time
        System.out.println(previousId);
        System.out.println("\tDonation Id\tDonation Date Time\t\tDonation Category\tItem Description\tItem Quantity\t    Amount");
        do {
            // get one by one donation data from list
            CircularLinkedList temp = (CircularLinkedList) result.getEntry(countList);
            if ((Integer) temp.getEntry(2) != previousId) {
                System.out.println("\n" + (Integer) temp.getEntry(2));
                System.out.println("\tDonation Id\tDonation Date Time\t\tDonation Category\tItem Description\tItem Quantity\t    Amount");
                previousId = (Integer) temp.getEntry(2);
            }
            int donationId = (Integer) temp.getEntry(1);
            System.out.print("\t" + donationId + "\t\t");
            System.out.print(temp.getEntry(3) + "\t\t");
            donation = (Donation) temp.getEntry(temp.getNumberOfEntries());
            System.out.println(donation.toString());
                
            countList += 1;
        } while (countList != numElementList);
        System.out.println("\n\n");
    }
    
    // arrange the list from according donationId to according donorId
    public static CircularLinkedList arrangedAccordingDonorId(CircularLinkedList inList) {
        CircularLinkedList temp = new CircularLinkedList();
        CircularLinkedList copy = new CircularLinkedList();
        copyList(copy, inList);
        // loop one by one, until the size of temp same with inList
        do {
            int numElementList = copy.getNumberOfEntries() + 1; //50
            int countList = 1;
            // Always get the first donation of the list
            CircularLinkedList first = (CircularLinkedList) copy.getEntry(1); // 240801
            int getDonorId = (Integer) first.getEntry(2); // 1001
            // catch the data from List to donation
            do {
                CircularLinkedList aDonation = (CircularLinkedList) copy.getEntry(countList);
                if (getDonorId == (Integer) aDonation.getEntry(2)) {
                    temp.add(aDonation);
                    copy.remove(aDonation.getEntry(1));
                    // the data is been remove, so need to - 1
                    countList -= 1;
                    numElementList -= 1;
                }
                countList += 1;
            } while (countList != numElementList);
            // set back to 0, to loop next round
            countList = 0;
        } while (temp.getNumberOfEntries() != inList.getNumberOfEntries());
        return temp;
    }
    
    public static void copyList(CircularLinkedList copy, CircularLinkedList inList) {
        int numElementList = inList.getNumberOfEntries() + 1; //51
        int countList = 1;
        do {
            CircularLinkedList temp = (CircularLinkedList) inList.getEntry(countList);
            copy.add(temp);
            countList += 1;
        } while (countList != numElementList);
    }
    
    public static void listAllDonation(){
        System.out.println("Donation Id\tDonor Id\tDonation Date Time\t\tDonation Category\tItem Description\tItem Quantity\t    Amount");
        displayAll(cll);
        CircularLinkedList copy = new CircularLinkedList();
        copyList(copy, cll);
        int inputInt;
        do {
            System.out.print(" Add Filter? (0 = cancel): ");
            inputInt = s.nextInt();
            s.nextLine();
            if (inputInt != 0) {
                copy = filterMenu(copy);
                displayAll(copy);
            }
        } while (inputInt != 0);
    }
    
    // display all in circular linked list
    public static void displayAll(CircularLinkedList inList){
        if (inList.isEmpty()) {
            System.out.println("Empty!");
        }
        int numElementList = inList.getNumberOfEntries() + 1;
        int countList = 1;
        do {
            // get one by one donation data from list
            CircularLinkedList temp = (CircularLinkedList) inList.getEntry(countList);
            int numElement = temp.getNumberOfEntries() + 1;
            int count = 1;
            do {
                if (temp.getEntry(count).getClass() == Donation.class) {
                    donation = (Donation) temp.getEntry(count);
                    System.out.println(donation.toString());
                }
                else {
                    System.out.print(temp.getEntry(count) + "\t\t");
                }
                count += 1;
            } while (count != numElement);
            countList += 1;
        } while (countList != numElementList);
    }
    
    public static void display(CircularLinkedList inList) {
        int numElement = inList.getNumberOfEntries() + 1;
        int count = 1;
        do {
            if (inList.getEntry(count).getClass() == Donation.class) {
                Donation d = (Donation) inList.getEntry(count);
                System.out.println(d.toString());
            }
            else {
                System.out.print(inList.getEntry(count) + "\t\t");
            }    
            count += 1;
        } while (count != numElement);
    }
    
    public static CircularLinkedList filterMenu(CircularLinkedList inList){
        System.out.println(" Filter menu");
        System.out.println(" 1. Filter Category");
        System.out.println(" 2. Filter Description");
        System.out.println(" 3. Filter Quantity");
        System.out.println(" 4. Filter Amount");
        System.out.print(" Enter your choice: ");
        int inputInt = s.nextInt();
        s.nextLine();
        switch (inputInt) {
            case 1:
                inList = filterCategory(inList);
                break;
            case 2:
                inList = filterDescription(inList);
                break;
            case 3:
                inList = filterQuantity(inList);
                break;
            case 4:
                inList = filterAmount(inList);
                break;
        }
        return inList;
    }
    
    public static CircularLinkedList filterCategory(CircularLinkedList inList) {
        System.out.println(" 1. Funds");
        System.out.println(" 2. Supplies");
        System.out.print(" Choose donation category: ");
        int inputInt = s.nextInt();
        s.nextLine();
        switch(inputInt) {
            case 1:
                inList = searchByString("Fund", inList);
                break;
            case 2:
                inList = searchByString("Supplie", inList);
                break;
        }
        return inList;
    }
    
    public static CircularLinkedList filterDescription(CircularLinkedList inList) {
        System.out.println(" 1. Cash");
        System.out.println(" 2. Card");
        System.out.println(" 3. Check");
        System.out.println(" 4. Online");
        System.out.println(" 5. Food");
        System.out.println(" 6. Drinks");
        System.out.print("Choose donation Type: ");
        int inputInt = s.nextInt();
        s.nextLine();
        switch(inputInt) {
            case 1:
                inList = searchByString("Cash", inList);
                break;
            case 2:
                inList = searchByString("Card", inList);
                break;
            case 3:
                inList = searchByString("Check", inList);
                break;
            case 4:
                inList = searchByString("Online", inList);
                break;
            case 5:
                inList = searchByString("Food", inList);
                break;
            case 6:
                inList = searchByString("Drinks", inList);
                break;
        }
        return inList;
    }
    
    public static CircularLinkedList filterQuantity(CircularLinkedList inList) {
        System.out.print(" Enter min quantity: ");
        double min = s.nextDouble();
        s.nextLine();
        System.out.print(" Enter max quantity: ");
        double max = s.nextDouble();
        s.nextLine();
        
        inList = filterNumber("Quantity", min, max, inList);
        return inList;
    }
    
    public static CircularLinkedList filterAmount(CircularLinkedList inList) {
        System.out.print(" Enter minimum amount: ");
        double min = s.nextDouble();
        s.nextLine();
        System.out.print(" Enter maximum amount: ");
        double max = s.nextDouble();
        s.nextLine();
        
        inList = filterNumber("Amount", min, max, inList);
        return inList;
    }
    
    // filter on string
    public static CircularLinkedList searchByString(String anEntry, CircularLinkedList inList) {
        CircularLinkedList result = new CircularLinkedList();
        int numElement = inList.getNumberOfEntries() + 1;
        int count = 1;
        
        do {
            // get one by one donation data from list
            CircularLinkedList temp = (CircularLinkedList) inList.getEntry(count);
            // get lastNode in a donation
            donation = (Donation) temp.getEntry(temp.getNumberOfEntries());
            
            if (donation.getDonationCategory().contains(anEntry)) {
                result.add(temp);
            }
            else if (donation.getItemDescription().contains(anEntry)) {
                result.add(temp);
            }
            
            count += 1;
        } while (count != numElement);
        return result;
    }
    
    // filter on number
    public static CircularLinkedList filterNumber(String entryType, double min, double max, CircularLinkedList inList) {
        CircularLinkedList result = new CircularLinkedList();
        int numElement = inList.getNumberOfEntries() + 1;
        int count = 1;
        do {
            // get one by one donation data from list
            CircularLinkedList temp = (CircularLinkedList) inList.getEntry(count);
            // get lastNode in a donation
            donation = (Donation) temp.getEntry(temp.getNumberOfEntries());
            
            if (entryType.equals("Quantity")) {
                if (min <= donation.getAmount() && donation.getAmount() <= max) {
                    result.add(temp);
                }
            }
            else if (entryType.equals("Amount")) {
                if (min <= donation.getAmount() && donation.getAmount() <= max) {
                    result.add(temp);
                }
            }
            count += 1;
        } while (count != numElement);
        return result;
    }
    
    public static void generateDonationManagementReport(){
        double totalAmount = 0;
        int totalItems = 0;
        int count = 1;
        int numElement = cll.getNumberOfEntries() + 1;
        do {
            // get one by one donation data from list
            CircularLinkedList temp = (CircularLinkedList) cll.getEntry(count);
            // get lastNode in a donation
            donation = (Donation) temp.getEntry(temp.getNumberOfEntries());
            totalAmount += donation.getAmount();
            totalItems += donation.getItemQuantity();
            count += 1;
        } while (count != numElement);

        System.out.println(" Total Donations: " + cll.getNumberOfEntries());
        System.out.println(" Total Item Quantity: " + totalItems);
        System.out.println(" Total Amount: $" + totalAmount);
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
