package MultiThreadingTuto;

import java.util.concurrent.CompletableFuture;

public class MainMultiThreading {
    public static void main(String[] args)  {

        GetQuote.getQuoteAsync("site1");
        GetQuote.getQuoteAsync("site2");
        GetQuote.getQuoteAsync("site3");

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}