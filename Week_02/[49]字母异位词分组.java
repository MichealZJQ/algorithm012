package leetcode.editor.cn;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 396 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
   

    public static void main(String[] args) {
       Solution solution = new GroupAnagrams().new Solution();
        
   }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) return new ArrayList<>();

            Map<String,List<String>> retMap = new HashMap<>();
            int[] cnt = new int[26];
            for (int i = 0; i < strs.length; i++) {
                Arrays.fill(cnt, 0);
                for (char c : strs[i].toCharArray()) {
                    cnt[c - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int j=0;j<26;j++){
                    sb.append(cnt[j]);
                }
                String key = sb.toString();
                if (retMap.containsKey(key)){
                    retMap.get(key).add(strs[i]);
                }else {
                    List<String> temps = new ArrayList<>();
                    temps.add(strs[i]);
                    retMap.put(key,temps);
                }
            }
            return new ArrayList<>(retMap.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}