package com.company;

import com.company.offer.*;

import javax.management.StandardEmitterMBean;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println(new backspaceCompare().backspaceCompare("nzp#o#g",
                "b#nzp#o#g"));
    }
}

