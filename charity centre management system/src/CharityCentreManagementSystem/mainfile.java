package CharityCentreManagementSystem;


import Entity.Category;
import Entity.Donor;
import static Managment.DonationManagement.DonationManagement;
import static Managment.DonationManagement.addDonation;
import Managment.DonorManagement;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class mainfile {
    static Scanner scanner = new Scanner(System.in);
    static DonorManagement donorCtrl = new DonorManagement();
    
    public static void main(String[] args)
    {
        DonationManagement(false);
        boolean repeat = true;
        while(repeat){
            System.out.println();
            System.out.println("1.  add donate");
            System.out.println("2.  request donate");
            System.out.println("3.  report");
            System.out.print("Enter selection: ");
            int selection = scanner.nextInt();
            scanner.nextLine(); 
            switch(selection){
                case 1:
                    clearJavaConsoleScreen();
                    newDonation();
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
    
    public static void newDonation(){
        
        boolean repeat = true;
        while(repeat){
            System.out.println("1. new donor");
            System.out.println("2. old donor");
            System.out.print("Enter selection: ");
            int selection = scanner.nextInt();
            scanner.nextLine(); 
            switch(selection){
                    case 1:
                        newDonor();
                        break;
                    case 2:
                        oldDonor();
                        break;
                    default:
                        clearJavaConsoleScreen();
                        System.out.println("Invalid option\n");
            }
        }
    }
    public static void newDonor(){
        System.out.println();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        scanner.nextLine(); 
        System.out.print("Enter contact number (example: 123456789): ");
        int contactNumber = scanner.nextInt();
        scanner.nextLine(); 
        boolean repeat = true;
        while (repeat){
            System.out.print("Enter category (private, public or goverment): ");
            String str = scanner.next().toLowerCase();
            scanner.nextLine(); 
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
        donorCtrl.addDonor(name, Category.PRIVATE, contactNumber); 
        Donor temp = donorCtrl.viewMostRecentDonor();
        addDonation(temp.getDonorId());
    }
    
    public static void oldDonor(){
        boolean flag = false;
        Donor[] temp = null;
        while(!flag){
            System.out.println();
            System.out.println("Enter donor ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            flag = donorCtrl.searchDonor(id,temp);
        }
        addDonation(temp[0].getDonorId());
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