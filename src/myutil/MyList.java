package myutil;

/**
 * Created by kylin on 30/05/2017.
 * All rights reserved.
 */
public class MyList {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5};
        ListNode list = MyList.getListFromArray(array);
        MyList.printList(list);
        System.out.println(MyList.isSorted(list));
    }

    public static boolean isSorted(ListNode node) {
        ListNode dummy = node;
        ListNode dummyNext = node.next;
        while (dummyNext != null) {
            int thisV = dummy.val;
            int nextV = dummyNext.val;
            if (thisV > nextV)
                return false;
            dummy = dummy.next;
            dummyNext = dummyNext.next;
        }
        return true;
    }


    public static void printList(final ListNode node) {
        ListNode dummy = node;
        while (dummy != null) {
            System.out.print(dummy.val + "->");
            dummy = dummy.next;
        }
        System.out.println("end");
    }

    public static ListNode getListFromArray(int[] array) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int one : array) {
            ListNode newNode = new ListNode(one);
            head.next = newNode;
            head = newNode;
        }
        return dummy.next;
    }
}
