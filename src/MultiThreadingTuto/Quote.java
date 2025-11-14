package MultiThreadingTuto;

public class Quote {
    private final String quote;
    private final int price;

    public Quote(String quote, int price) {
        this.quote = quote;
        this.price = price;
    }

    public String getQuote() {
        return quote;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                ", price=" + price +
                '}';
    }
}
