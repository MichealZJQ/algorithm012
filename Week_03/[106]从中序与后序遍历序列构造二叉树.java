package leetcode.editor.cn;

//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 247 👎 0

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
   

    public static void main(String[] args) {
       Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int inLen = inorder.length;
            int postLen = postorder.length;
            if (inLen != postLen) return null;
            Map<Integer, Integer> map = new HashMap<>(inLen);
            for (int i = 0; i < inLen; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(postorder, 0, postLen - 1, map, 0, inLen - 1);
        }

        private TreeNode buildTree(int[] postorder, int postLeft, int postRight,
                                   Map<Integer, Integer> map, int inLeft, int inRight) {
            if (postLeft > postRight || inLeft > inRight) return null;
            int rootVal = postorder[postRight];
            int pIndex = map.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(postorder, postLeft, pIndex - inLeft + postLeft-1, map, inLeft, pIndex - 1);
            root.right = buildTree(postorder, pIndex - inLeft + postLeft, postRight - 1, map, pIndex + 1, inRight);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}