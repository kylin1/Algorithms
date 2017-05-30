package leetcode.tag.sort;

import java.util.Arrays;

/**
 * Created by kylin on 30/05/2017.
 * All rights reserved.
 */
public class No179 {

    public static void main(String[] args) {
        int n[] = {0,0,0};
        No179 x = new No179();
        System.out.println(x.largestNumber(n));
    }

    public String largestNumber(int[] nums) {
        String strs[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        // sort array
        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // if all num is 0
        if(strs[0].charAt(0) == '0') return "0";

        StringBuilder builder = new StringBuilder();
        for (String str : strs)
            builder.append(str);
        return builder.toString();
    }

}
