package Managment;

/**
 *
 * @author Alden Ling
 */
import ADT.CustomArrayList;
import Entity.DonationDistribution;
import java.time.LocalDate;
import java.util.Scanner;

public class DDSubsystem {

    public int[] DonationID = {2408001, 2408002, 2408003, 2408004, 2408005, 2408006, 2408007, 2408008};
    public String[] DoneeID = {"DE001", "DE002", "DE003"};
    private static CustomArrayList<DonationDistribution> donationDistributions = new CustomArrayList<>();// dd array list
    public static int DDcount = 1; // Data counting (dd) 

    // dd main page 
    public static void DonationDistributionMainPage() {
        System.out.println("WELCOME TO DONATION DISTRIBUTION SYSTEM");
        System.out.println("-----------------------------------------");
        System.out.println("Select your option :");
        System.out.println("1. Add New Donation Distribution");
        System.out.println("2. Remove Donation Distribution");
        System.out.println("3. Update Donation Distribution Detail");
        System.out.println("4. Monitor Donation Distribution State");
        System.out.println("5. Summary Report");
        System.out.println("6. Exit");
        System.out.println("-----------------------------------------");
        System.out.print("Your Selection: ");
        int anw = new Scanner(System.in).nextInt();
        switch (anw) {
            case 1:

                addNewDonationDistribution();
                break;
            case 2:
                removeDonationDistribution();
                break;
            case 3:
                updateDonationDistribution();
                break;
            case 4:
                monitorDonationDistributions();
                break;
            case 5:
                getSummaryReport();
                break;
            default:
                break;
        }

    }

    // 1. add dd
    public static void addNewDonationDistribution() {
        Scanner scanner = new Scanner(System.in);
        DDSubsystem ddSubsystem = new DDSubsystem();

        // display the available Donee IDs
        System.out.println("Available Donee IDs:");
        for (String doneeId : ddSubsystem.DoneeID) {
            System.out.println(doneeId);
        }

        // enter Donee ID
        System.out.print("Enter Donee ID: ");
        String doneeId = scanner.nextLine();

        // display the available Donation IDs
        System.out.println("Available Donation IDs:");
        for (int donationId : ddSubsystem.DonationID) {
            System.out.println(donationId);
        }

        // enter Donation IDs
        System.out.print("Enter Donation IDs (space-separated): ");
        String donationIdsInput = scanner.nextLine();
        String[] donationIdsArray = donationIdsInput.split(" ");

        // create new donation object 
        CustomArrayList<Integer> donationIds = new CustomArrayList<>();
        for (String donationId : donationIdsArray) {
            int selectedDonationId = Integer.parseInt(donationId);
            // Validate if the selected Donation ID is in the available array
            if (contains(ddSubsystem.DonationID, selectedDonationId)) {
                donationIds.add(selectedDonationId);
            } else {
                System.out.println("Invalid Donation ID: " + selectedDonationId);
            }
        }

        // new donation distribution ID
        int newDistributionId = generateDDistributionId();

        // create a new DonationDistribution object
        DonationDistribution newDistribution = new DonationDistribution();
        newDistribution.setdDistributionid(newDistributionId);
        newDistribution.setDoneeid(doneeId);
        newDistribution.setDonationid(donationIds);
        newDistribution.setState("Ready to Serve");

        // store in array list 
        donationDistributions.add(newDistribution);
        DDcount++; //data counting 

        System.out.println("New Donation Distribution added successfully!");
        DonationDistributionMainPage();
    }

    // 2. remove dd
    public static void removeDonationDistribution() {
        Scanner scanner = new Scanner(System.in);

        listAllDDDatas();

        // enter ddid to search
        System.out.print("Enter the Donation Distribution ID: ");
        int ddidRemove = scanner.nextInt();

        int index = -1;
        for (int i = 0; i < donationDistributions.size(); i++) {
            if (donationDistributions.get(i).getdDistributionid() == ddidRemove) {
                index = i;
                break;
            }
        }

        // found id
        if (index != -1) {
            DonationDistribution distribution = donationDistributions.get(index);
            System.out.println("Donation Distribution Details:");
            System.out.println("Distribution ID: " + distribution.getdDistributionid());
            System.out.println("Donee ID: " + distribution.getDoneeid());
            System.out.println("Donation IDs: " + distribution.getDonationIdString());
            System.out.println("State: " + distribution.getState());

            System.out.print("Do you want to remove this distribution? (y/n) ");
            String sureYa = scanner.next();

            // comfrim remove 
            if ("Y".equals(sureYa) || "y".equals(sureYa)) {
                donationDistributions.remove(index);
                System.out.println("Donation Distribution removed successfully!");
            } else {
                System.out.println("Removal cancelled.");
            }
        } else {
            System.out.println("Donation Distribution with ID " + ddidRemove + " not found.");
        }

        DonationDistributionMainPage();
    }

