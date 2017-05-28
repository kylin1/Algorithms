package leetcode.tag.sort;

import java.util.*;

/**
 * Created by kylin on 28/05/2017.
 * All rights reserved.
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * <p>
 * * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class No56 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 3));

        No56 no56 = new No56();
        List<Interval> intervals1 = no56.merge(intervals);
        for (Interval x : intervals1)
            System.out.println(x);
    }

    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        if (size <= 1)
            return intervals;
        List<Interval> result = new LinkedList<>();

        Collections.sort(intervals, new IntervalBeginOrder());

        Interval thisOne = intervals.get(0);
        for (int i = 1; i < size; i++) {
            Interval nextOne = intervals.get(i);
            // can merge
            if (thisOne.end >= nextOne.start) {
                thisOne = new Interval(thisOne.start, Math.max(thisOne.end, nextOne.end));
                if (i == size - 1)
                    result.add(thisOne);

                // this end < next start, can not merge
            } else {
                result.add(thisOne);
                thisOne = nextOne;
                if (i == size - 1)
                    result.add(nextOne);
            }
        }

        return result;
    }


}

class IntervalBeginOrder implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.start < o2.start)
            return -1;
        else if (o1.start > o2.start)
            return 1;
        else
            return 0;
    }
}


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

