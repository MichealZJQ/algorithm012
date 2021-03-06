package leetcode.editor.cn;

//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法 
// 👍 222 👎 0

import java.util.LinkedList;

public class WordSearchIi {
   

    public static void main(String[] args) {
       Solution solution = new WordSearchIi().new Solution();
        
   }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> findWords(char[][] board, String[] words) {
            TrieNode root = new TrieNode();
            // 构建字典树
            for (int i = 0; i < words.length; i++) {
                TrieNode node = root;
                for (int j = 0; j < words[i].length(); j++) {
                    char ch = words[i].charAt(j);
                    if (!node.containsKey(ch)) {
                        node.put(ch, new TrieNode());
                    }
                    node = node.get(ch);
                }
                node.val = words[i];
            }
            // 遍历board
            List<String> res = new ArrayList<>();
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(board, i, j, res, root);
                }
            }
            return res;
        }

        private void dfs(char[][] board, int row, int col, List<String> res, TrieNode node) {
            char c = board[row][col];
            if (c == '#' || node.get(c) == null) return;
            node = node.get(c);
            if (node.val != null) {
                res.add(node.val);
                node.val = null;
            }
            // 避免重复使用
            board[row][col] = '#';
            if (row > 0) dfs(board, row - 1, col, res, node);
            if (col > 0) dfs(board, row, col - 1, res, node);
            if (row < board.length - 1) dfs(board, row + 1, col, res, node);
            if (col < board[0].length - 1) dfs(board, row, col + 1, res, node);
            // 恢复
            board[row][col] = c;
        }
    }

    class TrieNode {
        public TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        public String val;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}