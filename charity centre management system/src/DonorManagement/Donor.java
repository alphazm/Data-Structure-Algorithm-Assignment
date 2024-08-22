/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DonorManagement;

import java.time.LocalDate;
enum Category {PRIVATE,PUBLIC,GOVERMENT}; 
/**
 *
 * @author Lenovo
 */
public class Donor{
    
    private static int idCounter = 1000;
    String name;
    String donorID;
    Category category;
    String contactNumber;
    LocalDate datejoin;
    
    public Donor(String name, Category category, String contactNumber /*,Donation donation*/) {
        this.name = name;
        this.donorID = generatedId();
        this.category = category;
        this.contactNumber = contactNumber;
        this.datejoin = LocalDate.now();
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
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
        return "Donor's name=" + name + ", donorID=" + donorID + ", category=" + categoryToString(category) + ", contactNumber=" + contactNumber + ", datejoin=" + datejoin ;
    }
    
    
    
}
