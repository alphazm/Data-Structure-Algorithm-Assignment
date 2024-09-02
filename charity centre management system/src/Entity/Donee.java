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

public class Donee {
    private static int idCounter = 0000;
    String doneeName;
    //doneeID: DE0001, DE0002
    String doneeID;
    String phoneNo;
    String address;
    private LinearLinkedList<Requirement> requirements;


    public Donee(String doneeName,String phoneNo,String address){
        this.doneeName = doneeName;
        this.doneeID = generatedId();
        this.phoneNo = phoneNo;
        this.address = address;
        this.requirements = new LinearLinkedList<>();
    }

    private String generatedId(){
        CountId();
        return "DE"+idCounter;
    }

    private static int CountId(){
        return idCounter++;
    }

    public void setDoneeName(String doneeName){
        this.doneeName=doneeName;
    }
    public String getName(){
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
    public void addRequirement(Requirement requirement){
        requirements.add(requirement);
    }
    public LinearLinkedList<Requirement> getRequirements(){
        return requirements;
    }
    public String toString(){
        return
                "Donee ID =" + doneeID +
                "Donee Name =" + doneeName +
                "Donee Contact Number =" + phoneNo +
                "Donee Address =" + address +
                "Donee requirements =" + requirements.toString();
    }
}
