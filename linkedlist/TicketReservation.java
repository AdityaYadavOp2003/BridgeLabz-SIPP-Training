package linkedlist;
import java.util.ArrayList;
import java.util.List;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    TicketNode next;
    
    TicketNode(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationLinkedList {
    private TicketNode head;
    private int ticketCount;
    
    TicketReservationLinkedList() {
        this.head = null;
        this.ticketCount = 0;
    }
    
    void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        
        if (this.head == null) {
            this.head = newTicket;
            newTicket.next = newTicket;
        } else {
            TicketNode last = this.head;
            while (last.next != this.head) {
                last = last.next;
            }
            last.next = newTicket;
            newTicket.next = this.head;
        }
        this.ticketCount++;
    }
    
    boolean removeTicket(int ticketId) {
        if (this.head == null) {
            return false;
        }
        
        if (this.head.ticketId == ticketId) {
            if (this.head.next == this.head) {
                this.head = null;
            } else {
                TicketNode last = this.head;
                while (last.next != this.head) {
                    last = last.next;
                }
                last.next = this.head.next;
                this.head = this.head.next;
            }
            this.ticketCount--;
            return true;
        }
        
        TicketNode current = this.head;
        do {
            if (current.next.ticketId == ticketId) {
                current.next = current.next.next;
                this.ticketCount--;
                return true;
            }
            current = current.next;
        } while (current != this.head);
        
        return false;
    }
    
    void displayAllTickets() {
        if (this.head == null) {
            System.out.println("No tickets in the system");
            return;
        }
        
        System.out.println("All Booked Tickets:");
        System.out.println("Ticket ID | Customer Name | Movie Name | Seat Number | Booking Time");
        System.out.println("----------|---------------|------------|-------------|--------------");
        
        TicketNode current = this.head;
        do {
            System.out.printf("%9d | %13s | %10s | %11d | %12s%n", 
                            current.ticketId, current.customerName, 
                            current.movieName, current.seatNumber, current.bookingTime);
            current = current.next;
        } while (current != this.head);
    }
    
    List<TicketNode> searchByCustomerName(String customerName) {
        List<TicketNode> results = new ArrayList<>();
        if (this.head == null) {
            return results;
        }
        
        TicketNode current = this.head;
        do {
            if (current.customerName.toLowerCase().contains(customerName.toLowerCase())) {
                results.add(current);
            }
            current = current.next;
        } while (current != this.head);
        
        return results;
    }
    
    List<TicketNode> searchByMovieName(String movieName) {
        List<TicketNode> results = new ArrayList<>();
        if (this.head == null) {
            return results;
        }
        
        TicketNode current = this.head;
        do {
            if (current.movieName.toLowerCase().contains(movieName.toLowerCase())) {
                results.add(current);
            }
            current = current.next;
        } while (current != this.head);
        
        return results;
    }
    
    int getTotalBookedTickets() {
        return this.ticketCount;
    }
    
    boolean isSeatAvailable(int seatNumber) {
        if (this.head == null) {
            return true;
        }
        
        TicketNode current = this.head;
        do {
            if (current.seatNumber == seatNumber) {
                return false;
            }
            current = current.next;
        } while (current != this.head);
        
        return true;
    }
    
    List<Integer> getAvailableSeats(int totalSeats) {
        List<Integer> availableSeats = new ArrayList<>();
        for (int seat = 1; seat <= totalSeats; seat++) {
            if (isSeatAvailable(seat)) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }
    
    void displayAvailableSeats(int totalSeats) {
        List<Integer> availableSeats = getAvailableSeats(totalSeats);
        System.out.println("Available seats: " + availableSeats);
        System.out.println("Total available seats: " + availableSeats.size());
    }
    
    TicketNode getTicketById(int ticketId) {
        if (this.head == null) {
            return null;
        }
        
        TicketNode current = this.head;
        do {
            if (current.ticketId == ticketId) {
                return current;
            }
            current = current.next;
        } while (current != this.head);
        
        return null;
    }
    
    void displayTicketDetails(int ticketId) {
        TicketNode ticket = getTicketById(ticketId);
        if (ticket != null) {
            System.out.println("Ticket Details:");
            System.out.println("Ticket ID: " + ticket.ticketId);
            System.out.println("Customer Name: " + ticket.customerName);
            System.out.println("Movie Name: " + ticket.movieName);
            System.out.println("Seat Number: " + ticket.seatNumber);
            System.out.println("Booking Time: " + ticket.bookingTime);
        } else {
            System.out.println("Ticket with ID " + ticketId + " not found");
        }
    }
}

public class TicketReservation {
    public static void main(String[] args) {
        TicketReservationLinkedList reservationSystem = new TicketReservationLinkedList();
        int totalSeats = 50;
        
        System.out.println("=== Online Ticket Reservation System ===");
        System.out.println("Total seats in theater: " + totalSeats);
        
        System.out.println("\n--- Adding ticket reservations ---");
        reservationSystem.addTicket(1001, "Alice Johnson", "Inception", 15, "2024-01-15 14:30");
        reservationSystem.addTicket(1002, "Bob Smith", "The Dark Knight", 22, "2024-01-15 15:00");
        reservationSystem.addTicket(1003, "Charlie Brown", "Inception", 8, "2024-01-15 16:15");
        reservationSystem.addTicket(1004, "Diana Prince", "Wonder Woman", 33, "2024-01-15 17:00");
        reservationSystem.addTicket(1005, "Eve Wilson", "The Dark Knight", 45, "2024-01-15 18:30");
        
        System.out.println("\n--- Displaying all tickets ---");
        reservationSystem.displayAllTickets();
        
        System.out.println("\n--- Total booked tickets: " + reservationSystem.getTotalBookedTickets());
        
        System.out.println("\n--- Available seats ---");
        reservationSystem.displayAvailableSeats(totalSeats);
        
        System.out.println("\n--- Searching tickets by customer name 'Alice' ---");
        List<TicketNode> aliceTickets = reservationSystem.searchByCustomerName("Alice");
        for (TicketNode ticket : aliceTickets) {
            System.out.println("Found: Ticket " + ticket.ticketId + " for " + ticket.movieName);
        }
        
        System.out.println("\n--- Searching tickets by movie name 'Inception' ---");
        List<TicketNode> inceptionTickets = reservationSystem.searchByMovieName("Inception");
        for (TicketNode ticket : inceptionTickets) {
            System.out.println("Found: " + ticket.customerName + " - Seat " + ticket.seatNumber);
        }
        
        System.out.println("\n--- Displaying ticket details ---");
        reservationSystem.displayTicketDetails(1002);
        
        System.out.println("\n--- Checking seat availability ---");
        System.out.println("Is seat 15 available? " + reservationSystem.isSeatAvailable(15));
        System.out.println("Is seat 20 available? " + reservationSystem.isSeatAvailable(20));
        
        System.out.println("\n--- Removing ticket ---");
        reservationSystem.removeTicket(1003);
        System.out.println("Ticket 1003 removed");
        
        System.out.println("\n--- Updated ticket list ---");
        reservationSystem.displayAllTickets();
        
        System.out.println("\n--- Updated available seats ---");
        reservationSystem.displayAvailableSeats(totalSeats);
        
        System.out.println("\n--- Adding more tickets ---");
        reservationSystem.addTicket(1006, "Frank Miller", "Avengers", 20, "2024-01-15 19:00");
        reservationSystem.addTicket(1007, "Grace Lee", "Inception", 12, "2024-01-15 20:15");
        
        System.out.println("\n--- Final ticket list ---");
        reservationSystem.displayAllTickets();
        
        System.out.println("\n--- Final statistics ---");
        System.out.println("Total booked tickets: " + reservationSystem.getTotalBookedTickets());
        System.out.println("Total available seats: " + (totalSeats - reservationSystem.getTotalBookedTickets()));
        
        System.out.println("\n--- Searching for non-existent ticket ---");
        reservationSystem.displayTicketDetails(9999);
    }
} 