public class one {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        solution.rotate(nums,9);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        for(int i=0;i<k;i++){
            int temp=nums[nums.length-1];
            for(int j=nums.length-2;j>=0;j--){
                nums[j+1]=nums[j];
            }
            nums[0]=temp;
        }
    }
}
