package com.shixin.array.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSumTest {
    public static final Integer[] array = new Integer[]{2, 7, 11, 15};

    public static Integer[] findTwoNumberIndexByHash(Integer[] array, Integer target) {
        if (array == null || array.length < 2) {
            return new Integer[]{};
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0, length = array.length; i < length; i++) {
            Integer value = array[i];
            Integer find = (target - value);
            if (valueIndexMap.containsKey(find)) {
                return new Integer[]{valueIndexMap.get(find), i};
            }
            valueIndexMap.put(value, i);
        }
        return new Integer[]{};
    }

    public static Integer[] findTwoNumberIndexByPointer(Integer[] array, Integer target) {
        if (array == null || array.length < 2) {
            return new Integer[]{};
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            Integer a = array[leftIndex];
            Integer b = array[rightIndex];
            Integer sum = a + b;
            if (sum.equals(target)) {
                return new Integer[]{leftIndex, rightIndex};
            } else if (sum.compareTo(target) < 0) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return new Integer[]{};
    }

    public static void main(String[] args) {
        Integer[] result1 = findTwoNumberIndexByHash(array, 18);
        System.out.println("Hash法查找两数之和" + Arrays.toString(result1));

        Integer[] result2 = findTwoNumberIndexByPointer(array, 18);
        System.out.println("双指针法查找两数之和（前提是数组有序）" + Arrays.toString(result2));
    }
}
