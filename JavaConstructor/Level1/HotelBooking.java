package JavaConstructor.Level1;

public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    public HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking booking) {
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.nights = booking.nights;
    }

    public void displayBooking() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }

    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking("Neffex", "Deluxe", 3);
        HotelBooking b2 = new HotelBooking(b1);
        b1.displayBooking();
        b2.displayBooking();
    }
}

