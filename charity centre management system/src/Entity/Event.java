
package Entity;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private String eventId;                 // Unique identifier for the event
    private String eventTitle;                    // Name of the event
    private String description;             // Description of the event
    private LocalDateTime startTime;        // Start time of the event
    private LocalDateTime endTime;          // End time of the event
    private String location;                // Location of the event
    private List<volunteer> volunteers;     // List of volunteers assigned to the event
    private boolean eventActive;               // Status indicating if the event is currently active

    // Constructor to initialize the Event object
    public Event(String eventId, String eventTitle, String description, LocalDateTime startTime, 
                 LocalDateTime endTime, String location, List<volunteer> volunteers, boolean eventActive) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.volunteers = volunteers;
        this.eventActive = eventActive;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    public boolean isEventActive() {
        return eventActive;
    }

    public void setEventActive(boolean eventActive) {
        this.eventActive = eventActive;
    }
    
    // Override toString method for better readability
    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();
        report.append("========================================\n");
        report.append("           EVENT REPORT\n");
        report.append("========================================\n");
        report.append("Event ID:        ").append(eventId).append("\n");
        report.append("Event Name:      ").append(eventTitle).append("\n");
        report.append("Description:     ").append(description).append("\n");
        report.append("Start Time:      ").append(startTime).append("\n");
        report.append("End Time:        ").append(endTime).append("\n");
        report.append("Location:        ").append(location).append("\n");
        report.append("Status:          ").append(eventActive ? "Active" : "Inactive").append("\n");
        report.append("Volunteers:      ").append(volunteers.size()).append(" volunteer(s)\n");
        report.append("----------------------------------------\n");
        report.append("Volunteer Details:\n");

        for (volunteer volunteer : volunteers) {
            report.append("  - ").append(volunteer.getFirstName()).append(" ").append(volunteer.getLastName())
                .append(" (Role: ").append(volunteer.getRole()).append(")\n");
        }

        report.append("========================================\n");

        return report.toString();
    }

}
