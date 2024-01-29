package thread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelApiCalls {
    public static void main(String[] args) {
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());

        long startTime = System.currentTimeMillis();

        // Sample data
        List<Integer> dataList = createDataList(800);

        // Split the data into chunks of 100 items each
        List<List<Integer>> chunks = chunkData(dataList, 100);

        // Create an ExecutorService with a fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(16);

        // Process each chunk in parallel
        List<CompletableFuture<Void>> futures = chunks.stream()
                .map(chunk -> processChunkAsync(chunk, executor))
                .toList();

        // Combine all CompletableFuture instances into a single CompletableFuture
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        // Wait for all API calls to complete
        allOf.join();
        // Shutdown the ExecutorService
        executor.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");
    }

    private static List<Integer> createDataList(int size) {
        return IntStream.range(1, size + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<List<Integer>> chunkData(List<Integer> data, int chunkSize) {
        return IntStream.range(0, data.size())
                .boxed()
                .collect(Collectors.groupingBy(index -> index / chunkSize))
                .values()
                .stream()
                .map(indices -> indices.stream().map(data::get).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static CompletableFuture<Void> processChunkAsync(List<Integer> chunk, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("API call...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executor);
    }
}
