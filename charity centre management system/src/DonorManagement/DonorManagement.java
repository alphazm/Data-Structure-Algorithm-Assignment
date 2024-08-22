/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DonorManagement;

import donor.adt.LinkedStack;

/**
 *
 * @author Lenovo
 */
public class DonorManagement {
    private LinkedStack<Donor> donorStack;

    public DonorManagement() {
        donorStack = new LinkedStack<>();
    }
    
    public void addDonor(String name, Category category, String phoneNumber,Gender gender){
        Donor newDonor = new Donor(name,category,phoneNumber,gender);
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
                System.out.println(donor);
                tempStack.push(donor);  // Save donor to tempStack to preserve original stack
            }
            while (!tempStack.isEmpty()) {
                donorStack.push(tempStack.pop());  // Restore original stack order
            }
        }
    }
}
