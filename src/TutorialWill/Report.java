package TutorialWill;

import java.text.NumberFormat;
import java.util.Locale;

public class Report {
    private final byte numberOfPaymentYear = 26;
    private Calculator calculator;


    public Report(Calculator calculator) {
        this.calculator = calculator;
    }


    public void getPayment() {
        System.out.println("MORTGAGE");
        System.out.println("____________________");
        System.out.println("Biweekly payment: " + calculator.calculatePayment());
    }

    public void getPaymentSchedule() {

        int numberOfPayment = calculator.getTerm() * numberOfPaymentYear;

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("_____________________________");

        for (int i = 1; i <= (calculator.getTerm() * numberOfPaymentYear); i++) {
            float balance = (float) (calculator.getMortgage() *
                    (Math.pow((1 + calculator.getBiweeklyRate()), (numberOfPayment)) - Math.pow((1 + calculator.getBiweeklyRate()), i)) /
                    (Math.pow((1 + calculator.getBiweeklyRate()), (numberOfPayment)) - 1));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.CANADA).format(balance));
        }
    }
}
