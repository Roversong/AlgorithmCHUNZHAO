// 贪心法
// 首先对两个数组进行排序操作。
// 然后再遍历s数组,如果当前的值能喂饱孩子 即 s[i] >= g[count] 则 count++;
// 继续喂下一个孩子。直到孩子喂完为止 即count == s.length 退出循环。
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i] >= g[count]) {
                count++;
                if(count == g.length) {
                    break;
                }
            }
        }
        return count;
    }
}

