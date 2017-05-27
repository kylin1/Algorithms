package learn.sort;

import learn.ch2_sort.InsertSort;
import learn.ch2_sort.SelectSort;
import learn.ch2_sort.Sort;
import myutil.MyPrint;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by kylin on 27/05/2017.
 * All rights reserved.
 */
public class SortTest {


    @Test
    public void testSelectSort(){
        Integer input[] = {3,4,5,1,1,2,3,4,2,5,6,7,8,9};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(input);
        MyPrint.print(input);
        assertTrue(selectSort.isSorted(input));
    }

    @Test
    public void testInsertSort(){
        Character input[] = {'S','O','T','E','X','A','M','P','L','E',};
        Sort sort = new InsertSort();
        sort.sort(input);
        MyPrint.print(input);
        assertTrue(sort.isSorted(input));
    }
}
