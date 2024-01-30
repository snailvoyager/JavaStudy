package thread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelApiCalls {
    public static void main(String[] args) {
        callApiAsync();
        System.out.println(getReturnValueAsync());
    }

    public static void callApiAsync() {
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

    public static List<String> getReturnValueAsync() {
        long startTime = System.currentTimeMillis();

        List<Integer> dataList = createDataList(800);
        List<List<Integer>> chunks = chunkData(dataList, 100);

        ExecutorService executor = Executors.newFixedThreadPool(16);

        //비동기로 API를 호출해서 List를 리턴
        List<CompletableFuture<List<String>>> futures = chunks.stream()
                .map(data -> CompletableFuture.supplyAsync(() -> processApiReturnValue(data), executor))
                .toList();

        //모든 CompletableFuture가 완료될 때까지 기다린 후 실행 결과를 반환
        //allOf는 모든 작업이 완료될 때까지 기다리는 CompletableFuture를 반환, 모든 CompletableFuture를 조합하여 결과를 수집
        //allOf가 반환하는 CompletableFuture에 join을 호출하면 원래 스트림의 모든 CompletableFuture의 실행 완료를 기다릴 수 있다
        CompletableFuture<List<String>> combinedFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .flatMap(List::stream)
                        .toList());
        try {
            return combinedFutures.get().stream().toList();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime + "ms");
        }
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

    private static List<String> processApiReturnValue(List<Integer> request) {
        try {
            System.out.println("API return...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return request.stream().map(i -> i + "").collect(Collectors.toList());
    }
}
