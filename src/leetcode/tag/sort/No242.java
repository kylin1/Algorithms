package leetcode.tag.sort;

import java.util.Arrays;

/**
 * Created by kylin on 30/05/2017.
 * All rights reserved.
 */
public class No242 {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        No242 x = new No242();
        System.out.println(x.isAnagram(s, t));
    }

    // sort and compare, beats 50%
    // n logn time, n space
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++)
            if (ch1[i] != ch2[i])
                return false;
        return true;
    }

    // You may assume the string contains only lowercase alphabets.!!!
    // TODO 数组大小是固定的!!! 只有26!!!
    // 想法:一个26字符的数组,代表字母出现的个数
    // s增加,t减少,每一个都是0,则完毕
    // beats 53%
    // n time 26 space
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int array[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            array[s.charAt(i) - 'a'] += 1;

        for (int i = 0; i < t.length(); i++)
            array[t.charAt(i) - 'a'] -= 1;

        for (int i = 0; i < array.length; i++)
            if (array[i] != 0) return false;

        return true;
    }
}