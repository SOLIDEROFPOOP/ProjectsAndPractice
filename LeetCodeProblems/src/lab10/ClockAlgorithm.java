package lab10;

import java.util.HashSet;
import java.util.Set;

public class ClockAlgorithm {
    public static void main(String[] args) {
        int[] pageReferences = {1 , 2 , 3 , 2 , 6 , 3 , 4  , 1 , 5 , 6 , 1 , 6 , 4 , 2};
        int numFrames = 3;

        int pageFaults = clock(pageReferences, numFrames);
        int hits = pageReferences.length - pageFaults;

        System.out.println("Total page faults using Clock: " + pageFaults);
        System.out.println("Total hits using Clock: " + hits);
    }

    public static int clock(int[] pageReferences, int numFrames) {
        int[] frames = new int[numFrames];
        boolean[] referenced = new boolean[numFrames];
        int hand = 0;
        int pageFaults = 0;

        for (int page : pageReferences) {
            boolean found = false;
            for (int i = 0; i < numFrames; i++) {
                if (frames[i] == page) {
                    referenced[i] = true;
                    found = true;
                    break;
                }
            }

            if (!found) {
                while (referenced[hand]) {
                    referenced[hand] = false;
                    hand = (hand + 1) % numFrames;
                }

                frames[hand] = page;
                referenced[hand] = true;
                hand = (hand + 1) % numFrames;
                pageFaults++;
            }
        }

        return pageFaults;
    }
}
