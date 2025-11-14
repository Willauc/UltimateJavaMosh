package MultiThreadingTuto;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;


public class FlightService {

    private void sleep() {
        long sleepTime = ThreadLocalRandom.current().nextLong(1000, 5001);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting quote from " + site);
            sleep();

            int quote = ThreadLocalRandom.current().nextInt(100, 201);

            return new Quote(site, quote);
        });
    }

    public Stream<CompletableFuture<Quote>> getQuotes() {
        var sites = List.of("site1", "site2", "site3");

        return sites.stream().map(this::getQuote);
    }
}
