/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author winyi
 */
import ADT.LinearLinkedList; 
public class Requirement {
    private static int counter= 1000;
    String food;
    String householdGoods;
    String donationMoney;
    //requirementID: R0001, R0002
    String requirementID;
    public Requirement(String food, String householdGoods, String donationMoney){
        this.food = food;
        this.householdGoods = householdGoods;
        this.donationMoney = donationMoney;
        this.requirementID = generatedId();
    }
    private String generatedId(){
        CountId();
        return "R" + counter;
    }
    private static int CountId(){
        return counter++;
    }
    public void setFood(String food){
        this.food = food;
    }
    public String getFood(){
        return food;
    }
    public void setHouseholdGoods(String householdGoods){
        this.householdGoods = householdGoods;
    }
    public String getHouseholdGoods(){
        return householdGoods;
    }
    public void setDonationMoney(String donationMoney){
        this.donationMoney = donationMoney;
    }
    public String getDonationMoney(){
        return donationMoney;
    }
    
    public String toString(){
        if(food == null){
            return
                    "RequirementID =" + requirementID +
                    "Goods =" + householdGoods +
                    "Donation Money Amount =" + donationMoney;
        }
        else if(householdGoods == null){
            return
                    "RequirementID =" + requirementID +
                    "Food =" + food +
                    "Donation Money Amount =" + donationMoney;
        }
        else if(donationMoney == null){
            return
                    "RequirementID =" + requirementID +
                    "Food =" + food +
                    "Goods=" + householdGoods;
        }
        else if(donationMoney == null && food == null){
            return
                    "RequirementID =" + requirementID +
                    "Goods=" + householdGoods;
        }
        else if(householdGoods == null && food == null){
            return
                    "RequirementID =" + requirementID +
                    "Donation Money Amount =" + donationMoney;
        }
        else if(householdGoods == null && donationMoney == null){
            return
                    "RequirementID =" + requirementID +
                    "Food =" + food;
        }
        else if(householdGoods == null && donationMoney == null && food==null){
            return
                    "Requirement is empty";
        }
        else{
            return 
                    "RequirementID =" + requirementID +
                    "Food =" + food +
                    "Goods=" + householdGoods +
                    "Donation Money Amount =" + donationMoney;
        }
        
    }
}
