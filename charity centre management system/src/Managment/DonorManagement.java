package Managment;
/**
 *
 * @author Chong Zhi Ming
 */
import Entity.Donor;
import Entity.Category;
import ADT.LinkedStack;
import static Managment.DonationManagement.cll;

import static Managment.DonationManagement.searchByDonorId;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;


public class DonorManagement {
    private LinkedStack<Donor> donorStack;

    public DonorManagement() {
        donorStack = new LinkedStack<>();
        dummyData();
    }
    
    public void dummyData() {
    donorStack.push(new Donor("John Doe", Category.PRIVATE, 123456789));
    donorStack.push(new Donor("Jane Smith", Category.PUBLIC, 987654321));
    donorStack.push(new Donor("Alice Johnson", Category.GOVERNMENT, 555123456));
    donorStack.push(new Donor("Bob Williams", Category.PRIVATE, 555987654));
    donorStack.push(new Donor("Charlie Brown", Category.PUBLIC, 555678901));
    donorStack.push(new Donor("Diana Prince", Category.GOVERNMENT, 555234678));
    donorStack.push(new Donor("Eve Davis", Category.PRIVATE, 555345678));
    donorStack.push(new Donor("Frank Miller", Category.PUBLIC, 555456890));
    donorStack.push(new Donor("Grace Lee", Category.GOVERNMENT, 555578901));
    donorStack.push(new Donor("Hank Pym", Category.PRIVATE, 555678912));
    }
    
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int choice =0;
        String id="";
        int contactNumber =0;
        String name = "";
        boolean repeat =false;
        Category category = null;
        boolean[] found = {false};
        boolean loop =true;
        while (loop){
            clearJavaConsoleScreen();
            System.out.println("Donation Management Main Menu");
            System.out.println(" 1. Add donor");
            System.out.println(" 2. Search donor");
            System.out.println(" 3. filter by category");
            System.out.println(" 4. update donor");
            System.out.println(" 5. remove donor");
            System.out.println(" 6. List Donation Donor with id");
            System.out.println(" 7. List All donor");
            System.out.println(" 8. Generate Summary Report");
            System.out.println(" 0. go back");
            System.out.print(" Enter Your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            clearJavaConsoleScreen();
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    name = "";
                    name += scanner.nextLine();
                    System.out.print("Enter contact number (example: 123456789): ");
                    contactNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    repeat = true;
                    while (repeat){
                        System.out.print("Enter category (private, public or goverment): ");
                        String str = scanner.next().toLowerCase();
                        scanner.nextLine(); 
                        switch(str){
                            case "private":
                                category = Category.PRIVATE;
                                repeat = false;
                                break;
                            case "public":
                                category = Category.PUBLIC;
                                repeat = false;
                                break;
                            case "goverment":
                                category = Category.GOVERNMENT;
                                repeat = false;
                                break;
                            default:
                                 System.out.println("invalide vategorise");
                        }
                    }
                    addDonor(name, category, contactNumber); 
                    scanner.nextLine();
                    break;
                case 2: 
                    System.out.print("Enter donor ID: ");
                    id = scanner.next(); 
                    scanner.nextLine();
                    searchDonor(id,found);
                    scanner.nextLine();
                    break;
                case 3:
                    repeat = true;
                    while(repeat){
                        System.out.print("Enter category (private, public or goverment): ");
                        String str = scanner.next().toLowerCase();
                        scanner.nextLine(); 
                        switch(str){
                            case "private":
                                category = Category.PRIVATE;
                                repeat = false;
                                break;
                            case "public":
                                category = Category.PUBLIC;
                                repeat = false;
                                break;
                            case "goverment":
                                category = Category.GOVERNMENT;
                                repeat = false;
                                break;
                            default:
                                 System.out.println("invaldie vategorise");
                        }
                    }
                    filterOnCriteria(category);
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Enter donor ID: ");
                    id = scanner.next();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    name = "";
                    name += scanner.nextLine();

                    System.out.print("Enter contact number (example: 123456789): ");
                    contactNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    repeat = true;
                    while (repeat){
                        System.out.print("Enter category (private, public or goverment): ");
                        String str = scanner.next().toLowerCase();
                        scanner.nextLine(); 
                        switch(str){
                            case "private":
                                category = Category.PRIVATE;
                                repeat = false;
                                break;
                            case "public":
                                category = Category.PUBLIC;
                                repeat = false;
                                break;
                            case "goverment":
                                category = Category.GOVERNMENT;
                                repeat = false;
                                break;
                            default:
                                 System.out.println("invaldie vategorise");
                        }
                    }
                    updateDonor(id,name,category,contactNumber);
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Enter donor ID: ");
                    id = scanner.next();
                    scanner.nextLine();
                    removeDonor(id);
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Enter donor ID: ");
                    id = scanner.next();
                    scanner.nextLine();
                    listAllDonationByDonor(id);
                    scanner.nextLine();
                    break;
                case 7:
                    listAllDonors();
                    scanner.nextLine();
                    break;
                case 8:
                    generateDonorSummaryReport();
                    scanner.nextLine();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.print("Invalide option");
                    scanner.nextLine();
                    
            }
        }
    }
    
    public void addDonor(String name, Category category, int contactNumber){
        
        Donor newDonor = new Donor(name,category,contactNumber);
        donorStack.push(newDonor);
    }
    
    public void removeDonor(String donorId){
        if (donorStack.isEmpty()) {
            System.out.println("No donors available to remove.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        boolean found = false;
        
        while (!donorStack.isEmpty()) {
            Donor donor = donorStack.pop();
            if (donor.getDonorId().equalsIgnoreCase(donorId)) {
                System.out.println("Removed donor: " );
                System.out.println("Id: "+donor.getDonorId()+" Name: "+donor.getName());
                found = true;
                break;
            } else {
                tempStack.push(donor);
            }
        }
        while (!tempStack.isEmpty()) {
            donorStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Donor with ID " + donorId + " not found.");
        }
    }
    
        public Donor viewMostRecentDonor() {
        if (donorStack.isEmpty()) {
            System.out.println("No donors available.");
        } else {
            Donor recentDonor = donorStack.peek();
            System.out.println("Most recent donor: " + recentDonor);
            return recentDonor;
        }
        return null;
    }
    
    public void updateDonor(String donorId,String name,
            Category category,int ContactNumber){
        Donor donor = null;
        if (donorStack.isEmpty()) {
            System.out.println("No donors available to remove.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        boolean found = false;
        
        while (!donorStack.isEmpty()) {
            donor = donorStack.pop();
            if (donor.getDonorId().equalsIgnoreCase(donorId)) {
                donor.setName(name);
                donor.setCategory(category);
                donor.setContactNumber(ContactNumber);
                donor.setDatejoin(donor.getDatejoin());
                tempStack.push(donor);
                found = true;
                break;
            } else {
                tempStack.push(donor);
            }
        }
        while (!tempStack.isEmpty()) {
            donorStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Donor with ID " + donorId + " not found.");
        }
    }
    
    public Donor searchDonor(String donorId,boolean[] found){
        if (donorStack.isEmpty()) {
            System.out.println("No donors yet.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        found[0] = false;
        Donor tempDonor = null;
        while (!donorStack.isEmpty()) {
            Donor donor = donorStack.pop();
            if (donor.getDonorId().equalsIgnoreCase(donorId)) {
                tempDonor = donor;
                System.out.println(donor.toString());
                tempStack.push(donor);
                found[0] = true;
                break;
            } else {
                tempStack.push(donor);
            }
        }
        while (!tempStack.isEmpty()) {
            donorStack.push(tempStack.pop());
        }

        if (!found[0]) {
            System.out.println("Donor with ID " + donorId + " not found.");
        }
        return tempDonor;
    }
    
    public void listAllDonationByDonor(String donorId){
        boolean[] found = {false};
        Donor temp = searchDonor(donorId,found);
        System.out.println("Donatio make by "+temp.getName());
        searchByDonorId(cll,donorId);
    }
    
    public void listAllDonors() {
        if (donorStack.isEmpty()) {
            System.out.println("No donors available.");
        } else {
            System.out.println("Listing all donors:");
            LinkedStack<Donor> tempStack = new LinkedStack<>();
            while (!donorStack.isEmpty()) {
                Donor donor = donorStack.pop();
                System.out.println(donor.toString());
                tempStack.push(donor);  
            }
            while (!tempStack.isEmpty()) {
                donorStack.push(tempStack.pop());  
            }
        }
    }
    
    public void filterOnCriteria(Category categorise) {
        if (donorStack.isEmpty()) {
            System.out.println("No donors available.");
        } else {
            System.out.println("Listing all donors:");
            LinkedStack<Donor> tempStack = new LinkedStack<>();
            while (!donorStack.isEmpty()) {
                Donor donor = donorStack.pop();
                if(donor.getCategory().equals(categorise)){
                    System.out.println(donor.toString());
                }
                tempStack.push(donor);  
            }
            while (!tempStack.isEmpty()) {
                donorStack.push(tempStack.pop());  
            }
        }
    }
    
 
    
    public void generateDonorSummaryReport() {
        if (donorStack.isEmpty()) {
            System.out.println("No donors in the system.");
            return;
        }

        int totalDonors = donorStack.getSize();
        int privateCount = 0;
        int publicCount = 0;
        int governmentCount = 0;

        LinkedStack<Donor> tempStack = new LinkedStack<>();

        // Traverse the stack to count donors and categorize them
        while (!donorStack.isEmpty()) {
            Donor donor = donorStack.pop();

            // Increment the corresponding category counter
            switch (donor.getCategory()) {
                case PRIVATE:
                    privateCount++;
                    break;
                case PUBLIC:
                    publicCount++;
                    break;
                case GOVERNMENT:
                    governmentCount++;
                    break;
            }

            tempStack.push(donor);
        }

        // Restore the stack to its original state
        while (!tempStack.isEmpty()) {
            donorStack.push(tempStack.pop());
        }
        // Print the report
        System.out.println("Donor Summary Report:");
        System.out.println("Total Donors: " + totalDonors);
        System.out.println("Category: PRIVATE - " + privateCount + " donors");
        System.out.println("Category: PUBLIC - " + publicCount + " donors");
        System.out.println("Category: GOVERNMENT - " 
                + governmentCount + " donors");
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