    // 3. update dd
    public static void updateDonationDistribution() {
        Scanner scanner = new Scanner(System.in);
        DDSubsystem ddSubsystem = new DDSubsystem();

        listAllDDDatas();

        System.out.print("Enter the Donation Distribution ID to update: ");
        int ddidUpdate = scanner.nextInt();
        scanner.nextLine();

        // find ddid
        DonationDistribution oldDistribution = null;
        int index = -1;
        for (int i = 0; i < donationDistributions.size(); i++) {
            if (donationDistributions.get(i).getdDistributionid() == ddidUpdate) {
                oldDistribution = donationDistributions.get(i);
                index = i;
                break;
            }
        }

        if (oldDistribution == null) {
            System.out.println("Donation Distribution not found.");
            return;
        }

        System.out.println("What do you want to update?");
        System.out.println("1. Donation ID");
        System.out.println("2. Donee ID");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1: // change donation id
                System.out.println("Available Donation IDs:");
                for (int donationId : ddSubsystem.DonationID) {
                    System.out.println(donationId);
                }
                System.out.println("");
                System.out.print("Enter the new Donation IDs (space-separated): ");
                String newDonationIds = scanner.nextLine();
                String[] donationIdsArray = newDonationIds.split(" ");

                // new donation id array list
                CustomArrayList<Integer> newDonationIdsArray = new CustomArrayList<>();
                for (String donationId : donationIdsArray) {
                    int selectedDonationId = Integer.parseInt(donationId);
                    // Validate if the selected Donation ID is in the available array
                    if (contains(ddSubsystem.DonationID, selectedDonationId)) {
                        newDonationIdsArray.add(selectedDonationId);
                    } else {
                        System.out.println("Invalid Donation ID: " + selectedDonationId);
                    }
                }
                // old data with new donation id array list 
                DonationDistribution newDistributionWithDonationIds = new DonationDistribution();
                newDistributionWithDonationIds.setdDistributionid(oldDistribution.getdDistributionid());
                newDistributionWithDonationIds.setDoneeid(oldDistribution.getDoneeid());
                newDistributionWithDonationIds.setDonationid(newDonationIdsArray);
                newDistributionWithDonationIds.setState(oldDistribution.getState());

                donationDistributions.update(index, newDistributionWithDonationIds);

                System.out.println("Donation Distribution updated successfully!");
                break;

            case 2: // change donee id
                System.out.println("Available Donee IDs:");
                for (String doneeId : ddSubsystem.DoneeID) {
                    System.out.println(doneeId);
                }
                System.out.println("");
                System.out.print("Enter the new Donee ID: ");
                String newDoneeId = scanner.nextLine();

                // old data with new donee id 
                DonationDistribution newDistributionWithDoneeId = new DonationDistribution();
                newDistributionWithDoneeId.setdDistributionid(oldDistribution.getdDistributionid());
                newDistributionWithDoneeId.setDoneeid(newDoneeId);
                newDistributionWithDoneeId.setDonationid(oldDistribution.getDonationid());
                newDistributionWithDoneeId.setState(oldDistribution.getState());

                donationDistributions.update(index, newDistributionWithDoneeId);

                System.out.println("Donation Distribution updated successfully!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        DonationDistributionMainPage();
    }

    // 4. update state
    public static void monitorDonationDistributions() {
        Scanner scanner = new Scanner(System.in);
        String newState;

        listAllDDDatas();

        System.out.print("Enter Donation Distribution id that want to monitor: ");
        int ddidMonitor = scanner.nextInt();
        System.out.println("");

        DonationDistribution oldDistribution = null;
        int index = -1;
        for (int i = 0; i < donationDistributions.size(); i++) { // find ddid
            if (donationDistributions.get(i).getdDistributionid() == ddidMonitor) {
                oldDistribution = donationDistributions.get(i);
                index = i;
                break;
            }
        }

        if (oldDistribution == null) {
            System.out.println("Donation Distribution not found.");
            return;
        }
        // select state
        System.out.println("");
        System.out.println("1. Ready to Serve ");
        System.out.println("2. Delivering");
        System.out.println("3. Complete Serve");
        System.out.println("Old State of the items: " + oldDistribution.getState());
        System.out.print("Select the currently state of the items:");
        int anw = scanner.nextInt();

        switch (anw) {
            case 1:
                newState = "Ready to Serve";
                break;
            case 2:
                newState = "Delivering";
                break;
            case 3:
                newState = "Complete Serve";
                break;
            default:
                System.out.println("Invalid data");
                newState = oldDistribution.getState();
        }
        // create new object with new state 
        DonationDistribution newDistributionWithState = new DonationDistribution();
        newDistributionWithState.setdDistributionid(oldDistribution.getdDistributionid());
        newDistributionWithState.setDoneeid(oldDistribution.getDoneeid());
        newDistributionWithState.setDonationid(oldDistribution.getDonationid());
        newDistributionWithState.setState(newState);

        donationDistributions.update(index, newDistributionWithState);
        DonationDistributionMainPage();
    }

    // 5. report
    public static void getSummaryReport() {
        System.out.println("Donation Distribution Summary Report");
        listAllDDDatas();
        DonationDistributionMainPage();
    }

    // check the donation ids
    private static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    // auto ddid
    private static int generateDDistributionId() {
        int currentYear = LocalDate.now().getYear();
        int distributionCount = DDcount;
        String distributionId = String.format("%d%04d", currentYear, distributionCount);
        return Integer.parseInt(distributionId);
    }

    // display list of the data 
    private static void listAllDDDatas() {
        int totalDistributions = donationDistributions.size();

        System.out.println("-----------------------------------");
        System.out.println("Total Distributions: " + totalDistributions);
        System.out.println("-----------------------------------");
        System.out.println("Distribution ID   Donee ID           Donation IDs             State");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < donationDistributions.size(); i++) {
            DonationDistribution distribution = donationDistributions.get(i);
            System.out.println("   " + distribution.getdDistributionid() + "       " + distribution.getDoneeid() + "      " + distribution.getDonationIdString() + "     " + distribution.getState());
        }
        System.out.println("--------------------------------------------------------------------");
    }

}
