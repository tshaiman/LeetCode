import java.util.Arrays;

public class reverseLinkedList {
    public static void main(String[] args) {
        reverseLinkedList rl = new reverseLinkedList();
        ListNode sample = Utils.build(Arrays.asList(1,2,3,4,5));
        Utils.printList(rl.reverseBetween(sample,2,4));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        return null;
    }


}
