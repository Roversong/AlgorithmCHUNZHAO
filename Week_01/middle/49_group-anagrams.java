// 思路一 排序数组分类
// 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
// 维护一个映射 ans : {String -> List}，其中每个键 K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 K。
// 在 Java 中，我们将键存储为字符串，例如，code。
// 复杂度分析
// 时间复杂度：O(NKlog K)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(K log K)的时间内对每个字符串排序。
// 空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}