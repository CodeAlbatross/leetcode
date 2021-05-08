package com.company;

import java.util.*;


public class Main {
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

    private static void radixSort(int[] arr) {
        //待排序列最大值
        int max = arr[0];
        int exp;//指数

        //计算最大值
        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }

        //从个位开始，对数组进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            //存储待排元素的临时数组
            int[] temp = new int[arr.length];
            //分桶个数
            int[] buckets = new int[10];

            //将数据出现的次数存储在buckets中
            for (int value : arr) {
                //(value / exp) % 10 :value的最底位(个位)
                buckets[(value / exp) % 10]++;
            }

            //更改buckets[i]，
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据存储到临时数组temp中
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }

    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StringBuffer[] ans = new StringBuffer[t];
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);

            double sum = 0;
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                queue.offer(num);
                sum+=num;
            }
            if (sum%3 ==0 && !queue.isEmpty() && queue.peek()!=0 && queue.contains(0)){
                StringBuffer sb = new StringBuffer();
                for (Integer num : queue){
                    sb.append(num);
                }
                //System.out.println(sb);
                ans[i] = sb;
                continue;
            }else if (queue.size() ==1 && queue.peek() == 0){
                //System.out.println(0);
                ans[i] = new StringBuffer("0");
                continue;
            }
            //System.out.println(-1);
            ans[i] = new StringBuffer("-1");

        }
        for (StringBuffer s : ans){
            System.out.println(s);
        }
    }
    public void t3(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            boolean flag = false;
            boolean flag2 = false;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
                sum+=nums[j];
                if(nums[j] == 0) flag =true;
                else flag2 = true;
            }
            if (n == 1 && nums[0] == 0){
                System.out.println(0);
                continue;
            }

            if (!flag) {
                System.out.println(-1);
                continue;
            }else if (!flag2){
                System.out.println(-1);
                continue;
            }else if (sum % 3!=0){
                System.out.println(-1);
                continue;
            }
            Arrays.sort(nums);
            StringBuilder sb = new StringBuilder();
            for (int j = nums.length-1; j >=0 ; --j) {
                sb.append(nums[j]);
            }
            System.out.println(sb);
        }
    }
    public void t2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//蓄水池数量
        int m = in.nextInt();//管道数量
        Union union = new Union(n);
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            union.merge(a,b);
        }
        Map<Integer,Double> map = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = union.find(i);
            map.put(a,map.getOrDefault(a,0.0)+num[i]);
            map2.put(a,map2.getOrDefault(a,0)+1);
        }
        for (int i = 0; i < n; i++) {
            int a = union.find(i);
            double b = map.get(a)/map2.get(a);
            System.out.printf("%.2f",b);
            System.out.print(" ");
        }
    }
    public static class Union{
        int[] fa;
        int[] rank;
        int[] water;
        int n;
        static int count = 1;//联通的池子数量
        public Union(int n){
            this.n = n;
            water = new int[n];
            fa = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x){
            if (fa[x] == x){
                return x;
            }else {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        public void merge(int i,int j){
            int fi = find(i);
            int fj = find(j);
            if (rank[fi] > rank[fj]){
                fa[fj] = fi;
            }else if(rank[fi] < rank[fj]){
                fa[fi] = fj;
            }else {
                fa[fi] = fj;
                rank[fj]++;
            }
            n--;
        }
    }
}