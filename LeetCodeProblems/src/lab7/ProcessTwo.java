package lab7;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class ProcessTwo {
    public static void main(String[] args) {
        String fileName = "random_numbers.txt";

        Semaphore semaphore = new Semaphore(999);

        final long[] lastSize = {0};
        Thread readerThread = new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    long currentSize = Files.size(Paths.get(fileName));

                    if (currentSize > lastSize[0]) {
                        try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
                            file.seek(lastSize[0]);
                            String line;
                            while ((line = file.readLine()) != null) {
                                System.out.println(line);
                            }


                            lastSize[0] = currentSize;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        readerThread.start();

        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
