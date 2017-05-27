package leetcode.tag.sort;

import myutil.MyPrint;

/**
 * Created by kylin on 27/05/2017.
 * All rights reserved.
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 */
public class No394 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        No394 x = new No394();
        int[] re = x.intersection(nums1,nums2);
        MyPrint.print(re);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        return null;
    }

}
