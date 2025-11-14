package MultiThreadingTuto;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MainMultiThreading {
    public static void main(String[] args)  {
/*
        GetQuote.getQuoteAsync("site1");
        GetQuote.getQuoteAsync("site2");
        GetQuote.getQuoteAsync("site3");*/

        var service = new FlightService();

        service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}