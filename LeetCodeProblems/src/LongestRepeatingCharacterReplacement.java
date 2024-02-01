import java.util.HashMap;
import java.util.HashSet;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, maxFreq = 0, max = 0;
        HashMap<Character, Integer> charFreq = new HashMap<>();
        while (end < s.length()){
            char ch = s.charAt(end);
            charFreq.put(ch, charFreq.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, charFreq.get(ch));
            if (end - start + 1 - maxFreq > k){
                charFreq.put(s.charAt(start), charFreq.get(s.charAt(start)) - 1);
                start++;
            }
            max = Math.max(max, end- start + 1);
            end++;
        }
        return max;
    }
}
