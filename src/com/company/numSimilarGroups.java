package com.company;

public class numSimilarGroups {
    /**
     * 839. 相似字符串组
     * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
     *
     * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
     *
     * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
     *
     * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
     *
     *
     *
     * 示例 1：
     *
     * 输入：strs = ["tars","rats","arts","star"]
     * 输出：2
     * @param strs
     * @return
     */
    public int numSimilarGroups(String[] strs) {
        int length = strs.length;
        Union union = new Union(length);
        for (int i = 0; i < length; i++){
            for (int j = i+1; j < length; j++){
                if (anagram(strs[i], strs[j])){
                    union.merge(i,j);
                }
            }
        }
        return union.count;
    }

    /**
     * 判断是否为字母移位词
     * @param a
     * @param b
     * @return
     */
    private boolean anagram(String a, String b){
        int length = a.length();
        int count = 0;
        for (int i = 0; i < length; i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }
        return count <= 2;
    }


    class Union{
        /*--------------并查集------------------*/
        public int[] fa;
        public int[] rank;
        private int count;
        public Union(int n){
            this.fa = new int[n];
            this.rank = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++){
                fa[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int x){
            if (fa[x] != x) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        public void merge(int x, int y){
            int fx = find(x);
            int fy = find(y);
            if (fx == fy){
                return;
            }
            if (rank[fx] > rank[fy]){
                fa[fy] = fx;
            }else if (rank[fy] > rank[fx]){
                fa[fx] = fy;
            }else {
                fa[fx] = fy;
                rank[fy]++;
            }
            count--;
        }


    }

    public static void main(String[] args) {
        System.out.println(new numSimilarGroups().numSimilarGroups(new String[]{"omv","ovm"}));
    }
}


