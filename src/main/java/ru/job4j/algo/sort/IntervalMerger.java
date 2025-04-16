package ru.job4j.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = list.get(list.size() - 1);

            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                list.add(curr);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
