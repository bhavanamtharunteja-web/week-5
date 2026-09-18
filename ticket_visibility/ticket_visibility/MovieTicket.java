package ticket_visibility;

public class MovieTicket {
    // Sensitive seat assignment: accessible only through validated accessors
    private String seatNumber;

    // Screening details: accessible to management within the package
    String screenId;

    // Pricing: accessible within package and to subclasses
    protected double ticketPrice;

    // General movie info: open access
    public String movieTitle;

    public MovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}