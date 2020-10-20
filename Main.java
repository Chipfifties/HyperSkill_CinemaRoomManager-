import java.util.Scanner;

public class Cinema {
    private static final Scanner sc = new Scanner(System.in);
    private static Seat[][] cinema;
    private static int rows;
    private static int seats;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        rows = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the number of seats in each row:");
        seats = Integer.parseInt(sc.nextLine());

        cinema = new Seat[rows][seats];
        setPrices();
        printMenu();

    }

    private static void printMenu() {
        while (true) {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");

            switch (sc.nextLine()) {
                case "1":
                    printCinema();
                    break;
                case "2":
                    buySeat();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Try again.");
                    break;
            }
        }
    }

    private static void buySeat() {
        System.out.println("\nEnter a row number:");
        int row = Integer.parseInt(sc.nextLine());
        System.out.println("Enter a seat number in that row:");
        int seat = Integer.parseInt(sc.nextLine());
        cinema[row - 1][seat - 1].setBooked();
        System.out.printf("\nTicket price: $%d\n", cinema[row - 1][seat - 1].getPrice());
    }

    private static void setPrices() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (i <= rows / 2 - 1) {
                    cinema[i][j] = new Seat(10);
                } else if (rows * seats <= 60) {
                    cinema[i][j] = new Seat(10);
                } else {
                    cinema[i][j] = new Seat(8);
                }
            }
        }
    }

    private static void printCinema() {
        int rowCounter = 0;
        int seatCounter = 0;
        System.out.println("\nCinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else if (i == 0) {
                    System.out.print(++seatCounter + " ");
                } else if (j == 0) {
                    System.out.print(++rowCounter + " ");
                } else {
                    System.out.print(cinema[i - 1][j - 1].show());
                }
            }
            System.out.println();
        }
    }
}
