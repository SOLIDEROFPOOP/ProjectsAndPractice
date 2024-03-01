import java.util.*;

class ProcessFCFS {
    private String name;
    private int arrivalTime;
    private int executionTime;

    public ProcessFCFS(String name, int arrivalTime, int executionTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
    }

    public String getName() {
        return name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }
}

public class FCFS {
    public static void main(String[] args) {
        List<ProcessFCFS> processes = new ArrayList<>();
        processes.add(new ProcessFCFS("P1", 0, 8));
        processes.add(new ProcessFCFS("P2", 1, 4));
        processes.add(new ProcessFCFS("P3", 2, 6));
        processes.add(new ProcessFCFS("P4", 3, 3));

        executeProcesses(processes);
    }

    public static void executeProcesses(List<ProcessFCFS> processes) {
        System.out.println("Execution order:");

        int currentTime = 0;
        for (ProcessFCFS process : processes) {
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
            }
            System.out.println(process.getName());
            currentTime += process.getExecutionTime();
        }
    }
}
