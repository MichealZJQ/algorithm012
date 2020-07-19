package leetcode.editor.cn;

//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 312 👎 0

import java.util.ArrayList;

public class BinaryTreePreorderTraversal {
   

    public static void main(String[] args) {
       Solution solution = new BinaryTreePreorderTraversal().new Solution();
        
   }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            res.add(root.val);
            if (root.left != null) res.addAll(preorderTraversal(root.left));
            if (root.right != null) res.addAll(preorderTraversal(root.right));
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}