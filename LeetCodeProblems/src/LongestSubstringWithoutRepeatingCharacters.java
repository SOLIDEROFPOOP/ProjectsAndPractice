import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, maxLen  = 0;
        HashSet<Character> chars = new HashSet<>();
        while (end < s.length()){
            if (chars.contains(s.charAt(end))){
                chars.remove(s.charAt(start));
                start++;
            }
            else {
                chars.add(s.charAt(end));
                maxLen = Math.max(maxLen, end - start + 1);
                end++;
            }
        }
        return maxLen;
    }
}
