package lab10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class FIFOAlgorithm {
    public static void main(String[] args) {

        int[] pageReferences = {1 , 2 , 3 , 2 , 6 , 3 , 4  , 1 , 5 , 6 , 1 , 6 , 4 , 2};
        int numFrames = 4;


        int pageFaults = fifo(pageReferences, numFrames);


        System.out.println("Total page faults using FIFO: " + pageFaults);
    }

    public static int fifo(int[] pageReferences, int numFrames) {

        Deque<Integer> fifoQueue = new ArrayDeque<>();
        Set<Integer> frameSet = new HashSet<>();
        int pageFaults = 0;


        for (int page : pageReferences) {
            if (!frameSet.contains(page)) {
                pageFaults++;
                if (fifoQueue.size() == numFrames) {
                    int removedPage = fifoQueue.poll();
                    frameSet.remove(removedPage);
                }
                fifoQueue.offer(page);
                frameSet.add(page);
            }
        }

        return pageFaults;
    }
}

