package Managment;

import ADT.LinkedQueue;
import ADT.LinkedQueueInterface;
import Entity.Event;
import Entity.volunteer;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EventManagementSystem {
    
    
        static LinkedQueueInterface<Event> eventQueue = new LinkedQueue<>();
        
        private Scanner scanner; 
        
        public EventManagementSystem() {
        this.eventQueue = new LinkedQueue<>();
        this.scanner = new Scanner(System.in);
        }
        
        public static LinkedQueueInterface<Event> getEvent() {
            return eventQueue;
        }
        
        // Create some volunteers
        volunteer volunteer1 = new volunteer("V001", "John", "Doe", 
                "john@example.com", 
                "123-456-7890", "123 Main St", "Helper", true);
        volunteer volunteer2 = new volunteer("V002", "Jane", "Smith", 
                "jane@example.com", 
                "098-765-4321", "456 Elm St", "Helper", true);
        volunteer volunteer3 = new volunteer("V003", "Wei long", "Heng", 
                "hwl@example.com", 
                "098-765-4321", "456 Elm St", "Coordinator", true);
        volunteer volunteer4 = new volunteer("V004", "Alden", "Ling", 
                "Alden@example.com", 
                "098-765-4321", "456 Elm St", "Helper", true);
        volunteer volunteer5 = new volunteer("V005", "Harry", "Chiong", 
                "harry@example.com", 
                "098-765-4321", "456 Elm St", "Coordinator", true);
         
        public void dataInput(){
            List<volunteer> volunteerList = new ArrayList<>();
            volunteerList.add(volunteer1);
            volunteerList.add(volunteer2);
            volunteerList.add(volunteer3);
            volunteerList.add(volunteer4);
            volunteerList.add(volunteer5);
            //Create some event
            Event event1 = new Event("E001"," Community service",
                    "service nursing house", 
                    LocalDateTime.of(2024, 8, 15, 8, 0),
                    LocalDateTime.of(2024, 8, 15, 18, 0),
                    "Setapak nursing house", volunteerList, false);
            Event event2 = new Event("E002"," Car wash Event", "Wash the car", 
                    LocalDateTime.of(2024, 8, 16, 8, 0),
                    LocalDateTime.of(2024, 8, 16, 18, 0), 
                    "Setapak Car wash centre", volunteerList, false);
            Event event3 = new Event("E003"," Fun Run", 
                    "Run 5 km and all the fee will Donate to charity", 
                    LocalDateTime.of(2024, 8, 17, 8, 0),
                    LocalDateTime.of(2024, 8, 17, 18, 0), 
                    "Setapak centre", volunteerList, false);
            Event event4 = new Event("E004",
                    " Community Orphanage service", "Orphanage service", 
                    LocalDateTime.of(2024, 8, 18, 8, 0),
                    LocalDateTime.of(2024, 8, 18, 18, 0), 
                    "Setapak Orphanage", volunteerList, false);
            Event event5 = new Event("E005",
                    "Community clean service", "cleaning service", 
                    LocalDateTime.of(2024, 8, 19, 8, 0),
                    LocalDateTime.of(2024, 8, 19, 18, 0), 
                    "Setapak Garden", volunteerList, false);
            
            eventQueue.enqueue(event1);
            eventQueue.enqueue(event2);
            eventQueue.enqueue(event3);
            eventQueue.enqueue(event4);
            eventQueue.enqueue(event5);
        }
    
    public void displayMenu() {
        boolean running = true;
        dataInput();
        while (running) {
            boolean searchRunning = true;
            boolean searchVolunteerRunning = true;
            System.out.println("\n===== Event Management Menu =====");
            System.out.println("1. Create Event");
            System.out.println("2. Remove Event");
            System.out.println("3. Search Event");
            System.out.println("4. Amend Event");
            System.out.println("5. List all Events");
            System.out.println("6. List all event from a volunteer");
            System.out.println("7. Remove an volunteer for a Event");
            System.out.println("8. generate summary report");
            System.out.println("9. Exit");
            System.out.print("Please choose an option (1-9): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    clearJavaConsoleScreen();
                    createEvent();
                    break;
                case "2":
                    clearJavaConsoleScreen();
                    removeEvent();
                    break;
                case "3":
                    clearJavaConsoleScreen();
                    while(searchRunning){
                        System.out.println("Please enter the "
                                + "Event ID you want to search for:");
                        String eventId = scanner.nextLine(); // Read user input
                        searchEvent(eventId);
                        System.out.print("Do you want to search "
                                + "another Event? (yes/no): ");
                        String response = scanner.nextLine();
                        searchRunning = response.equalsIgnoreCase("yes");
                    }
                    break;    
                case "4":
                    clearJavaConsoleScreen();
                    amendEvent();
                    break;
                case "5":
                    clearJavaConsoleScreen();
                    EventsLists();
                    break;
                case "6":
                    clearJavaConsoleScreen();
                    while(searchVolunteerRunning){
                        System.out.println("Please enter the "
                                + "Volunteer ID you want to search for:");
                        //Read user input
                        String volunteerId = scanner.nextLine();  
                        ListEventForVolunteer(volunteerId);
                        System.out.print("Do you want to search "
                                + "another Volunteer? (yes/no): ");
                        String response = scanner.nextLine();
                        searchVolunteerRunning = 
                                response.equalsIgnoreCase("yes");
                    }
                    break;
                case "7":
                    clearJavaConsoleScreen();
                    RemoveVolunteerForEvent();
                    break;
                case "8":
                    clearJavaConsoleScreen();
                    GenerateEventReports();
                    break;
                case "9":
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public void createEvent() {
        boolean continueCreating = true;
        while (continueCreating) {
            System.out.println("Enter event details:");

            System.out.print("Event ID: ");
            String eventId = scanner.nextLine();

            System.out.print("Event Name: ");
            String name = scanner.nextLine();

            System.out.print("Description: ");
            String description = scanner.nextLine();

            System.out.print("Start Time (yyyy-MM-dd HH:mm): ");
            LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine()
                    , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            System.out.print("End Time (yyyy-MM-dd HH:mm): ");
            LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine()
                    , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            System.out.print("Location: ");
            String location = scanner.nextLine();

        
            // Create a list of volunteers
            List<volunteer> volunteerList = new ArrayList<>();
            volunteerList.add(volunteer1);
            volunteerList.add(volunteer2);
            volunteerList.add(volunteer3);
            volunteerList.add(volunteer4);
            volunteerList.add(volunteer5);
            System.out.print("Is the event active? (true/false): ");
            boolean isActive = Boolean.parseBoolean(scanner.nextLine());

            
            // Create the event
            Event event = new Event(eventId, name, 
                    description, startTime, endTime, 
                    location, volunteerList, isActive);
            // Enqueue the event to the linked queue
            eventQueue.enqueue(event);

            System.out.println("Event created and added "
                    + "to the queue successfully!\n");
        
        

            System.out.print("Do you want to "
                    + "create another event? (yes/no): ");
            String response = scanner.nextLine();
            continueCreating = response.equalsIgnoreCase("yes");
        }
    }
    
     // Method to remove an event from the queue
    public void removeEvent() {
        if (eventQueue.isEmpty()) {
            System.out.println("No events in the queue to remove.");
        } else {
            Event removedEvent = eventQueue.dequeue();
            System.out.println("Removed event from the queue:");
            // Print the removed event's details
            System.out.println(removedEvent); 

        }
    }
    
    // Method to amend an event
        // Existing method to search for an event
    public void searchEvent(String keyword) {
        boolean eventFound = false;

        if (eventQueue.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        System.out.println("========================================");
        System.out.println("        SEARCH RESULTS FOR: " + keyword);
        System.out.println("========================================");

        Iterator<Event> iterator = eventQueue.getIterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();

            // Check if the keyword matches the event ID 
            //or event name (case insensitive)
            if (event.getEventId().equalsIgnoreCase(keyword) 
                    || event.getEventTitle().equalsIgnoreCase(keyword)) {
                eventFound = true;
                System.out.println("Event ID:        " 
                        + event.getEventId());
                System.out.println("Event Name:      " 
                        + event.getEventTitle());
                System.out.println("Description:     " 
                        + event.getDescription());
                System.out.println("Start Time:      " 
                        + event.getStartTime().format
        (DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                System.out.println("End Time:        " 
                        + event.getEndTime().format
        (DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                System.out.println("Location:        " 
                        + event.getLocation());
                System.out.println("Status:          " 
                        + (event.isEventActive() ? "Active" : "Inactive"));
                System.out.println("----------------------------------------");
            }
        }

        if (!eventFound) {
            System.out.println("No events found for the keyword: " + keyword);
        } else {
            System.out.println("End of search results for: " + keyword);
        }
    }

            
    // Method to amend an event
    public void amendEvent() {
        if (eventQueue.isEmpty()) {
            System.out.println("No events in the queue to amend.");
            return;
        }

        System.out.print("Enter the Event ID of the "
                + "event you want to amend: ");
        String eventId = scanner.nextLine();
        
        // Temporary queue to hold events
        LinkedQueue<Event> tempQueue = new LinkedQueue<>(); 
        Event eventToAmend = null;

        // Search for the event in the queue
        while (!eventQueue.isEmpty()) {
            Event currentEvent = eventQueue.dequeue();
            if (currentEvent.getEventId().equals(eventId)) {
                eventToAmend = currentEvent;
            } else {
                tempQueue.enqueue(currentEvent);
            }
        }

        // If the event was found, amend its details
        if (eventToAmend != null) {
            System.out.println("Amending event: " 
                    + eventToAmend.getEventTitle());

            System.out.print("New Event Name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.isBlank()) {
                eventToAmend.setEventTitle(newName);
            }

            System.out.print("New Description (leave "
                    + "blank to keep current): ");
            String newDescription = scanner.nextLine();
            if (!newDescription.isBlank()) {
                eventToAmend.setDescription(newDescription);
            }

            System.out.print("New Start Time "
                    + "(yyyy-MM-dd HH:mm) (leave blank to keep current): ");
            String newStartTime = scanner.nextLine();
            if (!newStartTime.isBlank()) {
                eventToAmend.setStartTime(
                        LocalDateTime.parse(newStartTime, 
                                DateTimeFormatter.
                                        ofPattern("yyyy-MM-dd HH:mm")));
            }

            System.out.print("New End Time (yyyy-MM-dd HH:mm)"
                    + " (leave blank to keep current): ");
            String newEndTime = scanner.nextLine();
            if (!newEndTime.isBlank()) {
                eventToAmend.setEndTime(
                        LocalDateTime.parse(
                                newEndTime,
                                DateTimeFormatter.
                                        ofPattern("yyyy-MM-dd HH:mm")));
            }

            System.out.print("New Location (leave blank to keep current): ");
            String newLocation = scanner.nextLine();
            if (!newLocation.isBlank()) {
                eventToAmend.setLocation(newLocation);
            }

            System.out.print("Is the event active? (true/false"
                    + ", leave blank to keep current): ");
            String newStatus = scanner.nextLine();
            if (!newStatus.isBlank()) {
                eventToAmend.setEventActive(Boolean.parseBoolean(newStatus));
            }

            System.out.println("Event amended successfully!");
        } else {
            System.out.println("Event with ID " + eventId + " not found.");
        }

        // Enqueue the amended event back into the queue
        if (eventToAmend != null) {
            tempQueue.enqueue(eventToAmend);
        }

        // Restore the other events back into the original queue
        while (!tempQueue.isEmpty()) {
            eventQueue.enqueue(tempQueue.dequeue());
        }
    }
     // Method to list all events and their volunteers in the queue
    public void EventsLists() {
        if (eventQueue.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        // Print column titles
        System.out.printf("%-10s %-30s %-50s %-20s %-20s %-30s %-10s%n",
                        "Event ID", "Event Name", 
                        "Description", "Start Time", 
                        "End Time", "Location", "Status");
        System.out.println("------------------------"
                + "----------------------------------"
                + "---------------------------------------------------");

        Iterator<Event> iterator = eventQueue.getIterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();

            // Format and print event details
            System.out.printf("%-10s %-30s %-50s %-20s %-20s %-30s %-10s%n",
                            event.getEventId(),
                            event.getEventTitle(),
                            event.getDescription(),
                            event.getStartTime().format(
                                    DateTimeFormatter.ofPattern
        ("yyyy-MM-dd HH:mm")),
                            event.getEndTime().format(
                                    DateTimeFormatter.ofPattern
        ("yyyy-MM-dd HH:mm")),
                            event.getLocation(),
                            event.isEventActive() ? "Active" : "Inactive");
        }
        
    }
    
    public void ListEventForVolunteer(String volunteerId){
         boolean volunteerFound = false;

        if (eventQueue.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        System.out.println("========================================");
        System.out.println("         EVENTS FOR VOLUNTEER ID: " + volunteerId);
        System.out.println("========================================");

        Iterator<Event> iterator = eventQueue.getIterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();
            List<volunteer> volunteers = event.getVolunteers();

            for (volunteer volunteer : volunteers) {
                if (volunteer.getId().equals(volunteerId)) {
                    volunteerFound = true;
                    System.out.println("Event ID:        " 
                            + event.getEventId());
                    System.out.println("Event Name:      " 
                            + event.getEventTitle());
                    System.out.println("Description:     " 
                            + event.getDescription());
                    System.out.println("Start Time:      " 
                            + event.getStartTime()
                                    .format(DateTimeFormatter
                                            .ofPattern("yyyy-MM-dd HH:mm")));
                    System.out.println("End Time:        " 
                            + event.getEndTime()
                                    .format(DateTimeFormatter
                                            .ofPattern("yyyy-MM-dd HH:mm")));
                    System.out.println("Location:        " 
                            + event.getLocation());
                    System.out.println("Status:          " 
                            + (event.isEventActive() ? 
                                    "Active" : "Inactive"));
                    System.out.println("-------------------"
                            + "---------------------");
                    break; // Volunteer found, no need to check 
                    //further in this event
                }
            }
        }

        if (!volunteerFound) {
            System.out.println("No events found for Volunteer ID: " 
                    + volunteerId);
        } else {
            System.out.println("End of report for Volunteer ID: " 
                    + volunteerId);
        }
    }
    
    public void RemoveVolunteerForEvent(){
        System.out.println("Please enter the Event ID "
                + "from which the volunteer should be removed:");
        String eventId = scanner.nextLine();

        Event event = findEventById(eventId);
        if (event == null) {
            System.out.println("No event found with ID: " + eventId);
            return;
        }

        System.out.println("Please enter the Volunteer "
                + "ID to be removed from the event:");
        String volunteerId = scanner.nextLine();

        List<volunteer> volunteers = event.getVolunteers();
        boolean volunteerRemoved = false;

        // Iterate through the list of volunteers 
        //and remove the specified volunteer
        Iterator<volunteer> iterator = volunteers.iterator();
        while (iterator.hasNext()) {
            volunteer volunteer = iterator.next();
            if (volunteer.getId().equalsIgnoreCase(volunteerId)) {
                iterator.remove();
                volunteerRemoved = true;
                break;
            }
        }

        if (volunteerRemoved) {
            System.out.println("Volunteer ID " + volunteerId 
                    + " has been removed from Event ID " + eventId + ".");
        } else {
            System.out.println("Volunteer ID " + volunteerId 
                    + " not found in Event ID " + eventId + ".");
        }
    }

    // Helper method to find an event by ID
    private Event findEventById(String eventId) {
        Iterator<Event> iterator = eventQueue.getIterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();
            if (event.getEventId().equalsIgnoreCase(eventId)) {
                return event;
            }
        }
        return null; // Event not found
    }
    
    public void GenerateEventReports(){
        System.out.println("Summary Event and volunteer list report:");
        System.out.println(eventQueue.toString());
    }
    
    private static void clearJavaConsoleScreen() {
        try{
            Robot rob = new Robot();
            try {
            rob.keyPress(KeyEvent.VK_CONTROL); // press "CTRL"
            rob.keyPress(KeyEvent.VK_L); // press "L"
            rob.keyRelease(KeyEvent.VK_L); // unpress "L"
            rob.keyRelease(KeyEvent.VK_CONTROL); // unpress "CTRL"
            Thread.sleep(1000); // add delay in milisecond, 
            //if not there will automatically stop after clear
            } catch (InterruptedException e) { e.printStackTrace(); }
        } catch(AWTException e) { e.printStackTrace(); }
    }
    public static void main(String[] args) {
        EventManagementSystem Event = new EventManagementSystem();
        // Display event details
        Event.displayMenu(); // Display the menu to the user
    }
}
