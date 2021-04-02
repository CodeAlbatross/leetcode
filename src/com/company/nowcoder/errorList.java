package com.company.nowcoder;

import java.util.*;

public class errorList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while (!in.hasNext("0")){
            String error = in.nextLine();
            int begin = error.lastIndexOf('\\');
            error = error.substring(begin+1);
            int lastKongGe = error.lastIndexOf(' ');
            if (lastKongGe >= 16)
                error = error.substring(lastKongGe-16);

            if (map.containsKey(error)){
                map.put(error, map.get(error)+1);
            }else {
                //map.remove(retFirst(map));
                map.put(error,1);
            }
        }
        List<String> list = new LinkedList<>(map.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        int i = 8;
        for (String e:list){
            i--;
            System.out.println(e+" "+map.get(e));
            if (i < 0)
                break;
        }
    }
    /*private static String retFirst(Map<String,Integer> map){
        for (String s : map.keySet()){
            return s;
        }
        return null;
    }*/
}
