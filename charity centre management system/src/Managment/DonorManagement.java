package Managment;
/**
 *
 * @author Chong Zhi Ming
 */
import ADT.CircularLinkedList;
import Entity.Donor;
import Entity.Category;
import ADT.LinkedStack;
import static Managment.DonationManagement.DonationManagement;

import static Managment.DonationManagement.searchByDonorId;
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
    
    public void addDonor(String name, Category category, int contactNumber){
        
        Donor newDonor = new Donor(name,category,contactNumber);
        donorStack.push(newDonor);
    }
    
    public void removeDonor(int donorId){
        if (donorStack.isEmpty()) {
            System.out.println("No donors available to remove.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        boolean found = false;
        
        while (!donorStack.isEmpty()) {
            Donor donor = donorStack.pop();
            if (donor.getDonorId() == donorId ) {
                System.out.println("Removed donor: " + donor);
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
    
    public void updateDonor(int donorId,String name,
            Category category,int ContactNumber){
        Donor donor = null;
        if (donorStack.isEmpty()) {
            System.out.println("No donors available to remove.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        boolean found = false;
        
        while (!donorStack.isEmpty()) {
            donor = donorStack.pop();
            if (donor.getDonorId()==(donorId)) {
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
    
    public Donor searchDonor(int donorId,boolean[] found){
        if (donorStack.isEmpty()) {
            System.out.println("No donors yet.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        found[0] = false;
        Donor tempDonor = null;
        while (!donorStack.isEmpty()) {
            Donor donor = donorStack.pop();
            if (donor.getDonorId()==(donorId)) {
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
    
    public void listAllDonationByDonor(int donorId, CircularLinkedList list){
        boolean[] found = {false};
        Donor temp = searchDonor(donorId,found);
        System.out.println("Donatio make by "+temp.getName());
        searchByDonorId(list, donorId);
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
            totalDonors++;

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
 
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        DonorManagement ctrl =new DonorManagement();
        DonationManagement(false);
        boolean[] found = {false};
        Category category = null;
        
        
        
    }
}
