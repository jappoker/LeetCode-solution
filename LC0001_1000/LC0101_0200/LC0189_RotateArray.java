package LC0001_1000.LC0101_0200;

/**
 * 189. Rotate Array [medium]
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 */
public class LC0189_RotateArray {
    
    /**
     * Solution: Brute Force
     * Time Complexity: O(N*k)
     * Space Complexity: O(1)
     * 
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        // corner case
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        k %= n;
        for(int i = 0; i < k; i++){
            int temp = nums[n-1];
            for(int j = n - 1; j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    /**
     * Solution: Using Extra Array
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] helper = new int[n];
        int i = 0;
        for(int j = n - k; j < n; j++){
            helper[i++] = nums[j];
        }
        for(int j = 0; j < n - k; j++){
            helper[i++] = nums[j];
        }
        for(int j = 0; j < n; j++){
            nums[j] = helper[j];
        }
    }

    /**
     * Solution: Using Cyclic Replacements
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = 0;
        for(int start = 0; count < n; start++){
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
              } while (start != current);
        }
    }

    /**
     * Solution: Using Reverse
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("189. Rotate Array [medium]");
        LC0189_RotateArray solu = new LC0189_RotateArray();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        solu.rotate3(nums, k);
        System.out.println(java.util.Arrays.toString(nums)); // [5,6,7,1,2,3,4]
        nums = new int[]{-1,-100,3,99};
        k = 2;
        solu.rotate3(nums, k);
        System.out.println(java.util.Arrays.toString(nums)); // [3,99,-1,-100]
    }
}
