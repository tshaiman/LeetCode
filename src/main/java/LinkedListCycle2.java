import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycle2 {

    public static void main(String[] args) {
        //https://leetcode.com/problems/linked-list-cycle-ii/
        ListNode lst = Utils.build(Arrays.asList(3,2,0,-4));
        ListNode two = lst.next;
        ListNode last = two.next.next;
        last.next = two;

        ListNode answer  =new LinkedListCycle2().detectCycle(lst);
        if(answer != null)
            System.out.println(answer.val);
        else
            System.out.println("-1");

    }
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hash = new HashSet<>();
        ListNode cur = head;

        while(true){
            if(cur == null || cur.next ==null) return null;
            if(hash.contains(cur.next)) return cur.next;
            hash.add(cur);
            cur = cur.next;
        }
    }
}
