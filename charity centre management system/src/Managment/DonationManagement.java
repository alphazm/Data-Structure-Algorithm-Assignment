package Managment;

import ADT.ArrayList;
import ADT.CircularLinkedList;
import ADT.LinkedQueueInterface;
import ADT.LinkedStack;
import Entity.Donation;
import Entity.DonationDistribution;
import Entity.DonationManage;
import Entity.Event;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Heng Wei Long
 */
public class DonationManagement{

    static Scanner s = new Scanner(System.in);
    static CircularLinkedList cll = new CircularLinkedList();
    static Donation donation = new Donation();
    static DonationManage dm = new DonationManage();
    static LinkedStack ls = new LinkedStack();
    private static final ArrayList<DonationDistribution> donationDistributions 
            = DDSubsystem.getDDList();
    static LinkedQueueInterface<Event> eventQueue = EventManagementSystem.getEvent();
    
    public static CircularLinkedList getList() {
        return cll;
    }
    
    public static void DonationManagement(boolean menu) {
        if (menu) {
            donationMenu();
        }
        else {
            dataInput();
        }
        DDSubsystem.gettingDonations(cll);
    }

    public static void donationMenu() {
        clearJavaConsoleScreen();
        //default donor
        String donorId = "0";
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
                    case "0":
                        cont = false;
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

    public static void dataInput() {
        // Add 50 donations raw data
        insertDonation(10001, "1001", "2024-08-01 10:05", "", 
                new Donation("Supplies", "Drinks: Water", 20, 0.00));
        insertDonation(10002, "1001", "2024-08-01 14:10", "", 
                new Donation("Funds", "Online Bank Transfer", 1, 500.00));
        insertDonation(10003, "1001", "2024-08-02 12:15", "", 
                new Donation("Supplies", "Drinks: Water", 20, 0.00));
        insertDonation(10004, "1002", "2024-08-02 15:20", "", 
                new Donation("Supplies", "Food: Bread", 5, 0.00));
        insertDonation(10005, "1002", "2024-08-03 10:25", "", 
                new Donation("Funds", "Cash", 1, 300.00));
        insertDonation(10006, "1003", "2024-08-04 12:30", "", 
                new Donation("Funds", "Credit Card", 1, 1000.00));
        insertDonation(10007, "1003", "2024-08-04 15:35", "", 
                new Donation("Supplies", "Food: Maggie", 10, 0.00));
        insertDonation(10008, "1004", "2024-08-04 19:40", "", 
                new Donation("Funds", "Check", 1, 200.00));
        insertDonation(10009, "1004", "2024-08-05 11:45", "", 
                new Donation("Supplies", "Drinks: Water", 50, 0.00));
        insertDonation(10010, "1005", "2024-08-06 14:50", "", 
                new Donation("Funds", "Cash", 1, 150.00));
        insertDonation(10011, "1005", "2024-08-07 16:55", "", 
                new Donation("Supplies", "Food: Canned Goods", 30, 0.00));
        insertDonation(10012, "1006", "2024-08-07 11:00", "", 
                new Donation("Supplies", "Drinks: Juice", 10, 0.00));
        insertDonation(10013, "1006", "2024-08-08 14:05", "", 
                new Donation("Funds", "Bank Deposit", 1, 250.00));
        insertDonation(10014, "1007", "2024-08-09 13:10", "", 
                new Donation("Funds", "Online Payment", 1, 400.00));
        insertDonation(10015, "1007", "2024-08-10 11:15", "", 
                new Donation("Supplies", "Food: Rice", 100, 0.00));
        insertDonation(10016, "1008", "2024-08-11 17:20", "", 
                new Donation("Supplies", "Drinks: Soda", 15, 0.00));
        insertDonation(10017, "1008", "2024-08-12 15:25", "", 
                new Donation("Funds", "Cash", 1, 700.00));
        insertDonation(10018, "1009", "2024-08-13 16:30", "", 
                new Donation("Supplies", "Food: Fruits", 35, 0.00));
        insertDonation(10019, "1009", "2024-08-14 13:35", "", 
                new Donation("Funds", "Online Bank Transfer", 1, 350.00));
        insertDonation(10020, "1010", "2024-08-14 14:40", "", 
                new Donation("Funds", "Credit Card", 1, 600.00));
        insertDonation(10021, "0", "2024-08-15 12:45", "E001", 
                new Donation("Funds", "Credit Card", 1, 1000.00));
        insertDonation(10022, "0", "2024-08-16 10:50", "E002", 
                new Donation("Supplies", "Drinks: Juice", 30, 0.00));
        insertDonation(10023, "0", "2024-08-16 14:55", "E002", 
                new Donation("Funds", "Bank Deposit", 1, 6000.00));
        insertDonation(10024, "0", "2024-08-17 12:00", "E003", 
                new Donation("Supplies", "Food: Bread", 40, 0.00));
        insertDonation(10025, "0", "2024-08-18 12:05", "E004", 
                new Donation("Supplies", "Drinks: Water", 30, 0.00));
        insertDonation(10026, "0", "2024-08-19 12:10", "E005", 
                new Donation("Funds", "Check", 1, 2000.00));
        insertDonation(10027, "1009", "2024-08-20 12:15", "", 
                new Donation("Funds", "Online Bank Transfer", 1, 350.00));
        insertDonation(10028, "1012", "2024-08-20 15:20", "", 
                new Donation("Supplies", "Food: Cereal", 60, 0.00));
        insertDonation(10029, "1003", "2024-08-21 12:25", "", 
                new Donation("Supplies", "Drinks: Soda", 10, 0.00));
        insertDonation(10030, "1006", "2024-08-22 12:30", "", 
                new Donation("Supplies", "Food: Bread", 10, 0.00));
        insertDonation(10031, "1007", "2024-08-23 12:35", "", 
                new Donation("Funds", "Online Payment", 1, 400.00));
        insertDonation(10032, "1002", "2024-08-23 15:40", "", 
                new Donation("Funds", "Cash", 1, 300.00));
        insertDonation(10033, "1010", "2024-08-24 12:45", "", 
                new Donation("Supplies", "Food: Pasta", 40, 0.00));
        insertDonation(10034, "1008", "2024-08-24 16:50", "", 
                new Donation("Supplies", "Drinks: Water", 15, 0.00));
        insertDonation(10035, "1011", "2024-08-25 12:55", "", 
                new Donation("Funds", "Check", 1, 800.00));
        insertDonation(10036, "1015", "2024-08-25 17:00", "", 
                new Donation("Funds", "Credit Card", 1, 300.00));
        insertDonation(10037, "1020", "2024-08-25 13:05", "", 
                new Donation("Funds", "Online Payment", 1, 900.00));
        insertDonation(10038, "1018", "2024-08-25 18:10", "", 
                new Donation("Funds", "Online Bank Transfer", 1, 450.00));
        insertDonation(10039, "1005", "2024-08-26 10:15", "", 
                new Donation("Supplies", "Food: Canned Goods", 30, 0.00));
        insertDonation(10040, "1024", "2024-08-26 13:20", "", 
                new Donation("Funds", "Check", 1, 400.00));
        insertDonation(10041, "1019", "2024-08-27 10:25", "", 
                new Donation("Funds", "Check", 1, 550.00));
        insertDonation(10042, "1014", "2024-08-27 13:30", "", 
                new Donation("Supplies", "Drinks: Water", 15, 0.00));
        insertDonation(10043, "1021", "2024-08-28 16:35", "", 
                new Donation("Supplies", "Food: Beverages", 20, 0.00));
        insertDonation(10044, "1007", "2024-08-28 17:40", "", 
                new Donation("Supplies", "Food: Rice", 100, 0.00));
        insertDonation(10045, "1013", "2024-08-29 10:45", "", 
                new Donation("Funds", "Bank Deposit", 1, 450.00));
        insertDonation(10046, "1022", "2024-08-30 13:50", "", 
                new Donation("Funds", "Cash", 1, 200.00));
        insertDonation(10047, "1023", "2024-08-30 17:55", "", 
                new Donation("Supplies", "Drinks: Juice", 25, 0.00));
        insertDonation(10048, "1008", "2024-08-31 14:00", "", 
                new Donation("Funds", "Cash", 1, 700.00));
        insertDonation(10049, "1006", "2024-09-01 10:05", "", 
                new Donation("Supplies", "Drinks: Soda", 10, 0.00));
        insertDonation(10050, "1001", "2024-09-01 14:10", "", 
                new Donation("Supplies", "Drinks: Juice", 20, 0.00));
    }

    public static int getNewestDonationId() {
        // get last donation
        dm = (DonationManage) cll.getEntry(cll.getNumberOfEntries());
        // get donation details
        int x = dm.getDonationId();
        return x + 1;
    }

    public static void addDonation(String donorId) {
        int donationId = getNewestDonationId();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        donation = new Donation();
        String fromEvent = "";
        if (donorId.equals("0")) {
            System.out.print("Enter Donor Id(If from event enter 0): ");
            donorId = s.nextLine();
        }
        int inputInt = chooseCategory();
        switch (inputInt) {
            case 1:
                donation.setDonationCategory("Funds");
                donation.setItemDescription(enterFundsType());
                donation.setItemQuantity(1);
                System.out.print("Enter Amount: ");
                double amt = s.nextDouble();
                s.nextLine();
                donation.setAmount(amt);
                break;
            case 2:
                donation.setDonationCategory("Supplies");
                donation.setItemDescription(chooseSupplies());
                System.out.print("Enter Item Quantity: ");
                int qty = s.nextInt();
                s.nextLine();
                donation.setItemQuantity(qty);
                donation.setAmount(0);
                break;
            default:
                System.out.println("Add Donation Fail!");
                break;
        }
        if (inputInt != 0) {
            if (donorId.equals("0")) {
                System.out.println("Event ID");
                Iterator<Event> iterator = eventQueue.getIterator();
                while (iterator.hasNext()) {
                    Event event = iterator.next();
                    System.out.println(event.getEventId());
                }
                System.out.print("Enter Event Id: ");
                fromEvent = s.nextLine();
            }
            
            System.out.println("Donation Id\tDonor Id\tEvent\tDonation Category"
                    + "\tItem Description\tItem Quantity\t    Amount");
            System.out.format("%d\t\t%s\t\t%s\t", donationId, donorId, fromEvent);
            System.out.println(donation.toString());
            System.out.print("Enter 1 to confirm adding the donation, or 0 to cancel: ");
            int choice = s.nextInt();
            s.nextLine();
            if (choice == 1) {
                System.out.println("Successful Add!");
                insertDonation(donationId, donorId, formattedDateTime, fromEvent, donation);
            }
        }
    }

    public static String enterFundsType() {
        System.out.print("Enter ItemDescription: ");
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
    
    public static void insertDonation(int donationId, String donorId, 
            String dateTime, String fromEvent, Donation donation){
        dm = new DonationManage(donationId, donorId, dateTime, fromEvent, donation);
        cll.add(dm);
    }

    public static void removeDonation(int inputDonationId){
        System.out.print(" Enter the 1 to confirm: ");
        int inputInt = s.nextInt();
        s.nextLine();
        
        if (inputInt == 1) {
            if (cll.remove(getPositionInList(inputDonationId, cll)) != null) {
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

    public static int getPositionInList(int donationId, CircularLinkedList inList) {
        int numElementList = inList.getNumberOfEntries() + 1;
        int countList = 1;
        do {
            // get one by one donation data from list
            DonationManage temp = (DonationManage) inList.getEntry(countList);
            if (temp.getDonationId() == donationId) {
                return countList;
            }
            countList += 1;
        } while (countList != numElementList);
        return 0;
    }
    
    public static void searchDonation() {
        System.out.print(" Enter the id: ");
        int inputDonationId = s.nextInt(); // accept input and store to inputDonationId
        s.nextLine(); // clear enter key

        DonationManage searchResult = searchById(inputDonationId, cll);
        if (searchResult != null) {
            System.out.println("Donation Id\tDonor Id\tDonation Date Time\t\tEvent\t"
                    + "\tDonation Category\tItem Description\tItem Quantity\t    Amount");
            System.out.println(searchResult.toString());
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
    
    public static DonationManage searchById(int donationId, CircularLinkedList inList) {
        DonationManage result = new DonationManage();
        int numElementList = inList.getNumberOfEntries() + 1;
        int countList = 1;
        do {
            // get one by one donation data from list
            DonationManage temp = (DonationManage) inList.getEntry(countList);
            if (temp.getDonationId() == donationId) {
                result = temp;
            }
            countList += 1;
        } while (countList != numElementList);
        return result;
    }
  
    // search by donor id
    public static void searchByDonorId(CircularLinkedList inList,String donorId){
        CircularLinkedList temp = new CircularLinkedList();
        CircularLinkedList copy = new CircularLinkedList();
        copyList(copy, inList);

        int numElementList = copy.getNumberOfEntries() + 1; //50
        int countList = 1;
        do {
            DonationManage aDonation = (DonationManage) copy.getEntry(countList);
            if (donorId.equals(aDonation.getDonation())) {
                temp.add(aDonation);
            }
            countList += 1;
        } while (countList != numElementList);
        displayAll(temp);
    }
   
    public static void amendDonation(int inputDonationId){
        DonationManage searchResult = searchById(inputDonationId, cll);
        updateDonation(searchResult);
    }

    public static void updateDonation(DonationManage searchResult) {
        // make old same with new
        DonationManage newResult = searchResult;
        donation = new Donation();

        int inputInt = chooseUpdate();
        do {
            switch (inputInt) {
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
    public static DonationManage replaceMenu(String entryType, DonationManage aDonation) {
        System.out.println("Donation Id\tDonor Id\tDonation Date Time\t\tEvent"
                + "\t\tDonation Category\tItem Description\tItem Quantity\t    Amount");
        System.out.println(aDonation.toString());
        donation = aDonation.getDonation();
        String inputStr;
        switch (entryType) {
            case "donorId":
                System.out.println(" Enter new donor id: ");
                String inputId = s.nextLine();
                aDonation.setDonorId(inputId);
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
        System.out.println("Donation Id\tDonor Id\tDonation Date Time\t\tEvent"
                + "\t\tDonation Category\tItem Description\tItem Quantity\t    Amount");
        System.out.println(aDonation.toString());
        return aDonation;
    }

    public static int chooseUpdate() {
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

    public static void trackDonation() {
        System.out.println(" Track Donation Menu");
        System.out.print("Enter donation id: ");
        int inputInt = s.nextInt();
        s.nextLine();
        int index = -1;
        for (int i = 0; i < donationDistributions.size(); i++) {
            ArrayList<Integer> DonationIDs = donationDistributions.get(i).getDonationid();
            for (int j = 0; j < DonationIDs.size(); j++) {
                if (inputInt == DonationIDs.get(j)) {
                    index = i;
                    break;
                }
            }
        }
        // found id
        if (index != -1) {
            DonationDistribution distribution = donationDistributions.get(index);
            System.out.println("Donation Distribution Details:");
            System.out.println("Distribution ID: " + distribution.getdDistributionid());
            System.out.println("Donee ID: " + distribution.getDoneeid());
            System.out.println("Donation IDs: " + distribution.getDonationIdString());
            System.out.println("State: " + distribution.getState());
        } else {
            System.out.println("Track Donation with ID " + inputInt + " not found.");
        }
    }

    public static void listDonationByDifferentDonor() {
        CircularLinkedList result = arrangedAccordingDonorId(cll);
        int numElementList = result.getNumberOfEntries() + 1;
        int countList = 1;
        DonationManage first = (DonationManage) result.getEntry(countList);
        String previousId = first.getDonorId();
        // print first time
        if (previousId.equals("0")) {
            System.out.println("From Event");
        }
        else {
            System.out.println("From Donor Id: " + previousId);
        }
        System.out.println("\tDonation Id\tDonation Date Time\t\tEvent\t\tDonation Category"
                + "\tItem Description\tItem Quantity\t    Amount");
        do {
            // get one by one donation data from list
            DonationManage temp = (DonationManage) result.getEntry(countList);
            if (!previousId.equals(temp.getDonorId())) {
            System.out.println("\nFrom Donor Id: " + temp.getDonorId());
                System.out.println("\tDonation Id\tDonation Date Time\t\tEvent\t"
                        + "\tDonation Category\tItem Description\tItem Quantity\t    Amount");
                previousId = temp.getDonorId();
            }
            System.out.print("\t" + temp.getDonationId() + "\t\t");
            System.out.print(temp.getDateTime() + "\t\t");
            System.out.print(temp.getFromEvent() + "\t\t");
            donation = temp.getDonation();
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
        copy = sortedListByDonorId(copy);
        // loop one by one, until the size of temp same with inList
        do {
            int numElementList = copy.getNumberOfEntries() + 1; //50
            int countList = 1;
            // Always get the first donation of the list
            DonationManage first = (DonationManage) copy.getEntry(1);
            String getDonorId = first.getDonorId();
            // catch the data from List to donation
            do {
                DonationManage aDonation = (DonationManage) copy.getEntry(countList);
                if (getDonorId.equals(aDonation.getDonorId())) {
                    temp.add(aDonation);
                    copy.remove(countList);
                    countList -= 1;
                    numElementList -= 1;
                }
                countList += 1;
            } while (countList != numElementList);
        } while (temp.getNumberOfEntries() != inList.getNumberOfEntries());
        return temp;
    }
    
    // sorted the list by donor id
    public static CircularLinkedList sortedListByDonorId(CircularLinkedList inList) {
        CircularLinkedList temp = new CircularLinkedList();
        int numElementList = inList.getNumberOfEntries() + 1;
        int countList = 1;
        
        // copy the id to a list
        do {
            DonationManage aDonation = (DonationManage) inList.getEntry(countList);
            int getDonorId = Integer.parseInt(aDonation.getDonorId());
            temp.add(getDonorId); // store id only
            countList += 1;
        } while (countList != numElementList);
        
        // sort into a new list according id
        CircularLinkedList sortedList = new CircularLinkedList();
        do {
            int i = 1; // assume the first id is the smallest
            int minDonorId = (int) temp.getEntry(i);
            // Find the min donorId in the current list
            for (int j = 2; j <= temp.getNumberOfEntries(); j++) {
                int currentDonorId = (int) temp.getEntry(j);
                if (currentDonorId < minDonorId) {
                    minDonorId = currentDonorId;
                    i = j;
                }
            }
            sortedList.add(minDonorId);
            temp.remove(i);
        }while (!temp.isEmpty());
        
        do {
            int firstDonorId = (int) sortedList.getEntry(1);
            numElementList = inList.getNumberOfEntries() + 1;
            countList = 1;
            do {
                DonationManage aDonation = (DonationManage) inList.getEntry(countList);
                int getDonorId = Integer.parseInt(aDonation.getDonorId());
                if (firstDonorId == getDonorId) {
                    temp.add(aDonation);
                    sortedList.remove(1);
                    inList.remove(countList);
                    numElementList -= 1;
                    countList -= 1;
                }
                countList += 1;
            } while (countList != numElementList);
        }while(!sortedList.isEmpty());
        return temp;
    }
    
    public static void copyList(CircularLinkedList copy, CircularLinkedList inList) {
        int numElementList = inList.getNumberOfEntries() + 1; //51
        int countList = 1;
        do {
            DonationManage temp = (DonationManage) inList.getEntry(countList);
            copy.add(temp);
            countList += 1;
        } while (countList != numElementList);
    }

    public static void listAllDonation(){
        displayAll(cll);
        CircularLinkedList copy = new CircularLinkedList();
        copyList(copy, cll);
        int inputInt;
        do {
            if (ls.isEmpty()) {
                System.out.print(" Add Filter? (0 = cancel, 1 = add): ");
                inputInt = s.nextInt();
                s.nextLine();
                if (inputInt == 1) {
                    ls.push(copy);
                    copy = filterMenu(copy);
                    displayAll(copy);
                } 
            }
            else {
                System.out.print(" Add Filter? (0 = cancel, 1 = add, 2 = undo): ");
                inputInt = s.nextInt();
                s.nextLine();
                if (inputInt == 1) {
                    ls.push(copy);
                    copy = filterMenu(copy);
                    displayAll(copy);
                } 
                else if (inputInt == 2) {
                    copy = (CircularLinkedList) ls.pop();
                    displayAll(copy);
                }
            }
        } while (inputInt != 0);
        while (!ls.isEmpty()) {
            ls.pop();
        }
    }

    // display all in circular linked list
    public static void displayAll(CircularLinkedList inList) {
        if (inList.isEmpty()) {
            System.out.println("Empty!");
        }
        System.out.println("Donation Id\tDonor Id\tDonation Date Time\t\tEvent\t"
                + "\tDonation Category\tItem Description\tItem Quantity\t    Amount");
        int numElementList = inList.getNumberOfEntries() + 1;
        int countList = 1;
        do {
            // get one by one donation data from list
            DonationManage temp = (DonationManage) inList.getEntry(countList);
            System.out.println(temp.toString());
            countList += 1;
        } while (countList != numElementList);
    }

    public static CircularLinkedList filterMenu(CircularLinkedList inList) {
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
        switch (inputInt) {
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
        switch (inputInt) {
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

        inList = searchByNumber("Quantity", min, max, inList);
        return inList;
    }

    public static CircularLinkedList filterAmount(CircularLinkedList inList) {
        System.out.print(" Enter minimum amount: ");
        double min = s.nextDouble();
        s.nextLine();
        System.out.print(" Enter maximum amount: ");
        double max = s.nextDouble();
        s.nextLine();

        inList = searchByNumber("Amount", min, max, inList);
        return inList;
    }

    // filter on string
    public static CircularLinkedList searchByString(String anEntry, 
            CircularLinkedList inList) {
        CircularLinkedList result = new CircularLinkedList();
        int numElement = inList.getNumberOfEntries() + 1;
        int count = 1;
        do {
            // get one by one donation data from list
            DonationManage temp = (DonationManage) inList.getEntry(count);
            donation = temp.getDonation();
            if (donation.getDonationCategory().contains(anEntry)) {
                result.add(temp);
            } else if (donation.getItemDescription().contains(anEntry)) {
                result.add(temp);
            }
            count += 1;
        } while (count != numElement);
        return result;
    }

    // filter on number
    public static CircularLinkedList searchByNumber(String entryType, double min, 
            double max, CircularLinkedList inList) {
        CircularLinkedList result = new CircularLinkedList();
        int numElement = inList.getNumberOfEntries() + 1;
        int count = 1;
        do {
            // get one by one donation data from list
            DonationManage temp = (DonationManage) inList.getEntry(count);
            donation = temp.getDonation();
            if (entryType.equals("Quantity")) {
                if (min <= donation.getItemQuantity()&& donation.getItemQuantity() <= max) {
                    result.add(temp);
                }
            } else if (entryType.equals("Amount")) {
                if (min <= donation.getAmount() && donation.getAmount() <= max) {
                    result.add(temp);
                }
            }
            count += 1;
        } while (count != numElement);
        return result;
    }

    public static void generateDonationManagementReport() {
        double totalAmount = 0;
        int totalItems = 0;
        int count = 1;
        int numElement = cll.getNumberOfEntries() + 1;
        do {
            // get one by one donation data from list
            DonationManage temp = (DonationManage) cll.getEntry(count);
            donation = temp.getDonation();
            totalAmount += donation.getAmount();
            totalItems += donation.getItemQuantity();
            count += 1;
        } while (count != numElement);
        System.out.println(" Donation Management Report");
        System.out.println(" Total Donations: " + cll.getNumberOfEntries());
        System.out.println(" Total Item Quantity: " + totalItems);
        System.out.println(" Total Amount: $" + totalAmount);
    }

    private static void clearJavaConsoleScreen() {
        try {
            Robot rob = new Robot();
            try {
                rob.keyPress(KeyEvent.VK_CONTROL); // press "CTRL"
                rob.keyPress(KeyEvent.VK_L); // press "L"
                rob.keyRelease(KeyEvent.VK_L); // unpress "L"
                rob.keyRelease(KeyEvent.VK_CONTROL); // unpress "CTRL"
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}

