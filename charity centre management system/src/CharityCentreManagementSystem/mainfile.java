package CharityCentreManagementSystem;


import ADT.CircularLinkedList;
import Entity.Category;
import Entity.Donor;
import static Managment.DDSubsystem.DonationDistributionMainPage;
import static Managment.DonationManagement.DonationManagement;
import static Managment.DonationManagement.addDonation;
import static Managment.DonationManagement.donationMenu;
import static Managment.DoneeManagement.DoneeMenu;
import Managment.DonorManagement;
import Managment.EventManagementSystem;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class mainfile {
    static Scanner scanner = new Scanner(System.in);
    static DonorManagement donorCtrl = new DonorManagement();
    static EventManagementSystem eventCtrl = new EventManagementSystem();
    public static void main(String[] args)
    {
        DonationManagement(false);
        
        boolean repeat = true;
        while(repeat){
            System.out.println();
            System.out.println("1.  add donate");
            System.out.println("2.  donate distribute");
            System.out.println("3.  management");
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
                    addNewDonationDistribution();
                    break;
                case 3:
                    clearJavaConsoleScreen();
                    management();
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
        Category category = null;
        System.out.println();
        System.out.print("Enter Name: ");
        String name = "";
        name += scanner.nextLine();
        
        System.out.print("Enter contact number (example: 123456789): ");
        int contactNumber = scanner.nextInt();
        scanner.nextLine(); 
        boolean repeat = true;
        while (repeat){
            System.out.print("Enter category (private, public or goverment): ");
            String str = scanner.next().toLowerCase();
            scanner.nextLine(); 
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
                     System.out.println("invalide vategorise");
            }
        }
        donorCtrl.addDonor(name, category, contactNumber); 
        Donor temp = donorCtrl.viewMostRecentDonor();
        addDonation(temp.getDonorId());
    }
    
    public static void oldDonor(){
        boolean[] flag = {false};
        Donor temp = null;
        while(!flag[0]){
            System.out.println();
            System.out.println("Enter donor ID: ");
            String id = scanner.next();
            scanner.nextLine(); 
            temp = donorCtrl.searchDonor(id,flag);
        }
        addDonation(temp.getDonorId());
    }
    
    
    public static void management(){
        boolean repeat = true;
        while(repeat){
            System.out.println();
            System.out.println("1.  donation management");
            System.out.println("2.  donation distribution");
            System.out.println("3.  donee");
            System.out.println("4.  event");
            System.out.println("5.  donor");
            System.out.print("Enter selection: ");
            int selection = scanner.nextInt();
            scanner.nextLine(); 
            switch(selection){
                case 1:
                    clearJavaConsoleScreen();
                    donationMenu();
                    break;
                case 2:
                    clearJavaConsoleScreen();
                    DonationDistributionMainPage();
                    break;
                case 3:
                    clearJavaConsoleScreen();
                    DoneeMenu();
                    break;
                case 4:
                    clearJavaConsoleScreen();
                    eventCtrl.displayMenu();
                    break;
                case 5:
                    clearJavaConsoleScreen();
                    donorCtrl.menu();
                    break;
                default:
                    clearJavaConsoleScreen();
                    System.out.println("Invalid option\n");
            }
        }
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
