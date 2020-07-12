package leetcode.editor.cn;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 558 👎 0

public class MergeSortedArray {
   

    public static void main(String[] args) {
       Solution solution = new MergeSortedArray().new Solution();
        
   }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 1、引入中间数组，长度为nums1的长度m
     * 2、将nums1的值赋值给中间数组temp，比较temp和nums2，省去最后赋值的过程
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] temp = new int[m];
            System.arraycopy(nums1, 0, temp, 0, m);
            int i = 0;
            int j = 0;
            int g = 0;
            while (g < m && j < n) {
                if (temp[g] <= nums2[j]) {
                    nums1[i] = temp[g];
                    g++;
                } else {
                    nums1[i] = nums2[j];
                    j++;
                }
                i++;
            }

            if (g < m)
                System.arraycopy(temp, g, nums1, g + j, m + n - g - j);

            if (j < n)
                System.arraycopy(nums2, j, nums1, g + j, m + n - g - j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}