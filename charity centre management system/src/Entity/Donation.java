/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DonationManagement;

/**
 *
 * @author User
 */
public class Donation {
    private String donationCategory;// string donationCategory: Funds, Supplies
    private String itemDescription;// string itemDescription: cash, online bank in, card; food, drinks
    private int itemQuantity;// int itemQuantity
    private double amount;// double amount
    
//    example
//        insertDonation(240801, 1001, "Funds\t", "Cash\t", 1, 100.00);
//        insertDonation(240802, 1001, "Supplies", "Food: Bread", 10, 0.00);
//        insertDonation(240803, 1002, "Funds\t", "Online Bank In", 1, 1000.00);
//        insertDonation(240804, 1003, "Supplies", "Food: Maggie", 50, 0.00);
//        insertDonation(240805, 1004, "Funds\t", "Card Payment", 1, 500.00);
//        insertDonation(240806, 1004, "Supplies", "Drinks: Water", 100, 0.00);

    public Donation(String donationCategory, String itemDescription, int itemQuantity, double amount) {
        this.donationCategory = donationCategory;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.amount = amount;
    }

    public Donation() {
        this.donationCategory = null;
        this.itemDescription = null;
        this.itemQuantity = 0;
        this.amount = 0.0;
    }

    public String getDonationCategory() {
        return donationCategory;
    }

    public void setDonationCategory(String donationCategory) {
        this.donationCategory = donationCategory;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return String.format("%-23s %-23s %-15d %10.2f", donationCategory, itemDescription, itemQuantity, amount);
    }
    
    
}
