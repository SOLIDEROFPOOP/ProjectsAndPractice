class Process {
    char name;
    int at, bt, ct, wt, tt;
    int complete;
    float ntt;
}

public class HRRN {

    static void sortByArrival(Process p[], int m) {
        Process temp;
        int i, j;

        for (i = 0; i < m - 1; i++) {
            for (j = i + 1; j < m; j++) {
                if (p[i].at > p[j].at) {
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int i, j, t, sum_bt = 0;
        char c;
        float avgwt = 0, avgtt = 0;
        int m = 5;

        int arriv[] = {1, 3, 5, 7, 8};
        int burst[] = {3, 7, 8, 4, 2};

        Process[] p = new Process[m];

        for (i = 0, c = 'A'; i < m; i++, c++) {
            p[i] = new Process();
            p[i].name = c;
            p[i].at = arriv[i];
            p[i].bt = burst[i];
            p[i].complete = 0;
            sum_bt += p[i].bt;
        }

        sortByArrival(p, m);
        System.out.println("\nName\tArrival Time\tBurst Time\tWaiting Time\tTurnAround Time\tNormalized TT");
        for (t = p[0].at; t < sum_bt; ) {
            float hrr = -9999;
            float temp;
            int loc = -1;
            for (i = 0; i < m; i++) {
                if (p[i].at <= t && p[i].complete != 1) {
                    temp = (p[i].bt + (t - p[i].at)) / (float) p[i].bt;
                    if (hrr < temp) {
                        hrr = temp;
                        loc = i;
                    }
                }
            }
            t += p[loc].bt;
            p[loc].wt = t - p[loc].at - p[loc].bt;
            p[loc].tt = t - p[loc].at;
            avgtt += p[loc].tt;
            p[loc].ntt = ((float) p[loc].tt / p[loc].bt);
            p[loc].complete = 1;
            avgwt += p[loc].wt;
            System.out.println(p[loc].name + "\t\t" + p[loc].at + "\t\t" + p[loc].bt + "\t\t" + p[loc].wt + "\t\t" + p[loc].tt + "\t\t" + p[loc].ntt);
        }
        System.out.println("The Average waiting time: " + (avgwt / m));
        System.out.println("The Average Turn Around time: " + (avgtt / m));
    }
}
