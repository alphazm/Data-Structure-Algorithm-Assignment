package CharityCentreManagementSystem;

import static Managment.DDSubsystem.DonationDistributionMainPage;
import static Managment.DonationManagement.DonationManagement;
import java.util.Scanner;

public class mainfile {

    public static void main(String[] args) {
        System.out.print("Select your Subsystem:");
        System.out.print("-------------------------------");
        System.out.print("1. Donation Managment ");
        System.out.print("2. Donation Distribution");
        System.out.print("-------------------------------");
        System.out.print("Selection:");
        int anw = new Scanner(System.in).nextInt();

        if (anw == 1) {
            DonationManagement();
        } else if (anw == 2) {
            DonationDistributionMainPage();
        }
    }
}
