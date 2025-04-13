import java.util.Scanner;
class User {
    private String username;
    private String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername()
     {
         return username;
     }
    public String getPassword() {
         return password; 
        }
}
class Reservation {
    private int pnr;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String from;
    private String to;
    private String date;
    public Reservation(int pnr, String trainNumber, String trainName, String classType, String from, String to, String date) {
        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.from = from;
        this.to = to;
        this.date = date;
    }
    public int getPnr() { return pnr; }
    public String getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getClassType() { return classType; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getDate() { return date; }
}
class UserDAO {
    public boolean login(User user) {
        return true;
    }
}
class ReservationDAO {
    public void makeReservation(Reservation reservation) {
        System.out.println("Reservation made successfully!");
    }

    public void cancelReservation(int pnr) {
        System.out.println("Reservation cancelled successfully!");
    }
}
public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        ReservationDAO reservationDAO = new ReservationDAO();

        System.out.println("Welcome to Online Reservation System");
        System.out.print("Enter username: ");
        String username = scan.nextLine();
        System.out.print("Enter password: ");
        String password = scan.nextLine();
        User user = new User(username, password);

        if (userDAO.login(user)) {
            System.out.println("Login successful!");
            System.out.println("1. Make Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.print("Choose an option: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter PNR: ");
                    int pnr = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Train Number: ");
                    String trainNumber = scan.nextLine();
                    System.out.print("Enter Train Name: ");
                    String trainName = scan.nextLine();
                    System.out.print("Enter Class Type: ");
                    String classType = scan.nextLine();
                    System.out.print("From: ");
                    String from = scan.nextLine();
                    System.out.print("To: ");
                    String to = scan.nextLine();
                    System.out.print("Date of Journey: ");
                    String date = scan.nextLine();
                    Reservation reservation = new Reservation(pnr, trainNumber, trainName, classType, from, to, date);
                    reservationDAO.makeReservation(reservation);
                    break;
                case 2:
                    System.out.print("Enter PNR to cancel: ");
                    int cancelPnr = scan.nextInt();
                    reservationDAO.cancelReservation(cancelPnr);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Invalid credentials!");
        }
        scan.close();
    }
}
