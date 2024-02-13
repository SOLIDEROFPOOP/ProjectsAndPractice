import java.util.ArrayList;
import java.util.Arrays;

public class CodeWars {
    public static int repeats(int [] arr){
        int sum = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        for (int a : arr){
            if (nums.stream().anyMatch(value -> value == a)){
                sum -= a;
            }
            else {
                sum += a;
                nums.add(a);
            }
        }
        return sum;
    }
}