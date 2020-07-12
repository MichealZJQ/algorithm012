package leetcode.editor.cn;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 617 👎 0

public class RotateArray {
   

    public static void main(String[] args) {
       Solution solution = new RotateArray().new Solution();
        
   }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一：所有元素移动k位
     * 方法二：额外数组，第i位置的元素放到新数组的(i+k)%n位置
     * 方法三：整体反转 -> 前k位置反转 -> 后n-k位置反转
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length <= 0) return;
            if (k == 0) return;
            k %= nums.length;

            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}