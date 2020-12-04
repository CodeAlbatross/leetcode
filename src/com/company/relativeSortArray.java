package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class relativeSortArray {
    /**
     * 1122. 数组的相对排序
     * 给你两个数组，arr1 和 arr2，
     *
     * arr2 中的元素各不相同
     * arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     *
     *
     *
     * 示例：
     *
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,List<Integer>> map = new LinkedHashMap<>();
        for (int num : arr2){
            map.put(num,new ArrayList<>());
        }
        map.put(-1,new ArrayList<>());

        for (int num : arr1){
            if (map.containsKey(num)){
                map.get(num).add(num);
            }else{
                map.get(-1).add(num);
            }
        }
        Collections.sort(map.get(-1));
        int[] relativeSortArray = new int[arr1.length];
        int i = 0;
        for (List<Integer> list : map.values()){
            for (Integer num : list){
                relativeSortArray[i] = num;
                i++;
            }
        }
        return relativeSortArray;
    }
}
