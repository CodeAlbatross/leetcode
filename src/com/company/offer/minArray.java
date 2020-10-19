package com.company.offer;

public class minArray {
    /**
     * 暴力
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 1){
            return numbers[0];
        }
        for (int i = 1; i< numbers.length; i++){
            if (numbers[i] < numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

    /**
     * 二分
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        int low=0, high = numbers.length;
        while (low < high){
            int mid = low + ( high - low ) / 2;
            if (numbers[mid] < numbers[high]){
                high = mid;
            }else if (numbers[mid] > numbers[high]){
                low = mid+1;
            }else {
                --high;
            }
        }
        return numbers[high];
    }
}
