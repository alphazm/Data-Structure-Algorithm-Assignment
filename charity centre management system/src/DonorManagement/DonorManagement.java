package DonorManagement;

import donor.adt.LinkedStack;

public class DonorManagement {
    private LinkedStack<Donor> donorStack;

    public DonorManagement() {
        donorStack = new LinkedStack<>();
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
    
    public void updateDonor(String donorId,String name,Category category,int ContactNumber){
        Donor donor = null;
        if (donorStack.isEmpty()) {
            System.out.println("No donors available to remove.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        boolean found = false;
        
        while (!donorStack.isEmpty()) {
            donor = donorStack.pop();
            if (donor.getDonorId().equalsIgnoreCase(donorId)) {
                Donor newDonor = null;
                newDonor.setDonorID(donorId);
                newDonor.setName(name);
                newDonor.setCategory(category);
                newDonor.setContactNumber(ContactNumber);
                newDonor.setDatejoin(donor.getDatejoin());
                donor = newDonor;
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
    
    public void searchDonor(String donorId){
        if (donorStack.isEmpty()) {
            System.out.println("No donors available to remove.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        boolean found = false;
        
        while (!donorStack.isEmpty()) {
            Donor donor = donorStack.pop();
            if (donor.getDonorId().equalsIgnoreCase(donorId)) {
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
    }
    
    public void viewMostRecentDonor() {
        if (donorStack.isEmpty()) {
            System.out.println("No donors available.");
        } else {
            Donor recentDonor = donorStack.peek();
            System.out.println("Most recent donor: " + recentDonor);
        }
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
    
    public void filterOnCriteria(String donorID) {
        if (donorStack.isEmpty()) {
            System.out.println("No donors available.");
        } else {
            System.out.println("Listing all donors:");
            LinkedStack<Donor> tempStack = new LinkedStack<>();
            while (!donorStack.isEmpty()) {
                Donor donor = donorStack.pop();
                if(donorID.equals(donorID)){
                    System.out.println(donor.toString());
                }
                tempStack.push(donor);  
            }
            while (!tempStack.isEmpty()) {
                donorStack.push(tempStack.pop());  
            }
        }
    }
    
    public void generateReport(){
        //no idea
    }
    
 
    
}
