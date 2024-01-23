public class BinarySearch {
    public int search(int[] nums, int target) {
        int middle, left = 0, right = nums.length - 1;
        while (left <= right){
            middle = left + (right - left) / 2;
            if (nums[middle] == target){
                return middle;
            }
            if (nums[middle] < target){
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }

        return -1;
    }
    public static void main(String args[]) {
        BinarySearch binarySearch = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40};
        int x = 10;

        int result = binarySearch.search(arr, x);

        if (result == -1)
            System.out.println("Element not present in the array");
        else
            System.out.println("Element found at index " + result);
    }
}
