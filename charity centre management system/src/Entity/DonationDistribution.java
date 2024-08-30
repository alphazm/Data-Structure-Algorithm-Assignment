package Entity;

import ADT.CustomArrayList;

/**
 *
 * @author Alden Ling
 */
public class DonationDistribution {

    private int dDistributionid;
    private String doneeid;
    private CustomArrayList<Integer> donationid;
    private String state;
    int test = 1;

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

    public CustomArrayList<Integer> getDonationid() {
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

    public void setDonationid(CustomArrayList<Integer> donationid) {
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
