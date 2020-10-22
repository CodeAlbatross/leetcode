package com.company;

import com.company.offer.*;

import javax.management.StandardEmitterMBean;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(new partitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
