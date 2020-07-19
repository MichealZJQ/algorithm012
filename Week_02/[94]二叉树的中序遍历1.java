package leetcode.editor.cn;

//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 583 👎 0

import java.util.ArrayList;

public class BinaryTreeInorderTraversal {
   

    public static void main(String[] args) {
       Solution solution = new BinaryTreeInorderTraversal().new Solution();
        
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> retList = new ArrayList<>();
            if (root == null) return retList;
            if (root.left != null) retList.addAll(inorderTraversal(root.left));
            retList.add(root.val);
            if (root.right != null) retList.addAll(inorderTraversal(root.right));
            return retList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}