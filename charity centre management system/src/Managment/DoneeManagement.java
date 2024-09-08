package Managment;

/**
 *
 * @author ChanWinYit
 */
import Entity.Donee;
import Entity.DonationDistribution;
import Managment.DDSubsystem;
import ADT.ArrayList;
import ADT.LinearLinkedList;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

interface IDoneeManagement {
    void addDonee(String doneeName, String phoneNo, String address);
    void removeDonee(String doneeID);
    void updateDonee(String doneeID, String doneeName, 
            String phoneNo, String address);
    Donee searchDonee(String doneeID);
    void listAllDonees();
    void doneeReport();
}
public class DoneeManagement implements IDoneeManagement{
    private LinearLinkedList<Donee> doneeList;
    public DoneeManagement() {
        doneeList = new LinearLinkedList<>();
    }
       
    public static void DoneeMenu() {
        DoneeManagement doneeManagement = new DoneeManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nDonee Management System");
            System.out.println("1. Add Donee");
            System.out.println("2. Update Donee");
            System.out.println("3. Remove Donee");
            System.out.println("4. Search Donee");
            System.out.println("5. List All Donees");
            System.out.println("6. Donee Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    clearJavaConsoleScreen();
                    System.out.println("\nAdding a new Donee:");
                    System.out.print("Enter Donee Name: ");
                    String doneeName = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNo = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    doneeManagement.addDonee(doneeName, phoneNo, address);
                    break;
                    
                case 2:
                    clearJavaConsoleScreen();
                    System.out.println("\nUpdating a Donee:");
                    System.out.print("Enter Donee ID: ");
                    String updateDoneeID = scanner.nextLine();
                    System.out.print("Enter new Donee Name: ");
                    String newDoneeName = scanner.nextLine();
                    System.out.print("Enter new Phone Number: ");
                    String newPhoneNo = scanner.nextLine();
                    System.out.print("Enter new Address: ");
                    String newAddress = scanner.nextLine();
                    doneeManagement.updateDonee(updateDoneeID, 
                            newDoneeName, newPhoneNo, newAddress);
                    break;

                case 3:
                    clearJavaConsoleScreen();
                    System.out.println("\nRemoving a Donee:");
                    System.out.print("Enter Donee ID: ");
                    String removeDoneeID = scanner.nextLine();
                    doneeManagement.removeDonee(removeDoneeID);
                    break;

                case 4:
                    clearJavaConsoleScreen();
                    System.out.println("\nSearching a Donee:");
                    System.out.print("Enter Donee ID: ");
                    String searchDoneeID = scanner.nextLine();
                    Donee foundDonee = doneeManagement.searchDonee(searchDoneeID);
                    if (foundDonee != null) {
                        System.out.println("Donee found: " + foundDonee);
                    }
                    break;

                case 5:
                    clearJavaConsoleScreen();
                    System.out.println("\nList of all Donees:");
                    doneeManagement.listAllDonees();
                    break;
                
                case 6:
                    clearJavaConsoleScreen();
                    System.out.println("Donee Report");
                    doneeManagement.doneeReport();
                    break;

                case 0:
                    clearJavaConsoleScreen();
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice! "
                            + "Please enter a valid option.");
            }
        } while (choice != 0);
    }

  public void addDonee(String doneeName, String phoneNo, String address) {
    Donee newDonee = new Donee(doneeName, phoneNo, address);

    for (int i = 0; i < doneeList.size(); i++) {
        Donee donee = doneeList.get(i);
        if (donee.getDoneeName().equals(doneeName) && 
                donee.getPhoneNo().equals(phoneNo) && 
                donee.getAddress().equals(address)) {
            System.out.println("The donee " + doneeName + " with the donee ID: "
                    + donee.getDoneeID() + " is in the list already.");
            return; // Exit the method without adding the donee
        }
    }
    doneeList.add(newDonee);
    System.out.println("Donee " + doneeName + " is added.");
    System.out.println("Donee id =" + newDonee.getDoneeID());
}


    public void removeDonee(String doneeID) {
    if (doneeList.isEmpty()) {
        System.out.println("No removable action needed");
        return;
    }
    
    boolean found = false;

    // Loop through the list to find the donee with the matching ID
    for (int i = 1; i <= doneeList.getNumberOfEntries(); ++i) {
        Donee donee = doneeList.getEntry(i);
        if (donee.getDoneeID().equalsIgnoreCase(doneeID)) {
            doneeList.remove(i); // Correctly pass the index to remove method
            System.out.println("Donee " + doneeID + " has been removed");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Invalid ID: " + doneeID);
    }
}



    public void updateDonee(String doneeID, String doneeName, 
            String phoneNo, String address) {
        if (doneeList.isEmpty()) {
            System.out.println("The Donee list is empty");
            return;
        }
        boolean found = false;

        for (int i = 1; i <= doneeList.getNumberOfEntries(); ++i) {
            Donee donee = doneeList.getEntry(i);
            if (donee.getDoneeID().equalsIgnoreCase(doneeID)) {
                donee.setDoneeName(doneeName);
                donee.setPhoneNo(phoneNo);
                donee.setAddress(address);
                doneeList.replace(i, donee);
                System.out.println("Updated donee: " + donee);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid ID:" + doneeID);
        }
    }

    public Donee searchDonee(String doneeID) {
        if (doneeList.isEmpty()) {
            System.out.println("The Donee list is empty");
            return null;
        }

        for (int i = 1; i <= doneeList.getNumberOfEntries(); ++i) {
            Donee donee = doneeList.getEntry(i);
            if (donee.getDoneeID().equalsIgnoreCase(doneeID)) {
                System.out.println(donee);
                return donee;
            }
        }

        System.out.println("Invalid ID:" + doneeID);
        return null;
    }

    public void listAllDonees() {
        if (doneeList.isEmpty()) {
            System.out.println("The Donee list is empty");
            return;
        }

        System.out.println("Listing all donees:");
        for (int i = 1; i <= doneeList.getNumberOfEntries(); ++i) {
            Donee donee = doneeList.getEntry(i);
            System.out.println(donee);
        }
    }
    
    public void doneeReport() {
    for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
        Donee donee = doneeList.getEntry(i);
        System.out.println(donee.toString2());
       
    }
}

    private static void clearJavaConsoleScreen() {
        try{
            Robot rob = new Robot();
            try {
            rob.keyPress(KeyEvent.VK_CONTROL); // press "CTRL"
            rob.keyPress(KeyEvent.VK_L); // press "L"
            rob.keyRelease(KeyEvent.VK_L); // unpress "L"
            rob.keyRelease(KeyEvent.VK_CONTROL); // unpress "CTRL"
            Thread.sleep(1000); // add delay in milisecond, 
            //if not there will automatically stop after clear
            } catch (InterruptedException e) { e.printStackTrace(); }
        } catch(AWTException e) { e.printStackTrace(); }
    }
}
