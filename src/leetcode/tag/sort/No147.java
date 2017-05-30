package leetcode.tag.sort;

import myutil.ListNode;
import myutil.MyList;

/**
 * Created by kylin on 28/05/2017.
 * All rights reserved.
 * <p>
 * Sort a linked list using insertion sort.
 */
public class No147 {

    public static void main(String[] args) {
        int array[] = {5,4,2,1,3,6,8,7,9};
        No147 x = new No147();
        ListNode list = MyList.getListFromArray(array);

        ListNode newList = x.insertionSortList(list);

        MyList.printList(newList);
        System.out.println(MyList.isSorted(newList));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;

        ListNode newHead = new ListNode(0); // store result in this list

        ListNode pre = newHead;     //insert between pre and pre.next
        ListNode curr = head;       //current node to be inserted
        ListNode next = null;       //next node to be inserted

        while (curr != null) {
            next = curr.next;
            // find the place to insert curr : pre.next >= curr
            while (pre.next != null && pre.next.val < curr.val)
                pre = pre.next;

            // insert curr between pre and pre.next
            // curr->pre.next
            curr.next = pre.next;
            // pre->curr
            pre.next = curr;

            // next node to be inserted
            pre = newHead;
            curr = next;
        }
        return newHead.next;
    }

}

