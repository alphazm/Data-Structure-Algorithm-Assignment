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
    String food;
    String householdGoods;
    String donationMoney;
    
    public Requirement(String food, String householdGoods, String donationMoney){
        this.food = food;
        this.householdGoods = householdGoods;
        this.donationMoney = donationMoney;
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
        return
                "Food =" + food + 
                "Goods =" + householdGoods + 
                "Money amount =" + donationMoney;
        
    }
}
