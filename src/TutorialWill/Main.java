package TutorialWill;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var report = new Report();
        while (true) {
            System.out.println("___Mortgage calculator___");
            System.out.println("");
            System.out.println("Plese select a option:");
            System.out.println("");
            System.out.println("1. Calculate payment");
            System.out.println("2. Get payment schedule");
            System.out.println("3. Try different payment");
            System.out.println("4. Modified mortgage total");
            System.out.println("5. Modified rate");
            System.out.println("6. Modified term");
            System.out.println("7. Exit");
            System.out.println("");

            double choice = Console.readNumber("Selection : ", 1, 8);

            if (choice == 1) {
                report.getPayment();
            }else if (choice == 2) {
                report.getPaymentSchedule();
            }else if (choice == 3) {
                report.getTimeToPay();
            }else if (choice == 4) {
                continue;
            }else if (choice == 5) {
                continue;
            }else if (choice == 6) {
                continue;
            }else if (choice == 7) {
                break;
            }

        }



    }
}
