package Entity;

/**
 *
 * @author Heng Wei Long
 */
public class DonationManage {
    private int donationId;
    private String donorId;
    private String dateTime;
    private String fromEvent;
    private Donation donation;

    public DonationManage(int donationId, String donorId, String dateTime, 
            String fromEvent, Donation donation) {
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

    public String getFromEvent() {
        return fromEvent;
    }

    public void setFromEvent(String fromEvent) {
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
        return String.format(donationId + "\t\t" + donorId + "\t\t" + dateTime 
                + "\t\t" + fromEvent + "\t\t" + donation.toString());
    }
}