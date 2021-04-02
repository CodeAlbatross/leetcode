package com.company.offer;

public class _58_reverseWords {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; --i) {
            if (ss[i].equals("")) {
                continue;
            }
            //到头了，append然后去空格
            if (i == 0) {
                res.append(ss[i].trim());
            } else {
                // 怕有多余的空格(trim())，去掉，再加上去
                res.append(ss[i].trim()).append(" ");
            }
        }
        return res.toString().trim();
    }
}
