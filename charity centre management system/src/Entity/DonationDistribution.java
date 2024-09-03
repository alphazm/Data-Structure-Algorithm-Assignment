package Entity;

import ADT.ArrayList;

/**
 *
 * @author Alden Ling
 */
public class DonationDistribution {

    private int dDistributionid;
    private String doneeid;
    private ArrayList<Integer> donationid;
    private String state;

    public int getdDistributionid() {
        return dDistributionid;
    }

    public void setdDistributionid(int dDistributionid) {
        this.dDistributionid = dDistributionid;
    }

    public String getDoneeid() {
        return doneeid;
    }

    public void setDoneeid(String doneeid) {
        this.doneeid = doneeid;
    }

    public ArrayList<Integer> getDonationid() {
        return donationid;
    }

    public String getDonationIdString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < donationid.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(donationid.get(i));
        }
        return sb.toString();
    }

    public void setDonationid(ArrayList<Integer> donationid) {
        this.donationid = donationid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DonationDistribution{"
                + "dDistributionid=" + dDistributionid
                + ", doneeid='" + doneeid + '\''
                + ", donationid=" + donationid
                + ", state='" + state + '\''
                + '}';
    }

}
