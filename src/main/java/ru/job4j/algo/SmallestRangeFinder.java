package ru.job4j.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return null;
        }
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }
        if (uniqueSet.size() < k) {
            return null;
        }

        int[] result = new int[2];
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() >= k) {
                int newLen = right - left;

                if (newLen < minLen) {
                    minLen = newLen;
                    result[0] = left;
                    result[1] = right;
                }

                int count = map.get(nums[left]);
                if (count == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], count - 1);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
