class GFG {
    // Method to allocate memory to
    // blocks as per First fit algorithm
    static void firstFit(int blockSize[], int m,
                         int processSize[], int n) {
        // Stores block id allocated to each process
        int allocation[] = new int[n];

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // Pick each process and find suitable blocks
        // according to its size and assign to it
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    // Allocate block j to process i
                    allocation[i] = j;

                    // Reduce available memory in this block.
                    blockSize[j] -= processSize[i];

                    break;
                }
            }
        }

        // Print allocation details
        System.out.println("\nFirst-Fit Allocation:");
        System.out.println("Process No.\tProcess Size\tBlock size");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1) + "\t\t" +
                    processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(blockSize[allocation[i]]);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }

    // Method to allocate memory to
    // blocks as per Worst fit algorithm
    static void worstFit(int blockSize[], int m,
                         int processSize[], int n) {
        // Stores block id allocated to each process
        int allocation[] = new int[n];

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // Pick each process and find the largest suitable block
        // according to its size and assign to it
        for (int i = 0; i < n; i++) {
            int worstFitIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (worstFitIdx == -1 || blockSize[j] > blockSize[worstFitIdx]) {
                        worstFitIdx = j;
                    }
                }
            }

            // If a suitable block is found
            if (worstFitIdx != -1) {
                // Allocate block to process i
                allocation[i] = worstFitIdx;

                // Reduce available memory in this block.
                blockSize[worstFitIdx] -= processSize[i];
            }
        }

        // Print allocation details
        System.out.println("\nWorst-Fit Allocation:");
        System.out.println("Process No.\tProcess Size\tBlock size");
        for (int i = 0; i < n; i++) {
            System.out.print("   " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(blockSize[allocation[i]]);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }

    // Method to allocate memory to
    // blocks as per Best fit algorithm
    static void bestFit(int blockSize[], int m,
                        int processSize[], int n) {
        // Stores block id allocated to each process
        int allocation[] = new int[n];

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // Pick each process and find the smallest suitable block
        // according to its size and assign to it
        for (int i = 0; i < n; i++) {
            int bestFitIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestFitIdx == -1 || blockSize[j] < blockSize[bestFitIdx]) {
                        bestFitIdx = j;
                    }
                }
            }

            // If a suitable block is found
            if (bestFitIdx != -1) {
                // Allocate block to process i
                allocation[i] = bestFitIdx;

                // Reduce available memory in this block.
                blockSize[bestFitIdx] -= processSize[i];
            }
        }

        // Print allocation details
        System.out.println("\nBest-Fit Allocation:");
        System.out.println("Process No.\tProcess Size\tBlock size");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1) + "\t\t" +
                    processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(blockSize[allocation[i]]);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int blockSize[] = {100, 500, 200, 300, 600};
        int processSize[] = {212, 417, 112, 426};
        int m = blockSize.length;
        int n = processSize.length;

        firstFit(blockSize, m, processSize, n);
        worstFit(blockSize, m, processSize, n);
        bestFit(blockSize, m , processSize, n);
    }
}
