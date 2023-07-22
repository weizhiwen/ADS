package com.shixin.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TreeNumberSumTest {
    public static final Integer[] array1 = new Integer[]{-1, 0, 1, 2, -1, -4};
    public static final Integer[] array2 = new Integer[]{0, 0, 0, 0, 0, 0};

    public static List<List<Integer>> findThreeNumberIndexByPointer(Integer[] array, Integer target) {
        List<List<Integer>> result = new ArrayList<>();
        if (array == null || array.length < 3) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>(List.of(array));
        List<Integer> sortedList = list.stream().sorted().toList();
        for (int i = 0, size = sortedList.size(); i < size - 2; i++) {
            Integer a = sortedList.get(i);

            if (a > target) {
                return result;
            }

            if (i > 0 && Objects.equals(a, sortedList.get(i - 1))) {
                continue;
            }

            int leftIndex = i + 1;
            int rightIndex = size - 1;
            while (leftIndex < rightIndex) {
                Integer b = sortedList.get(leftIndex);
                Integer c = sortedList.get(rightIndex);
                Integer sum = a + b + c;
                if (sum.equals(target)) {
                    result.add(List.of(a, b, c));
                    // 对b和c去重
                    while (leftIndex < rightIndex && Objects.equals(sortedList.get(leftIndex), sortedList.get(leftIndex + 1))) {
                        leftIndex++;
                    }
                    while (leftIndex < rightIndex && Objects.equals(sortedList.get(rightIndex), sortedList.get(rightIndex - 1))) {
                        rightIndex--;
                    }
                    leftIndex++;
                    rightIndex--;
                } else if (sum > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> findThreeNumberIndexByHash(Integer[] array, Integer target) {
        List<List<Integer>> result = new ArrayList<>();
        if (array == null || array.length < 3) {
            return result;
        }
        for (int i = 0, length = array.length; i < length - 2; i++) {
            Integer a = array[i];
            if (a > target) {
                return result;
            }

            if (i > 0 && Objects.equals(a, array[i - 1])) {
                continue;
            }
            Integer sum = target - a;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < length - 1; j++) {
                Integer b = array[j];
                Integer c = sum - b;
                if (map.containsKey(c)) {
                    result.add(List.of(a, b, c));
                    // 对b做去重
                    while (j < length - 1 && Objects.equals(b, array[j + 1])) {
                        j++;
                    }
                }
                map.put(b, j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result1 = findThreeNumberIndexByPointer(array1, 0);
        System.out.println("双指针法查找三数之和" + result1);
        List<List<Integer>> result2 = findThreeNumberIndexByPointer(array2, 0);
        System.out.println("双指针法查找三数之和" + result2);
        List<List<Integer>> result3 = findThreeNumberIndexByHash(array1, 0);
        System.out.println("Hash法查找三数之和" + result3);
        List<List<Integer>> result4 = findThreeNumberIndexByHash(array2, 0);
        System.out.println("Hash法查找三数之和" + result4);
    }
}
