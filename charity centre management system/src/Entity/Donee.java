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
    private static int idCounter = 1000;
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

    public void setDoneeName(){
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
    public void setPhoneNo(){
    this.phoneNo=phoneNo;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setAddress(){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void addRequirement(Requirement requirement){
        requirements.add(requirement);
    }
    public LinearLinkedList<Requirement> getRequirements(){
        return reuirements;

    public String toString(){
        return
                "Donee ID =" + doneeID +
                "Donee Name =" + doneeName +
                "Donee Contact Number =" + phoneNo +
                "Donee Address =" + address +
                "Donee requirements =" + requirements.toString();
    }
}
