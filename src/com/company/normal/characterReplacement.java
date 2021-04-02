package com.company.normal;

public class characterReplacement {
    /**
     * 424. 替换后的最长重复字符
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
     * <p>
     * 注意：字符串长度 和 k 不会超过 104。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     * <p>
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int length = s.length();
        //双指针
        int[] words = new int[26];//维护最长字串的字母个数
        int leftPoint = 0;
        int rightPoint = 0;//左右指针维护滑动窗口
        int maxWords = 0;//维护滑动窗口最多的字母个数
        while (rightPoint < length) {

            int n = s.charAt(rightPoint) - 'A';
            words[n]++;//右指针指向字母数目++
            maxWords = Math.max(maxWords, words[n]);//判断右指针指向的字母个数是不是最大的
            if (rightPoint - leftPoint - maxWords + 1 > k) {
                //如果别的字母大于k个,左指针右移,并把左指针指向的字母数目减一
                words[s.charAt(leftPoint) - 'A']--;
                leftPoint++;
            }
            //每次右指针都要右移,这样保证了滑动窗口大小不减少
            rightPoint++;

        }
        //计算长度的时候由于每次右指针都要+1,所以和平时计算长度时最后的+1取消
        return (rightPoint - 1) - leftPoint + 1;
    }

    public static void main(String[] args) {
        System.out.println(new characterReplacement().characterReplacement("ACFJDSABAJDSLKCB", 2));
    }
}
