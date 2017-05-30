package leetcode.tag.sort;

import java.util.Arrays;

/**
 * Created by kylin on 30/05/2017.
 * All rights reserved.
 */
public class No179 {

    public static void main(String[] args) {
        int n[] = {9,34,30,2,15};
        No179 x = new No179();
        System.out.println(x.largestNumber(n));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        String strs[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        // sort array 9与30比较,结果应该是9>30 : 30+9 < 9+30, 9是1,30是2, 1应该在前
        // o1 = 9, o2 = 30, result = o1 > o2
        // (o2 + o1).compareTo(o1 + o2) = 1
        // (o2 + o1) > (o1 + o2)
        // 30,9 > 9,30
        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (int i = 0; i < nums.length; i++)
            System.out.print(strs[i]+" ");

        // if all num is 0
        if(strs[0].charAt(0) == '0') return "0";

        StringBuilder builder = new StringBuilder();
        for (String str : strs)
            builder.append(str);
        return builder.toString();
    }

}
