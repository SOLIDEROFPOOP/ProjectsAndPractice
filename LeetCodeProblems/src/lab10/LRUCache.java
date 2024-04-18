package lab10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LRUCache {
    public static void main(String[] args) {
        int[] pageReferences = {1 , 2 , 3 , 2 , 6 , 3 , 4  , 1 , 5 , 6 , 1 , 6 , 4 , 2};
        int numFrames = 4;

        int pageFaults = lru(pageReferences, numFrames);
        int hits = pageReferences.length - pageFaults;

        System.out.println("Total page faults using Pure LRU: " + pageFaults);
        System.out.println("Total hits using Pure LRU: " + hits);
    }

    public static int lru(int[] pageReferences, int numFrames) {
        Deque<Integer> lruQueue = new ArrayDeque<>();
        Set<Integer> frameSet = new HashSet<>();
        int pageFaults = 0;

        for (int page : pageReferences) {
            if (!frameSet.contains(page)) {
                System.out.println("fault at:" + page);
                pageFaults++;
                if (lruQueue.size() == numFrames) {
                    int removedPage = lruQueue.pollFirst();
                    frameSet.remove(removedPage);
                }
                lruQueue.offerLast(page);
                frameSet.add(page);
            } else {
                lruQueue.remove(page);
                lruQueue.offerLast(page);
            }
        }

        return pageFaults;
    }
}
