package leetcode.tag.sort;

import myutil.ListNode;
import myutil.MyList;

/**
 * Created by kylin on 30/05/2017.
 * All rights reserved.
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class No148 {

    // merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head;

        // 1. cut into two parts [head,slow] [slow.next,tail]
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nextHead = slow.next;
        slow.next = null;

        // 2. sort each part
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(nextHead);

        // 3. merge them then return
        return merge(h1, h2);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode newHead = new ListNode(0);
        ListNode thisNode = newHead;

        while (h1 != null || h2 != null) {
            if (h1 == null) {
                thisNode.next = h2;
                thisNode = thisNode.next;
                h2 = h2.next;
            } else if (h2 == null) {
                thisNode.next = h1;
                thisNode = thisNode.next;
                h1 = h1.next;
            } else if (h1.val < h2.val) {
                thisNode.next = h1;
                thisNode = thisNode.next;
                h1 = h1.next;
            } else {
                thisNode.next = h2;
                thisNode = thisNode.next;
                h2 = h2.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int array[] = {1};
        ListNode list1 = MyList.getListFromArray(array);

        int array2[] = {2};
        ListNode list2 = MyList.getListFromArray(array2);

        No148 x = new No148();
        ListNode result = x.merge(list1, list2);
        MyList.printList(result);
    }

}
