package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1448 👎 0

public class TrappingRainWater {
   

    public static void main(String[] args) {
       Solution solution = new TrappingRainWater().new Solution();
        int[] paramArr = new int[]{
                2, 0, 2
        };
       System.out.println(solution.trap(paramArr));
   }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int area = 0;
            int left_max = 0;
            int right_max = 0;

            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] >= left_max) {
                        left_max = height[left];
                    } else {
                        area += (left_max - height[left]);
                    }
                    left++;
                } else {
                    if (height[right] >= right_max) {
                        right_max = height[right];
                    } else {
                        area += (right_max - height[right]);
                    }
                    right--;
                }
            }
            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}