package leetcode.tag.sort;

/**
 * Created by kylin on 28/05/2017.
 * All rights reserved.
 * <p>
 * Sort a linked list using insertion sort.
 */
public class No147 {

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);

        n5.next = n4;
        n4.next = n3;
        n3.next = n2;
        n2.next = n1;

        No147 x = new No147();
        ListNode node = x.insertionSortList(n5);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;

        ListNode newHead = new ListNode(0); // store result in this list

        ListNode pre = newHead;     //insert between pre and pre.next
        ListNode curr = head;       //current node to be inserted
        ListNode next = null;       //next node to be inserted

        while (curr != null){
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}