package TutorialWill;

import java.text.NumberFormat;
import java.util.Locale;

public class Calculator {
    private static final byte numberOfPaymentYear = 26;
    private static final byte percent = 100;
    private float mortgage;
    private float rate;
    private int term;
    private float biWeeklyRate;

    public Calculator(float mortgage, float rate, int term) {
        this.mortgage = mortgage;
        this.rate = rate;
        this.term = term;
        this.biWeeklyRate = rate / percent / numberOfPaymentYear;
    }

    public float getBiweeklyRate() {
        return biWeeklyRate;
    }

    public float getMortgage() {
        return mortgage;
    }

    public float getRate() {
        return rate;
    }

    public int getTerm() {
        return term;
    }

    public String calculatePayment() {
        float weeklyRate = rate / percent / numberOfPaymentYear;
        int termTotal = term * numberOfPaymentYear;

        Double payment = mortgage * ((weeklyRate * Math.pow((1 + weeklyRate), termTotal)) /
                (Math.pow((1 + weeklyRate), termTotal) - 1));

        return NumberFormat.getCurrencyInstance(Locale.CANADA).format(payment);
    }


    public void calculateRest() {

        while (true) {
            double payment = Console.readNumber("Enter your biweekly payment amount: ");

            if (payment <= mortgage * biWeeklyRate) {
                System.out.println("Error: payment too small to cover interest.");
                continue;
            }

            // Formule pour trouver le nombre de paiements restants :
            // n = ln(M / (M - P*r)) / ln(1 + r)
            double n = Math.log(payment / (payment - mortgage * biWeeklyRate)) / Math.log(1 + biWeeklyRate);

            double years = n / numberOfPaymentYear;

            System.out.printf("You have approximately %.0f payments left (%.1f years).%n", n, years);
        }
    }

}
