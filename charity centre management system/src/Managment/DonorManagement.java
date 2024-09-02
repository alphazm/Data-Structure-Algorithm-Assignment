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


public class DonorManagement {
    private LinkedStack<Donor> donorStack;

    public DonorManagement() {
        donorStack = new LinkedStack<>();
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
                Donor newDonor = null;
                newDonor.setDonorID(donorId);
                newDonor.setName(name);
                newDonor.setCategory(category);
                newDonor.setContactNumber(ContactNumber);
                newDonor.setDatejoin(donor.getDatejoin());
                tempStack.push(newDonor);
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
    
    public boolean searchDonor(int donorId,Donor[] tempDonor){
        if (donorStack.isEmpty()) {
            System.out.println("No donors yet.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        boolean found = false;
        
        while (!donorStack.isEmpty()) {
            Donor donor = donorStack.pop();
            if (donor.getDonorId()==(donorId)) {
                tempDonor[0] = donor;
                System.out.println(donor.toString());
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
        return found;
    }
    
    public void listAllDonationByDonor(int donorId){
        Donor[] donor = null;
        searchDonor(donorId,donor);
        System.out.println("Donatio make by "+donor[0].getName());
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
 
    
}
