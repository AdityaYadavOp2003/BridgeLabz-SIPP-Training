package JavaClassAndObject.Level2;

class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    MovieTicket(String movieName) {
        this.movieName = movieName;
    }

    void bookTicket(String seat, double price) {
        this.seatNumber = seat;
        this.price = price;
    }

    void displayTicket() {
        System.out.println("Movie: " + movieName + ", Seat: " + seatNumber + ", Price: ₹" + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Interstellar");
        ticket.bookTicket("A12", 300);
        ticket.displayTicket();
    }
}
