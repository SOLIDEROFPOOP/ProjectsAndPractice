import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0, high = Arrays.stream(piles).max().getAsInt();
        while (low <= high){
            int middle = low + (high - low) / 2;
            if (canEat(piles, middle,h)) high = middle - 1;
            else low = middle + 1;
        }
        return low;
    }
    public boolean canEat(int[] piles , int speed, int h){
        int hours = 0;
        for (int pile : piles){
            if (speed > 0) {
                hours += (pile + speed - 1) / speed;
            } else {
                // Handle the case where speed is 0
                return false;
            }
        }
        return hours <= h;
    }
}
