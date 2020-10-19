package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class phoneNumber {
    static final Map<Character,String> map = Map.of(
            '2',"abc",'3',"def",'4',"ghi",'5',"jkl",
            '6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz"
    );
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        dfs(digits,0,list,new StringBuilder());
        return list;
    }
    public void dfs(String digits,int idx,List<String> list,StringBuilder stringBuilder){
        if (stringBuilder.length() == digits.length()){
            list.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < map.get(digits.charAt(idx)).length(); i++){
            stringBuilder.append(map.get(digits.charAt(idx)).charAt(i));
            dfs(digits,idx+1,list,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
