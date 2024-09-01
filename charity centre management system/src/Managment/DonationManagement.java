/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Managment;

import ADT.CircularLinkedList;
import Entity.Donation;
import static Managment.DDSubsystem.DonationDistributionMainPage;
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

    public static void DonationManagement() {
        dataInput();
        donationMenu();
        DDSubsystem ddSubsystem = new DDSubsystem();
        ddSubsystem.gettingDonations(cll);
    }

    public static void donationMenu() {
        clearJavaConsoleScreen();
        //from donor
        int donorId = 0;
        int choice;
        boolean cont = true;
        do {
            do {
                System.out.println("Donation Management Main Menu");
                System.out.println(" 1. Add Donation");
                System.out.println(" 2. Remove Donation");
                System.out.println(" 3. Search Donation");
                System.out.println(" 4. Amend Donation");
                System.out.println(" 5. Track Donation");
                System.out.println(" 6. List Donation By Different Donor");
                System.out.println(" 7. List All Donation");
                System.out.println(" 8. Generate Donation Management Report");
                System.out.println(" 0. Exit");
                System.out.print(" Enter Your Choice: ");
                try {
                    choice = s.nextInt();
                    s.nextLine();
                    switch (choice) {
                        case 1:     // addDonation
                            clearJavaConsoleScreen();
                            addDonation(donorId); // pass donor Id here
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
                            listDonationByDifferentDonor();
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
            } while (cont);
        } while (choice != 0);
    }

    public static void dataInput() {
        // Add 50 donations
        insertDonation(240801, 1001, new Donation("Supplies", "Drinks: Water", 20, 0.00));
        insertDonation(240802, 1001, new Donation("Funds", "Online Bank Transfer", 1, 500.00));
        insertDonation(240803, 1001, new Donation("Supplies", "Drinks: Water", 20, 0.00));
        insertDonation(240804, 1002, new Donation("Supplies", "Food: Bread", 5, 0.00));
        insertDonation(240805, 1002, new Donation("Funds", "Cash", 1, 300.00));
        insertDonation(240806, 1003, new Donation("Funds", "Credit Card", 1, 1000.00));
        insertDonation(240807, 1003, new Donation("Supplies", "Food: Maggie", 10, 0.00));
        insertDonation(240808, 1004, new Donation("Funds", "Check", 1, 200.00));
        insertDonation(240809, 1004, new Donation("Supplies", "Drinks: Water", 50, 0.00));
        insertDonation(240810, 1005, new Donation("Funds", "Cash", 1, 150.00));
        insertDonation(240811, 1005, new Donation("Supplies", "Food: Canned Goods", 30, 0.00));
        insertDonation(240812, 1006, new Donation("Supplies", "Drinks: Juice", 10, 0.00));
        insertDonation(240813, 1006, new Donation("Funds", "Bank Deposit", 1, 250.00));
        insertDonation(240814, 1007, new Donation("Funds", "Online Payment", 1, 400.00));
        insertDonation(240815, 1007, new Donation("Supplies", "Food: Rice", 100, 0.00));
        insertDonation(240816, 1008, new Donation("Supplies", "Drinks: Soda", 15, 0.00));
        insertDonation(240817, 1008, new Donation("Funds", "Cash", 1, 700.00));
        insertDonation(240818, 1009, new Donation("Supplies", "Food: Fruits", 35, 0.00));
        insertDonation(240819, 1009, new Donation("Funds", "Online Bank Transfer", 1, 350.00));
        insertDonation(240820, 1010, new Donation("Funds", "Credit Card", 1, 600.00));
        insertDonation(240821, 1021, new Donation("Funds", "Credit Card", 1, 750.00));
        insertDonation(240822, 1022, new Donation("Supplies", "Drinks: Juice", 15, 0.00));
        insertDonation(240823, 1023, new Donation("Funds", "Bank Deposit", 1, 650.00));
        insertDonation(240824, 1024, new Donation("Supplies", "Food: Snacks", 40, 0.00));
        insertDonation(240825, 1025, new Donation("Supplies", "Drinks: Water", 30, 0.00));
        insertDonation(240826, 1004, new Donation("Funds", "Check", 1, 200.00));
        insertDonation(240827, 1009, new Donation("Funds", "Online Bank Transfer", 1, 350.00));
        insertDonation(240828, 1012, new Donation("Supplies", "Food: Cereal", 60, 0.00));
        insertDonation(240829, 1003, new Donation("Supplies", "Drinks: Soda", 10, 0.00));
        insertDonation(240830, 1006, new Donation("Supplies", "Food: Bread", 10, 0.00));
        insertDonation(240831, 1007, new Donation("Funds", "Online Payment", 1, 400.00));
        insertDonation(240832, 1002, new Donation("Funds", "Cash", 1, 300.00));
        insertDonation(240833, 1010, new Donation("Supplies", "Food: Pasta", 40, 0.00));
        insertDonation(240834, 1008, new Donation("Supplies", "Drinks: Water", 15, 0.00));
        insertDonation(240835, 1011, new Donation("Funds", "Check", 1, 800.00));
        insertDonation(240836, 1015, new Donation("Funds", "Credit Card", 1, 300.00));
        insertDonation(240837, 1020, new Donation("Funds", "Online Payment", 1, 900.00));
        insertDonation(240838, 1018, new Donation("Funds", "Online Bank Transfer", 1, 450.00));
        insertDonation(240839, 1005, new Donation("Supplies", "Food: Canned Goods", 30, 0.00));
        insertDonation(240840, 1024, new Donation("Funds", "Check", 1, 400.00));
        insertDonation(240841, 1019, new Donation("Funds", "Check", 1, 550.00));
        insertDonation(240842, 1014, new Donation("Supplies", "Drinks: Water", 15, 0.00));
        insertDonation(240843, 1021, new Donation("Supplies", "Food: Beverages", 20, 0.00));
        insertDonation(240844, 1007, new Donation("Supplies", "Food: Rice", 100, 0.00));
        insertDonation(240845, 1013, new Donation("Funds", "Bank Deposit", 1, 450.00));
        insertDonation(240846, 1022, new Donation("Funds", "Cash", 1, 200.00));
        insertDonation(240847, 1023, new Donation("Supplies", "Drinks: Juice", 25, 0.00));
        insertDonation(240848, 1008, new Donation("Funds", "Cash", 1, 700.00));
        insertDonation(240849, 1006, new Donation("Supplies", "Drinks: Soda", 10, 0.00));
        insertDonation(240850, 1001, new Donation("Supplies", "Drinks: Juice", 20, 0.00));
    }

    public static int getNewestDonationId() {
        // get last donation
        CircularLinkedList temp = (CircularLinkedList) cll.getEntry(cll.getNumberOfEntries());
        // get donation details
        int x = (Integer) temp.getEntry(1);
        return x + 1;
    }

    public static void addDonation(int donorId) {
        int donationId = getNewestDonationId();
        donation = new Donation();
        int inputInt = chooseCategory();
        switch (inputInt) {
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
                insertDonation(donationId, donorId, donation);
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

        switch (inputInt) {
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

        switch (inputInt) {
            case 1:
                return 1;
            case 2:
                return 2;
        }
        return 0;
    }

    public static void insertDonation(int donationId, int donorId, Donation donation) {
        // int donationID, int donorId, String donationCategory, String itemDescription, int itemQuantity, double amount
        CircularLinkedList clldata = new CircularLinkedList();
        clldata.add(donationId); // int donation id: year month id
        clldata.add(donorId); // int donator id: from donor
        clldata.add(donation);

        cll.add(clldata);
    }

    public static void removeDonation() {
        System.out.print(" Enter the id: ");
        int inputDonationId = s.nextInt(); // accept input and store to inputDonationId
        s.nextLine(); // clear enter key

        if (cll.remove(inputDonationId) != null) {
            System.out.println("Successful Remove!");
        } else {
            System.out.println("Fail To Remove!");
        }
    }

    public static void searchDonation() {
        System.out.print(" Enter the id: ");
        int inputDonationId = s.nextInt(); // accept input and store to inputDonationId
        s.nextLine(); // clear enter key

        CircularLinkedList searchResult = searchById("donationId", inputDonationId, cll);
        if (searchResult != null) {
            display(searchResult);
        }
    }

    // search by donationId
    public static CircularLinkedList searchById(String entryType, int anEntry, CircularLinkedList inList) {
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

        if (((String) entryType).equals("category")) {
            return result;
        }
        return result;
    }

    // search by category
    public static CircularLinkedList searchByCate(String entryType, String anEntry, CircularLinkedList inList) {
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

        if (((String) entryType).equals("category")) {
            return result;
        }
        return result;
    }

    public static void amendDonation() {
        System.out.print(" Enter the id: ");
        int inputDonationId = s.nextInt(); // accept input and store to inputDonationId
        s.nextLine(); // clear enter key

        CircularLinkedList searchResult = searchById("donationId", inputDonationId, cll);
        if (!searchResult.isEmpty()) {
            updateDonation(searchResult);
        }
    }

    public static void updateDonation(CircularLinkedList searchResult) {
        // make old same with new
        CircularLinkedList newResult = searchResult;
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
    public static CircularLinkedList replaceMenu(String entryType, CircularLinkedList inList) {
        if (inList.isEmpty()) {
            System.out.println("The List Is Empty!");
        }
        display(inList);
        donation = (Donation) inList.getEntry(inList.getNumberOfEntries());
        String inputStr;
        switch (entryType) {
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
        switch (inputInt) {
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

    public static void trackDonation() {
        int inputInt;
        CircularLinkedList searchResult;
        do {
            System.out.println(" Track Donation Menu");
            System.out.println(" 1. Funds");
            System.out.println(" 2. Supplies");
            System.out.println(" 0. Back");
            System.out.print(" Enter Your Choice: ");
            try {
                inputInt = s.nextInt();
                s.nextLine();
                switch (inputInt) {
                    case 1:
                        searchResult = searchByCate("category", "Funds", cll);
                        displayAll(searchResult);
                        break;
                    case 2:
                        searchResult = searchByCate("category", "Supplies", cll);
                        displayAll(searchResult);
                        break;
                }
            } catch (Exception e) {
                System.out.println("(Track)Invalid!");
                break;
            }
        } while (inputInt != 0);
    }

    public static void listDonationByDifferentDonor() {
        //System.out.println("Donor Id\tDonation Id\tDonation Category\tItem Description\tItem Quantity\t    Amount");
        CircularLinkedList result = arrangedAccordingDonorId(cll);

        int numElementList = result.getNumberOfEntries() + 1;
        int countList = 1;
        int previousId = (Integer) ((CircularLinkedList) result.getEntry(countList)).getEntry(2);
        // print first time
        System.out.println(previousId);
        do {
            // get one by one donation data from list
            CircularLinkedList temp = (CircularLinkedList) result.getEntry(countList);
            if ((Integer) temp.getEntry(2) != previousId) {
                System.out.println("\n" + (Integer) temp.getEntry(2));
                previousId = (Integer) temp.getEntry(2);
            }
            int donationId = (Integer) temp.getEntry(1);
            System.out.print("\t" + donationId + "\t\t");

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

    public static void listAllDonation() {
        System.out.println("Donation Id\tDonor Id\tDonation Category\tItem Description\tItem Quantity\t    Amount");
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
    public static void displayAll(CircularLinkedList inList) {
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
                } else {
                    int id = (Integer) temp.getEntry(count);
                    System.out.print(id + "\t\t");
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
            } else {
                int id = (Integer) inList.getEntry(count);
                System.out.print(id + "\t\t");
            }
            count += 1;
        } while (count != numElement);
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
            } else if (donation.getItemDescription().contains(anEntry)) {
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
        try {
            Robot rob = new Robot();
            try {
                rob.keyPress(KeyEvent.VK_CONTROL); // press "CTRL"
                rob.keyPress(KeyEvent.VK_L); // press "L"
                rob.keyRelease(KeyEvent.VK_L); // unpress "L"
                rob.keyRelease(KeyEvent.VK_CONTROL); // unpress "CTRL"
                Thread.sleep(1000); // add delay in milisecond, if not there will automatically stop after clear
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void exit() {
        System.exit(0);
    }

}
