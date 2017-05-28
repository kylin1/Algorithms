package learn.sort;

import learn.ch2_sort.Heap;
import myutil.MyPrint;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by kylin on 28/05/2017.
 * All rights reserved.
 */
public class HeapTest {

    @Test
    public void test(){
        Integer input[] = {5,3,2,6,7,8,10,1,4,9};
        Heap heap = new Heap(input);
        heap.sort(input);
        heap.delete();
        MyPrint.print(input);
        assertTrue(heap.isReversSorted(input));
    }
}
