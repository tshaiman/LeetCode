import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum2 {
    public static void main(String[] args) {
        Sum2 sm = new Sum2();
        int[] input = new int[]{3,2,4};
        int[] arr = sm.twoSum(input,6);
        System.out.println(Arrays.toString(arr));

        System.out.println(sm.check2Sum(input,0,6));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i=0 ; i < nums.length ; ++i) {
            hash.put(nums[i],i);
        }


        for(int i=0 ; i < nums.length ; ++i) {
            int comp2 = target - nums[i];
            Integer comp2Index = hash.get(comp2);
            if(comp2Index != null && comp2Index != i){
                result[0] = i;
                result[1] = comp2Index;
                return result;
            }
        }
        return result;
    }

    private List<Integer> check2Sum(int[] nums, int start, int target) {
        Arrays.sort(nums);
        int i = start;
        int j = nums.length-1;
        while ( j > i) {
            if (i > 0 && nums[i] == nums[i - 1]) i++;
            int sum =  nums[i] + nums[j];
            if (sum == target ) {
                return Arrays.asList(nums[i],nums[j]);
            } else if (sum > target ) {
                j--;
            } else {
                i ++;
            }
        }
        return null;
    }



}
