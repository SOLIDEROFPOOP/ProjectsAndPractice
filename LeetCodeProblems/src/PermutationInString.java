public class PermutationInString {
    public boolean checkInclusion(String s1, String s2){
        if (s1.length() > s2.length()){
            for (int i = 0; i < s1.length(); i+=s2.length()){

            }
        }
        return false;
    }
    public static boolean check(String s1 , String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        if (s1.equals(s2)) return true;
        else return false;
    }
    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "ba";
        System.out.println(check(s1 , s2));
    }
}
