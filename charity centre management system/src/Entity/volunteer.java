
package Entity;

/**
 *
 * @author Harry
 */
public class volunteer {
    private String id;           // Unique identifier for the volunteer
    private String firstName;    // First name of the volunteer
    private String lastName;     // Last name of the volunteer
    private String email;        // Email address of the volunteer
    private String phoneNumber;  // Phone number of the volunteer
    private String address;      // Address of the volunteer
    private String role;         // Role of the volunteer (e.g., Coordinator, Helper)
    private boolean isActive;    // Status indicating if the volunteer is currently active

    // Constructor to initialize the Volunteer object
    public volunteer(String id, String firstName, String lastName, String email, 
                     String phoneNumber, String address, String role, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
     @Override
    public String toString() {
        return "Volunteer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
