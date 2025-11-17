package TutorialWill;

import java.text.NumberFormat;
import java.util.Locale;

public class Report {
    final private Calculator calculator;


    public Report() {
        float mortgage = (float) Console.readNumber("Enter Your Mortgage total: ", 100_000, 2_000_000);
        float rate = (float) Console.readNumber("Enter Your Annual interest rate: ", 0, 10);
        int term = (int) Console.readNumber("How long do you plant to pay : ", 5, 30);

        this.calculator = new Calculator(mortgage, rate, term);
    }


    public void getPayment() {
        System.out.println("MORTGAGE");
        System.out.println("____________________");
        System.out.println("Biweekly payment: " + calculator.calculatePayment());
    }

    public void getPaymentSchedule() {

        int numberOfPayment = calculator.getTotalNumberPayment();

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("_____________________________");

        for (int i = 1; i <= (numberOfPayment); i++) {
            float balance = (float) (calculator.getMortgage() * (Math.pow((1 + calculator.getBiweeklyRate()), (numberOfPayment)) - Math.pow((1 + calculator.getBiweeklyRate()), i)) / (Math.pow((1 + calculator.getBiweeklyRate()), (numberOfPayment)) - 1));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.CANADA).format(balance));
        }
    }

    public void getTimeToPay() {
        while (true) {
            double payment = Console.readNumber("Enter your biweekly payment amount (-1 to quit): ");

            if (payment == -1) break;
            if (payment <= calculator.getMortgage() * calculator.getBiweeklyRate()) {
                System.out.println("Error: payment too small to cover interest.");
                continue;
            }
            calculator.calculateRest(payment);
        }
    }

    public void setMortgage() {
        float mortgage = (float) Console.readNumber("Enter Your Mortgage total: ", 100_000, 2_000_000);
        calculator.setMortgage(mortgage);
    }

    public void setRate() {
        float rate = (float) Console.readNumber("Enter Your Annual interest rate: ", 0, 10);
        calculator.setRate(rate);
    }

    public void setTerm() {
        int term = (int) Console.readNumber("How long do you plant to pay : ", 5, 30);
        calculator.setTerm(term);
    }

    @Override
    public String toString() {
        return "Mortgage: " + calculator.getMortgage()
                + " Rate: " + calculator.getRate()
                + " Term: " + calculator.getTerm();
    }
}
