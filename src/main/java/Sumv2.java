import java.util.Arrays;
import java.util.HashSet;

public class Sumv2 {

    public static void main(String[] args) {
        int arr[] = new int[] {-1,2,-5,3,-4,5,8};
        System.out.println(new Sumv2().sum2(arr,0));
    }

    public boolean sum2(int[] arr, int target){
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0; i < arr.length -1 ; ++i) {
            int remain = target - arr[i];
            if(hash.contains(remain)) return true;
            for (int j = i+1 ; j < arr.length ; ++j){
                if (arr[j] == remain)
                    return true;
                hash.add(arr[j]);
            }
        }
        return false;
    }
}
