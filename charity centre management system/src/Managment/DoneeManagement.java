package Managment;

/**
 *
 * @author ChanWinYit
 */
import Entity.Donee;
import Entity.Requirement;
import ADT.LinearLinkedList;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class DoneeManagement {
    private LinearLinkedList<Donee> doneeList;
    
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
                    doneeManagement.updateDonee(updateDoneeID, newDoneeName, newPhoneNo, newAddress);
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

                case 0:
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 0);
    }

    public DoneeManagement() {
        doneeList = new LinearLinkedList<>();
    }

    public void addDonee(String doneeName, String phoneNo, String address) {
        // "" means the place where doneeID generate
        Donee newDonee = new Donee(doneeName,phoneNo, address); 
        doneeList.add(newDonee);
    }
    public void addRequirementToDonee(String doneeID, Requirement requirement) {
        Donee donee = searchDonee(doneeID);
        if (donee != null) {
            donee.addRequirement(requirement);
            System.out.println("Requirement added to donee: " + doneeID);
        } else {
            System.out.println("Donee with ID " + doneeID + " not found.");
        }
    }

    public void removeDonee(String doneeID) {
        if (doneeList.isEmpty()) {
            System.out.println("No removable action needed");
            return;
        }
        boolean found = false;

        for (int i = 1; i <= doneeList.getNumberOfEntries(); ++i) {
            Donee donee = doneeList.getEntry(i);
            if (donee.getDoneeID().equalsIgnoreCase(doneeID)) {
                doneeList.remove(donee);
                System.out.println(donee + "has been removed");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid ID:" + doneeID);
        }
    }

    public void updateDonee(String doneeID, String doneeName, String phoneNo, String address) {
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
}
