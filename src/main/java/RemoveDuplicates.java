public class RemoveDuplicates {

    public static void main(String[] args) {
        //int n = new RemoveDuplicates().removeDuplicates(new int[]{0,0,0,1,1,1,2,3,4,4,4});
        int n = new RemoveDuplicates().removeDuplicates(new int[]{1,2,3,4,5});
        System.out.println(n);
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0 )
            return 0;
        int cur = 0;
        for (int i=1; i < nums.length ; ++i){
            if (nums[i] != nums[cur]) {
                nums[++cur] = nums[i];
            }
        }
        return cur+1;
    }
}
