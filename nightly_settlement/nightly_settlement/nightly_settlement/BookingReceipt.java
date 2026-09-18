package nightly_settlement;

import java.util.Arrays;

public class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        if (seatNumbers != null) {
            this.seatNumbers = Arrays.copyOf(seatNumbers, seatNumbers.length);
        } else {
            this.seatNumbers = new String[0];
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        return Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        if (index < 0 || index >= this.seatNumbers.length) {
            throw new IndexOutOfBoundsException("Invalid seat index: " + index);
        }
        String[] updatedSeats = Arrays.copyOf(this.seatNumbers, this.seatNumbers.length);
        updatedSeats[index] = newSeat;
        return new BookingReceipt(this.bookingId, updatedSeats);
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processedCount = 0;
        int nullCount = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (receipts != null) {
            for (BookingReceipt receipt : receipts) {
                if (receipt == null) {
                    nullCount++;
                } else {
                    processedCount++;
                    if (receipt instanceof GroupBookingReceipt) {
                        groupCount++;
                    } else {
                        individualCount++;
                    }
                }
            }
        }

        return processedCount + " processed | " + nullCount + " null skipped\n"
                + groupCount + " group | " + individualCount + " individual";
    }
}