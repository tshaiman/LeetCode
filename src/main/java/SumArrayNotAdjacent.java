import java.util.List;

public class SumArrayNotAdjacent {

    public static void main(String[] args) {
        int[] arr = new int[] { 1,5,2,2,6,3};
        System.out.println(sumArrays(arr));
    }

    private static int sumArrays(int[] arr) {
        return sumArrays(arr,0);
    }

    private static int sumArrays(int[] arr,int startIndex) {
        if (startIndex >= arr.length)
            return 0;
        if(startIndex == arr.length - 1)
            return arr[startIndex];
        int s1 = arr[startIndex] + sumArrays(arr,startIndex + 2);
        int s2 = sumArrays(arr,startIndex+1);
        return Math.max(s1,s2);
    }

}
