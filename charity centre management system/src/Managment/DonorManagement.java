package Managment;

import Entity.Donor;
import Entity.Category;
import ADT.LinkedStack;
import Entity.Donation;


public class DonorManagement {
    private LinkedStack<Donor> donorStack;

    public DonorManagement() {
        donorStack = new LinkedStack<>();
    }
    
    public void addDonor(String name, Category category, int contactNumber,LinkedStack<Donation> donations){
        
        Donor newDonor = new Donor(name,category,contactNumber,donations);
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
    
    public Donor searchDonor(String donorId){
        if (donorStack.isEmpty()) {
            System.out.println("No donors yet.");
        }
        LinkedStack<Donor> tempStack = new LinkedStack<>();
        Donor tempDonor = null;
        boolean found = false;
        
        while (!donorStack.isEmpty()) {
            Donor donor = donorStack.pop();
            if (donor.getDonorId().equalsIgnoreCase(donorId)) {
                tempDonor = donor;
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
        return tempDonor;
    }
    public void listAllDonationByDonor(String donorId){
        Donor donor = searchDonor(donorId);
        System.out.println("Donatio make by "+donor.getName());
        while(!donor.donations.isEmpty()){
            Donation donation = donor.donations.pop();
            System.out.println(donation.toString());
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
    
 
    
    public void generateReport(){
        //no idea
    }
    
 
    
}
