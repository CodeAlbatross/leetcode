package com.company.IntroductionToAlgorithms;

import java.util.ArrayList;
import java.util.List;
//调度队列，主要的思想就是以最大惩罚降序排列，遍历所有任务，
// 将截止时间任务放入任务队列，如果这个任务的任务队列原位置被占就放入最近的位置，
// 若位置都满了，则放弃任务
public class MissionPlan {
    public static class Task{
        public int a;
        public int d;
        public int w;

        public Task(int a, int d, int w) {
            this.a = a;
            this.d = d;
            this.w = w;
        }
    }
    public static void main(String[] args) {

        //int[][] missions = new int[][]{{4,70},{2,60},{4,50},{3,40},{1,30},{4,20},{6,10}};
        int[][] missions = new int[][]{{2,47},{1,42},{5,37},{4,25},{2,49},{2,49},{6,20}};
        func(missions);
        for (int i = 0; i < missions.length; i++) {
            missions[i][1] = 49 - missions[i][1];
        }
        func(missions);
    }
    public static void func(int[][] missions){
        int cost = 0;
        List<Task> tasks = new ArrayList<>();
        int[] deque = new int[missions.length];
        for (int i = 0; i < missions.length; i++) {
            tasks.add(new Task(i+1,missions[i][0],missions[i][1]));
        }
        tasks.sort((o1, o2) -> o2.w - o1.w);
        for (Task task : tasks){
            int i = task.d-1;
            for (; i >= 0; i--){
                if (deque[i] == 0){
                    deque[i] = task.a;
                    break;
                }
            }
            if (i == -1){
                cost+=task.w;
            }
        }
        System.out.println(cost);
    }

}
