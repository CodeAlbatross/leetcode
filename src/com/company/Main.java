package com.company;

import com.company.offer.*;

import javax.management.StandardEmitterMBean;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /*TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);*/
        boolean[] x = new boolean[1];
        System.out.println(Arrays.deepToString(new merge().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {13, 18}})));
    }
}
