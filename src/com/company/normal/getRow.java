package com.company.normal;

import java.util.ArrayList;
import java.util.List;

public class getRow {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0)
            return list;
        list.add(1);
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (j == list.size() - 1) {
                    temp.add(1);
                } else {
                    temp.add(list.get(j) + list.get(j + 1));
                }
            }
            list = new ArrayList<>(temp);
            if (i == rowIndex - 1) {
                return temp;
            }
            temp.clear();
            ;
            temp.add(1);
        }
        return null;
    }

}
