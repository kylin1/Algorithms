package learn.sort;

import leetcode.tag.sort.No148;
import myutil.ListNode;
import myutil.MyList;
import org.junit.Test;

/**
 * Created by kylin on 30/05/2017.
 * All rights reserved.
 */
public class ListTest {

    @Test
    public void testMergeSortList(){
        int array[] = {5,4,2,1,3,6,8,7,9};
        ListNode list = MyList.getListFromArray(array);

        No148 x = new No148();
        ListNode newList = x.sortList(list);
        MyList.printList(newList);
        System.out.println(MyList.isSorted(newList));
    }
}
