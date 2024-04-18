import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] days = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                days[index] = i - index;
            }
            stack.push(i);
        }

        return days;
    }

}
