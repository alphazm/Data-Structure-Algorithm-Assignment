package Entity;

import ADT.LinkedStack;
import java.time.LocalDate;

public class Donor{
    
    private static int idCounter = 1000;
    String name;
    String donorID;
    Category category;
    int contactNumber;
    LocalDate datejoin;
    LinkedStack<Donation> donations;

    public Donor(String name, Category category, int contactNumber , LinkedStack<Donation> donations) {
        this.name = name;
        this.donorID = generatedId();
        this.category = category;
        this.contactNumber = contactNumber;
        this.datejoin = LocalDate.now();
        this.donations = donations;
    }
    
    private String generatedId(){
        CountId();
        return "DR"+idCounter;
    }
            
    private static int CountId(){
        return idCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDonorId(){
        return donorID;
    }

    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDate getDatejoin() {
        return datejoin;
    }

    public void setDatejoin(LocalDate datejoin) {
        this.datejoin = datejoin;
    }
    
    private String categoryToString(Category category){
        String str = "";
        switch(category){
            case PRIVATE -> str = "Private";
            case PUBLIC -> str = "Public";
            case GOVERMENT -> str = "Goverment";
        }
        return str;
    }

    @Override
    public String toString() {
        return "Donor's name=" + name + ", donorID=" + donorID + ", category=" + categoryToString(category) + ", contactNumber=60" + contactNumber + ", datejoin=" + datejoin ;
    }
    
    
    
}
