
public class Seat {
    private final int price;
    private boolean isBooked;

    Seat (int price) {
        this.price = price;
        isBooked = false;
    }

    void setBooked() { isBooked = true; }

    int getPrice() { return price; }

    String show() {
        if (isBooked) {
            return "B ";
        } else {
            return "S ";
        }
    }
}
