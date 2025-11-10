package MultiThreadingTuto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class GetQuote {
    static void getQuote(String site) {
        long sleepTime = ThreadLocalRandom.current().nextLong(1000, 5001);
        System.out.println("Getting quote from " + site);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long quote = ThreadLocalRandom.current().nextLong(100, 201);

        System.out.println("Quote{site = '" + site + "', price=" + quote + "}");
    }
    static CompletableFuture<Void> getQuoteAsync(String site) {
        return CompletableFuture.runAsync(() -> getQuote(site));
    }
}
