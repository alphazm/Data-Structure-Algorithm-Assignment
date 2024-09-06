/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author User
 */
public class DonationManage {
    private int donationId;
    private String donorId;
    private String dateTime;
    private boolean fromEvent;
    private Donation donation;

    public DonationManage(int donationId, String donorId, String dateTime, boolean fromEvent, Donation donation) {
        this.donationId = donationId;
        this.donorId = donorId;
        this.dateTime = dateTime;
        this.fromEvent = fromEvent;
        this.donation = donation;
    }
    
    public DonationManage() {
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isFromEvent() {
        return fromEvent;
    }

    public void setFromEvent(boolean fromEvent) {
        this.fromEvent = fromEvent;
    }
    
    public Donation getDonation() {
        return donation;
    }
    
    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    @Override
    public String toString() {
        return String.format(donationId + "\t\t" + donorId + "\t\t" + dateTime + "\t\t" + fromEvent + "\t\t");
    }
}
