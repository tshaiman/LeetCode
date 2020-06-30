

import java.util.Arrays;
import java.util.List;

public class AddTwoLinkedLists {


    public static void main(String[] args) {
        ListNode lst1 = Utils.build(Arrays.asList(5));
        printList(lst1);
        ListNode lst2 = Utils.build(Arrays.asList(5));
        printList(lst2);
        AddTwoLinkedLists solution = new AddTwoLinkedLists();
        ListNode lst3 = solution.addTwoNumbers(lst1,lst2);
        printList(lst3);
    }

    private static void printList(ListNode lst) {
        ListNode current = lst;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("]");
    }
    

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return  addTwoNumbersRec(l1,l2,0);
    }

    public ListNode addTwoNumbersRec(ListNode l1, ListNode l2,  int reminder) {
        int sum  = reminder;
        if (l1 == null && l2 == null ) {
            if (reminder == 0)
                return null;
            else return new ListNode(reminder);
        }
        ListNode nextL1 = l1;
        ListNode nextL2 = l2;
        if (l1 != null ) {
            sum += l1.val;
            nextL1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            nextL2 = l2.next;
        }
        int currentVal = sum % 10;
        int nextReminder = sum / 10;
        return  new ListNode(currentVal,addTwoNumbersRec(nextL1,nextL2,nextReminder));

    }





}
