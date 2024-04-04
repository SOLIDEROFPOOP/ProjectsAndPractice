import java.util.*;

class   MemoryAllocation {
    static class Hole {
        int size;
        boolean allocated;

        Hole(int size) {
            this.size = size;
            allocated = false;
        }
    }

    static void firstFit(int[] processes, List<Hole> holes) {
        for (int processSize : processes) {
            boolean allocated = false;
            for (Hole hole : holes) {
                if (!hole.allocated && hole.size >= processSize) {
                    hole.allocated = true;
                    allocated = true;
                    System.out.println("Allocated process of size " + processSize + " using First-fit.");
                    break;
                }
            }
            if (!allocated) {
                System.out.println("Could not allocate process of size " + processSize + " using First-fit.");
            }
        }
    }

    static void bestFit(int[] processes, List<Hole> holes) {
        for (int processSize : processes) {
            boolean allocated = false;
            int minSize = Integer.MAX_VALUE;
            Hole bestHole = null;
            for (Hole hole : holes) {
                if (!hole.allocated && hole.size >= processSize && hole.size < minSize) {
                    minSize = hole.size;
                    bestHole = hole;
                }
            }
            if (bestHole != null) {
                bestHole.allocated = true;
                allocated = true;
                System.out.println("Allocated process of size " + processSize + " using Best-fit.");
            }
            if (!allocated) {
                System.out.println("Could not allocate process of size " + processSize + " using Best-fit.");
            }
        }
    }

    static void worstFit(int[] processes, List<Hole> holes) {
        for (int processSize : processes) {
            boolean allocated = false;
            int maxSize = Integer.MIN_VALUE;
            Hole worstHole = null;
            for (Hole hole : holes) {
                if (!hole.allocated && hole.size >= processSize && hole.size > maxSize) {
                    maxSize = hole.size;
                    worstHole = hole;
                }
            }
            if (worstHole != null) {
                worstHole.allocated = true;
                allocated = true;
                System.out.println("Allocated process of size " + processSize + " using Worst-fit.");
            }
            if (!allocated) {
                System.out.println("Could not allocate process of size " + processSize + " using Worst-fit.");
            }
        }
    }

    public static void main(String[] args) {
        List<Hole> holes = new ArrayList<>();
        holes.add(new Hole(50000));
        holes.add(new Hole(30000));
        holes.add(new Hole(200000));
        holes.add(new Hole(16000));
        holes.add(new Hole(30000));

        int[] processes = {50000, 30000, 200000, 16000, 30000};

        System.out.println("First-fit Allocation:");
        firstFit(processes, holes);

        System.out.println("\nBest-fit Allocation:");
        bestFit(processes, holes);

        System.out.println("\nWorst-fit Allocation:");
        worstFit(processes, holes);
    }
}
