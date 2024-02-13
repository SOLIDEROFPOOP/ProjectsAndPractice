import java.util.ArrayList;
import java.util.List;

enum ProcessState {
    READ_FROM,
    WRITE_FROM,
    READ_COMPLETE,
    WRITE_COMPLETE,
    SWAPPED_OUT,
    SWAPPED_IN,
    EXPIRED,
    TERMINATE
}

class Process {
    String name;
    ProcessState state;

    Process(String name) {
        this.name = name;
        this.state = null; // No need to set initial state here
    }

    void setState(ProcessState state) {
        this.state = state;
    }
}

public class ProcessStateSimulation {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();

        Process p1 = new Process("P1");
        Process p3 = new Process("P3");
        Process p5 = new Process("P5");
        Process p7 = new Process("P7");
        Process p8 = new Process("P8");

        processes.add(p1);
        processes.add(p3);
        processes.add(p5);
        processes.add(p7);
        processes.add(p8);

        List<Event> events = new ArrayList<>();
        events.add(new Event(5, () -> readDiskUnit3_P1(p1)));
        events.add(new Event(15, () -> timeSliceExpire_P5(p5)));
        events.add(new Event(18, () -> writeDiskUnit3_P7(p7)));
        events.add(new Event(20, () -> readDiskUnit2_P3(p3)));
        events.add(new Event(24, () -> writeDiskUnit3_P5(p5)));
        events.add(new Event(28, () -> swapOut_P5(p5)));
        events.add(new Event(33, () -> readComplateUnit3_P1(p1)));
        events.add(new Event(36, () -> readComplateUnit3_P3(p3)));
        events.add(new Event(38, () -> terminate_P8(p8)));
        events.add(new Event(40, () -> writeComplateUnit3_P5(p5)));
        events.add(new Event(44, () -> swapIn_P5(p5)));
        events.add(new Event(48, () -> writeComlateUnit3_P7(p7)));

        for (Event event : events) {
            System.out.println("Time: " + event.time);
            event.action.run();
            printProcessStates(processes);
            System.out.println("---------------------------");
        }
    }

    static void readDiskUnit3_P1(Process p1) {
        p1.setState(ProcessState.READ_FROM);
    }

    static void timeSliceExpire_P5(Process p5) {
        p5.setState(ProcessState.EXPIRED);
    }

    static void writeDiskUnit3_P7(Process p7) {
        p7.setState(ProcessState.WRITE_FROM);
    }

    static void readDiskUnit2_P3(Process p3) {
        p3.setState(ProcessState.READ_FROM);
    }

    static void writeDiskUnit3_P5(Process p5) {
        p5.setState(ProcessState.WRITE_COMPLETE);
    }

    static void swapOut_P5(Process p5) {
        p5.setState(ProcessState.SWAPPED_OUT);
    }

    static void readComplateUnit3_P1(Process p1) {
        p1.setState(ProcessState.READ_COMPLETE);
    }

    static void readComplateUnit3_P3(Process p3) {
        p3.setState(ProcessState.READ_COMPLETE);
    }

    static void terminate_P8(Process p8) {
        p8.setState(ProcessState.TERMINATE);
    }

    static void writeComplateUnit3_P5(Process p5) {
        p5.setState(ProcessState.WRITE_FROM);
    }

    static void swapIn_P5(Process p5) {
        p5.setState(ProcessState.SWAPPED_IN);
    }

    static void writeComlateUnit3_P7(Process p7) {
        p7.setState(ProcessState.WRITE_COMPLETE);
    }

    static void printProcessStates(List<Process> processes) {
        for (Process process : processes) {
            System.out.println(process.name + ": " + process.state);
        }
    }
}

class Event {
    int time;
    Runnable action;

    Event(int time, Runnable action) {
        this.time = time;
        this.action = action;
    }
}
