package com.company.normal;
/**
 * 给定一个非负整数numRows，生成杨辉三角的前numRows行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */

import java.util.ArrayList;
import java.util.List;

public class generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0)
            return lists;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j<list.size(); j++){
                if (j == list.size()-1){
                    temp.add(1);
                }else {
                    temp.add(list.get(j)+list.get(j+1));
                }
            }
            list = new ArrayList<>(temp);
            lists.add(new ArrayList<>(temp));
            temp.clear();;
            temp.add(1);

        }
        return lists;
    }


}

