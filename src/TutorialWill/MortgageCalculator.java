package TutorialWill;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    public static void calculate() {
         Scanner input = new Scanner(System.in);

         System.out.print("Enter Your Mortgage total: ");
         Double mortgage = input.nextDouble();

         System.out.print("Enter Your Annual interest rate: ");
         Double rate = input.nextDouble();
         rate = rate / 100 / 26;

         System.out.print("How long do you plant to pay: ");
         int howLong = input.nextInt();
         howLong  = howLong * 26;

         Double payment = mortgage * ((rate * Math.pow((1+rate),howLong)) /
                                        (Math.pow((1+rate), howLong) - 1));

         String paymentFormater = NumberFormat.getCurrencyInstance(Locale.CANADA).format(payment);

         System.out.println("Your payment is " + paymentFormater + " every two weeks.");
    }
}