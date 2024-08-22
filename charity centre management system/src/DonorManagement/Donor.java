/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DonorManagement;

import java.time.LocalDate;
enum Gender {MELA,FEMELA};
enum Category {INDIVIDUAL,CORPORATE,INSTITUTIONAL}; 
/**
 *
 * @author Lenovo
 */
public class Donor{
    private static int idCounter = 1000;
    String name;
    String donorID;
    Category category;
    String phoneNumber;
    Gender gender;
    LocalDate datejoin;

    public Donor(String name, Category category, String phoneNumber,Gender gender) {
        this.name = name;
        this.donorID = generatedId();
        this.category = category;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDatejoin() {
        return datejoin;
    }

    public void setDatejoin(LocalDate datejoin) {
        this.datejoin = datejoin;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Donor's name=" + name + ", donorID=" + donorID + ", category=" + category + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", datejoin=" + datejoin ;
    }
    
    
    
}
