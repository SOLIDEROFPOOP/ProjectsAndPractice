package lab10;

import java.util.HashMap;
import java.util.Map;

public class OptimalAlgorithm {
    public static void main(String[] args) {
        int[] pageReferences = {0 , 1 , 7 , 0 , 1 , 2 , 0 , 1 , 2 , 3 , 2 , 7 , 1 , 0 , 3 , 1 , 0 , 3};
        int numFrames = 3;

        int pageFaults = optimal(pageReferences, numFrames);
        int hits = pageReferences.length - pageFaults;

        System.out.println("Total page faults using OPT: " + pageFaults);
        System.out.println("Total hits using OPT: " + hits);
    }

    public static int optimal(int[] pageReferences, int numFrames) {
        Map<Integer, Integer> futureOccurrences = new HashMap<>();
        for (int i = 0; i < pageReferences.length; i++) {
            futureOccurrences.put(pageReferences[i], i);
        }

        int[] frames = new int[numFrames];
        int pageFaults = 0;

        for (int i = 0; i < pageReferences.length; i++) {
            if (!contains(frames, pageReferences[i])) {
                int idx = findOptimalVictim(frames, futureOccurrences, pageReferences, i);
                frames[idx] = pageReferences[i];
                pageFaults++;
            }
        }

        return pageFaults;
    }

    public static boolean contains(int[] frames, int page) {
        for (int i : frames) {
            if (i == page) {
                return true;
            }
        }
        return false;
    }

    public static int findOptimalVictim(int[] frames, Map<Integer, Integer> futureOccurrences, int[] pageReferences, int currentIndex) {
        int victimIdx = -1;
        int farthestOccurrence = -1;
        for (int i = 0; i < frames.length; i++) {
            int page = frames[i];
            if (!futureOccurrences.containsKey(page)) {
                return i;
            } else {
                int nextOccurrence = futureOccurrences.get(page);
                if (nextOccurrence > farthestOccurrence) {
                    farthestOccurrence = nextOccurrence;
                    victimIdx = i;
                }
            }
        }
        return victimIdx;
    }
}
