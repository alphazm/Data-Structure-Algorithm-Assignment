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
        boolean repeat = true;
        while(repeat){
            System.out.println();
            System.out.println("1.  add donate");
            System.out.println("2.  request donate");
            System.out.println("3.  report");
            System.out.print("Enter selection: ");
            int selection = scanner.nextInt();
            switch(selection){
                case 1:
                    clearJavaConsoleScreen();
                    addDonation();
                    break;
                case 2:
                    clearJavaConsoleScreen();
                    requsetDonation();
                    break;
                case 3:
                    clearJavaConsoleScreen();
                    report();
                    break;
                default:
                    clearJavaConsoleScreen();
                    System.out.println("Invalid option\n");
            }
        }
    }
    
    public static void addDonation(){
        DonorManagement ctrl = new DonorManagement();
        boolean repeat = true;
        while(repeat){
            System.out.println("1. new donor");
            System.out.println("2. old donor");
            System.out.print("Enter selection: ");
            int selection = scanner.nextInt();
            switch(selection){
                    case 1:
                        newDonor(ctrl);
                        break;
                    case 2:

                        break;
                    default:
                        clearJavaConsoleScreen();
                        System.out.println("Invalid option\n");
            }
        }
    }
    public static void newDonor(DonorManagement ctrl){
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter contact number (example: 123456789): ");
        int contactNumber = scanner.nextInt();
        boolean repeat = true;
        while (repeat){
            System.out.println("Enter category (private, public or goverment): ");
            String str = scanner.next().toLowerCase();
            Category category;
            switch(str){
                case "private":
                    category = Category.PRIVATE;
                    repeat = false;
                    break;
                case "public":
                    category = Category.PUBLIC;
                    repeat = false;
                    break;
                case "goverment":
                    category = Category.GOVERNMENT;
                    repeat = false;
                    break;
                default:
                     System.out.println("invaldie vategorise");
            }
        }
        System.out.println("Enter donationCategory (Supplies or funds): ");
        String donationCategory = scanner.next();
        Donation donation = null;
        if(donationCategory.equalsIgnoreCase("supplies")){
            System.out.println("Enter item description: ");
            String item = scanner.next();
            System.out.println("Enter item quantity: ");
            int qty = scanner.nextInt();
            donation = new Donation(donationCategory, item, qty, 0.00);
        }else if(donationCategory.equalsIgnoreCase("funds")){
            System.out.println("Enter amount: ");
            float amount = scanner.nextInt();
            donation = new Donation(donationCategory, "Clothing: Hats", 0, amount);
        }
       ctrl.addDonor(name, Category.PRIVATE, contactNumber,donation); 
     
        
        
    }
    
    public static void requsetDonation(){
        
    }
    
    public static void report(){
        
    }
    
    private static void clearJavaConsoleScreen() {
        try{
            Robot rob = new Robot();
            try {
            rob.keyPress(KeyEvent.VK_CONTROL); // press "CTRL"
            rob.keyPress(KeyEvent.VK_L); // press "L"
            rob.keyRelease(KeyEvent.VK_L); // unpress "L"
            rob.keyRelease(KeyEvent.VK_CONTROL); // unpress "CTRL"
            Thread.sleep(1000); // add delay in milisecond, if not there will automatically stop after clear
            } catch (InterruptedException e) { e.printStackTrace(); }
        } catch(AWTException e) { e.printStackTrace(); }
    }
}
