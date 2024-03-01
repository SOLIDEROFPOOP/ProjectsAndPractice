import java.util.*;

class Process {
    private String name;
    private int arrivalTime;
    private int burstTime;
    private int remainingTime;

    public Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }

    public String getName() {
        return name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}

public class SRT {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 8));
        processes.add(new Process("P2", 1, 4));
        processes.add(new Process("P3", 2, 6));
        processes.add(new Process("P4", 3, 3));

        executeProcesses(processes);
    }

    public static void executeProcesses(List<Process> processes) {
        System.out.println("Execution order:");

        int currentTime = 0;
        int completedProcesses = 0;
        PriorityQueue<Process> readyQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getRemainingTime).thenComparing(Process::getArrivalTime));

        while (completedProcesses < processes.size()) {
            // Add arriving processes to the ready queue
            for (Process process : processes) {
                if (process.getArrivalTime() <= currentTime && !readyQueue.contains(process)) {
                    readyQueue.offer(process);
                }
            }

            // Select process with shortest remaining time
            Process currentProcess = readyQueue.poll();
            if (currentProcess != null) {
                System.out.println("Executing " + currentProcess.getName() + " at time " + currentTime);
                int remainingTime = currentProcess.getRemainingTime() - 1;

                if (remainingTime == 0) {
                    completedProcesses++;
                } else {
                    currentProcess.setRemainingTime(remainingTime);
                    readyQueue.offer(currentProcess);
                }

                currentTime++;
            } else {
                currentTime++; // No process to execute, move to the next time unit
            }
        }
    }
}
