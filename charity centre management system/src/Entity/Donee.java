/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ChanWinYit
 */
import ADT.LinearLinkedList;
import ADT.ArrayList;

public class Donee {
    private static int idCounter = 0;
    String doneeName;
    //doneeID: DE0001, DE0002
    String doneeID;
    String phoneNo;
    String address;
    private ArrayList<String> receivedItems;


    public Donee(String doneeName,String phoneNo,String address){
        this.doneeName = doneeName;
        this.doneeID = generatedId();
        this.phoneNo = phoneNo;
        this.address = address;
        this.receivedItems = new ArrayList<>();
    }

    private String generatedId(){
        CountId();
        return String.format("DE%04d", idCounter);
    }

    private static int CountId(){
        return idCounter++;
    }

    public void setDoneeName(String doneeName){
        this.doneeName=doneeName;
    }
    public String getDoneeName(){
        return doneeName;
    }
    public void setDoneeID(){
        this.doneeID=doneeID;
    }
    public String getDoneeID(){
        return doneeID;
    }
    public void setPhoneNo(String phoneNo){
    this.phoneNo=phoneNo;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    
    public void addReceivedItem(String item){
        receivedItems.addinArray(item);
    }
    
    public String getReceivedItem() {
        if (receivedItems.size() == 0) {
            return "None";
        }
        String string = new String();
        for (int i = 0; i < receivedItems.size(); i++) {
            if (i > 0) {
                string.append(", ");
            }
            string.append(receivedItems.get(i));
        }
        return string.toString();
    }
    
    
    public String toString(){
        return
                "Donee ID =" + doneeID +
                "\nDonee Name =" + doneeName +
                "\nDonee Contact Number =" + phoneNo +
                "\nDonee Address =" + address;
                
    }
    
    public String toString2(){
        return
                "Donee ID ="+ doneeID +
                "\nDonee Name =" + doneeName +
                "Received Items =" + getReceivedItem();
    }
}
