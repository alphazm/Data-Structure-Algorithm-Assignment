package Entity;

/**
 *
 * @author Heng Wei Long
 */
public class Donation {
    // string donationCategory: Funds, Supplies
    private String donationCategory;
    // string itemDescription: cash, online bank in, card; food, drinks
    private String itemDescription;
    // int itemQuantity
    private int itemQuantity;
    // double amount
    private double amount;
    
    public Donation(String donationCategory, String itemDescription, 
            int itemQuantity, double amount) {
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
        return String.format("%-23s %-23s %-15d %10.2f", 
                donationCategory, itemDescription, itemQuantity, amount);
    }
    
    
}

