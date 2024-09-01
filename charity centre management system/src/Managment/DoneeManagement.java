package Management;

/**
 *
 * @author ChanWinYit
 */
import Entity.Donee;
import Entity.Requirement;
import ADT.LinearLinkedList;

public class DoneeManagement {
    private LinearLinkedList<Donee> doneeList;

    public DoneeManagement() {
        doneeList = new LinearLinkedList<>();
    }

    public void addDonee(String doneeName, String phoneNo, String address) {
        Donee newDonee = new Donee(doneeName,phoneNo, address); 
        doneeList.add(newDonee);
    }
    public void addRequirementToDonee(String doneeID, Requirement requirement) {
        Donee donee = searchDonee(doneeID);
        if (donee != null) {
            donee.addRequirement(requirement);
            System.out.println("Requirement added to donee: " + doneeID);
        } else {
            System.out.println("Donee with ID " + doneeID + " not found.");
        }
    }

    public void removeDonee(String doneeID) {
        if (doneeList.isEmpty()) {
            System.out.println("The Donee list is empty");
            return;
        }
        boolean found = false;

        for (int i = 1; i <= doneeList.getNumberOfEntries(); i++) {
            Donee donee = doneeList.getEntry(i);
            if (donee.getDoneeID().equalsIgnoreCase(doneeID)) {
                doneeList.remove(donee);
                System.out.println(donee + "has been removed");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid ID:" + doneeID);
        }
    }

    public void updateDonee(String doneeID, String doneeName, String phoneNo, String address) {
        if (doneeList.isEmpty()) {
            System.out.println("The Donee list is empty");
            return;
        }
        boolean found = false;

        for (int i = 1; i <= doneeList.getNumberOfEntries(); ++i) {
            Donee donee = doneeList.getEntry(i);
            if (donee.getDoneeID().equalsIgnoreCase(doneeID)) {
                donee.setDoneeName(doneeName);
                donee.setPhoneNo(phoneNo);
                donee.setAddress(address);
                doneeList.replace(i, donee);
                System.out.println("Updated donee: " + donee);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid ID:" + doneeID);
        }
    }

    public Donee searchDonee(String doneeID) {
        if (doneeList.isEmpty()) {
            System.out.println("The Donee list is empty");
            return null;
        }

        for (int i = 1; i <= doneeList.getNumberOfEntries(); ++i) {
            Donee donee = doneeList.getEntry(i);
            if (donee.getDoneeID().equalsIgnoreCase(doneeID)) {
                System.out.println(donee);
                return donee;
            }
        }

        System.out.println("Invalid ID:" + doneeID);
        return null;
    }

    public void listAllDonees() {
        if (doneeList.isEmpty()) {
            System.out.println("The Donee list is empty");
            return;
        }

        System.out.println("Listing all donees:");
        for (int i = 1; i <= doneeList.getNumberOfEntries(); ++i) {
            Donee donee = doneeList.getEntry(i);
            System.out.println(donee);
        }
    }
}
