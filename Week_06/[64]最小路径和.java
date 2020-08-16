package leetcode.editor.cn;

//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 626 👎 0

public class MinimumPathSum {
   

    public static void main(String[] args) {
       Solution solution = new MinimumPathSum().new Solution();
        
   }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            int rows = grid.length;
            int cols = grid[0].length;
            int[][] dp = new int[rows][cols];
            dp[0][0] = grid[0][0];
            // 0列
            for (int i = 1; i < rows; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            // 0行
            for (int j = 1; j < cols; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
            // others
            for (int m = 1; m < rows; m++) {
                for (int n = 1; n < cols; n++) {
                    dp[m][n] = Math.min(dp[m - 1][n], dp[m][n - 1]) + grid[m][n];
                }
            }
            return dp[rows - 1][cols - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}