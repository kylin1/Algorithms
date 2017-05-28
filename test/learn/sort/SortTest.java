package learn.sort;

import learn.ch2_sort.*;
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

    @Test
    public void testShellSort(){
        Character input[] = {'S','O','T','E','X','A','M','P','L','E',};
        Sort sort = new ShellSort();
        sort.sort(input);
        MyPrint.print(input);
        assertTrue(sort.isSorted(input));
    }

    @Test
    public void testMergeSort(){
        Character input[] = {'S','O','T','E','X','A','M','P','L','E',};
        Sort sort = new MergeSort();
        sort.sort(input);
        MyPrint.print(input);
        assertTrue(sort.isSorted(input));
    }

    @Test
    public void testMergeSortBottomUp(){
        Character input[] = {'S','O','T','E','X','A','M','P','L','E',};
        MergeSort sort = new MergeSort();
        sort.sortBottomUp(input);
        MyPrint.print(input);
        assertTrue(sort.isSorted(input));
    }

    @Test
    public void testQuickSort(){
        Character input[] = {'S','O','T','E','X','A','M','P','L','E',};
        Sort sort = new QuickSort();
        sort.sort(input);
        MyPrint.print(input);
        assertTrue(sort.isSorted(input));
    }

    @Test
    public void testQuickSort3Way(){
        Character input[] = {'S','O','T','E','X','A','M','P','L','E',};
        QuickSort sort = new QuickSort();
        sort.sort3Way(input);
        MyPrint.print(input);
        assertTrue(sort.isSorted(input));
    }
}
