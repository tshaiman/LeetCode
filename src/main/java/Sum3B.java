import java.util.HashSet;
import java.util.Set;

public class Sum3B {


    public static void main(String[] args) {
        int[] arr = {0, 3, 6, 1,  21, -22};
        System.out.println(three_sum_zero(arr,0));
    }

    public static boolean three_sum_zero(int[] arr,int sum) {
        for (int i = 0; i < arr.length - 2; i++) {
            System.out.println(arr[i]);
            Set<Integer> set = new HashSet<>();

            for (int j = i + 1; j < arr.length; ++j) {
                int diff = sum-(arr[i] + arr[j]);
                if (set.contains(diff)) {
                    System.out.println(arr[i] + " , " + arr[j] + " , " + diff);
                    return true;
                } else {
                    set.add(arr[j]);
                }
            }

        }
        return false;
    }
}
