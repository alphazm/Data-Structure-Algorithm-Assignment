package CharityCentreManagementSystem;

import ADT.LinkedStack;
import Entity.Category;
import Entity.Donation;
import static Managment.DDSubsystem.DonationDistributionMainPage;
import static Managment.DonationManagement.DonationManagement;
import Managment.DonorManagement;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class mainfile {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        DonationManagement();
        DonationDistributionMainPage();
    }
}
