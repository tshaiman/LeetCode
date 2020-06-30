
import java.util.*;

public class Sum3 {

    public static void main(String[] args) {
        Sum3 sm = new Sum3();
        //List<List<Integer>> res = sm.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        List<List<Integer>> res = sm.threeSum(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        for (List<Integer> inner : res) {
            System.out.println(inner);
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        HashSet<String> submissions = new HashSet<String>();
        if(nums.length < 3) return result;
        Arrays.sort(nums); // -4 , -1 , -1 , 0 , 1 ,2
        if(nums[0] == nums[nums.length-1] && nums[0] == 0){
            result.add(Arrays.asList(0,0,0));
            return result;
        }
        for (int i = 0; i < nums.length - 2; ++i) {
            List<List<Integer>> sum2 = check2Sum(nums,i+1, -nums[i]);
            for(List<Integer> combination : sum2) {
                String solution = String.format("%d-%d-%d",nums[i],combination.get(0),combination.get(1));
                if(submissions.contains(solution)) continue;
                List<Integer> lst = new LinkedList<Integer>();
                lst.add(nums[i]);
                lst.addAll(combination);
                result.add(lst);
                submissions.add(solution);
            }
        }
        return result;
    }

    // -1 , -1 , 0 , 1 ,2 should sum to  0
    //

    private List<List<Integer>> check2Sum(int[] nums, int start, int target) {
        List<List<Integer>> allSum2 = new LinkedList<List<Integer>>();
        int i = start;
        int j = nums.length-1;
        while ( j > i) {
            int sum =  nums[i] + nums[j];
            if (sum == target ) {
                allSum2.add(Arrays.asList(nums[i],nums[j]));
                i++;
                j--;
            } else if (sum > target ) {
                    j--;
            } else {
                i ++;
            }
        }
        return allSum2;
    }


}





