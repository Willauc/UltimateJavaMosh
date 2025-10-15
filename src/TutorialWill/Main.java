package TutorialWill;



public class Main {
    public static void main(String[] args) {
        float mortgage = (float) Console.readNumber("Enter Your Mortgage total: ", 100_000, 2_000_000);
        float rate = (float) Console.readNumber("Enter Your Annual interest rate: ", 0, 10);
        int term = (int) Console.readNumber("How long do you plant to pay : ", 5, 30);

        var calculator = new Calculator(mortgage, rate, term);

        var report = new Report(calculator);

        report.getPayment();
        report.getPaymentSchedule();
        calculator.calculateRest();
    }
}
