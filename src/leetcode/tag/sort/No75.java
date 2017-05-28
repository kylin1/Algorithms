package leetcode.tag.sort;

import myutil.MyPrint;

/**
 * Created by kylin on 28/05/2017.
 * All rights reserved.
 * <p>
 * Given an array with n objects colored 0, 1 or 2,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order 0, 1 and 2.
 * <p>
 * use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * not suppose to use the library's sort function for this problem.
 * <p>
 * 只有3个颜色,直接遍历一次记录三个的次数,然后重写数组
 * Could you come up with an one-pass algorithm using only constant space?
 */
public class No75 {

    public static void main(String[] args) {

        No75 x = new No75();
        int input[] = {1, 2, 0};
        x.anotherSort(input);
        MyPrint.print(input);
    }

    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        sort(nums, 0, high);
    }

    //one-pass algorithm using only constant space
    public void anotherSort(int[] nums) {
        int index0 = 0;
        int index2 = nums.length - 1;
        int i = 0;
        while (i <= index2) {
            if (nums[i] == 0) exch(nums, i++, index0++);
                // important !!! i does not change! 1,2,0->1,0,2 i=still 1 so it get 0
            else if (nums[i] == 2) exch(nums, i, index2--);
            else i++;
        }
    }


    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void sort(int[] nums, int low, int high) {
        if (high <= low)
            return;
        int value = nums[low];
        int i = low + 1;
        int lt = low, gt = high;
        while (i <= gt) {
            if (nums[i] < value) {
                exch(nums, i++, lt++);
            } else if (nums[i] > value) {
                exch(nums, i, gt--);
            } else {
                i++;
            }
        }
        // [low,lt-1] [lt,gt] [gt+1,high]
        sort(nums, low, lt - 1);
        sort(nums, gt + 1, high);
    }

}
