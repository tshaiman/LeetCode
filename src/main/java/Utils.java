import java.util.List;

public class Utils {

    public static ListNode build(List<Integer> datas) {
        ListNode prev = null ;
        for (int i = datas.size() -1  ; i >=0 ; --i ) {
            prev = new ListNode(datas.get(i),prev);
        }
        return prev;
    }

    public static void printList(ListNode lst) {
        ListNode cur = lst;
        System.out.println();
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
