package leetcode.editor.cn;

//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法 
// 👍 101 👎 0

import java.util.HashSet;

public class WalkingRobotSimulation {
   

    public static void main(String[] args) {
       Solution solution = new WalkingRobotSimulation().new Solution();
        
   }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            // 当前朝向，0123分别代表 北东南西   顺时针方向
            int direction = 0;
            // 第一维代表朝向，也就是direction,第二维代表朝着此方向走，没走一步坐标的变化
            int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            // 结果值
            int result = 0;
            // 当前x坐标值
            int x = 0;
            // 当前y坐标值
            int y = 0;
            // 将障碍物放到set中，这样每走一步判断前面是否是障碍物  set#contains
            HashSet<String> obs = new HashSet<>();
            for (int[] obstacle : obstacles) {
                obs.add(obstacle[0] + "," + obstacle[1]);
            }
            for (int command : commands) {
                int next_x = 0;
                int next_y = 0;
                if (command < 0) {
                    // 改变方向  
                    direction = command == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
                } else {
                    for (int i = 0; i < command; i++) {
                        next_x = x + dir[direction][0];
                        next_y = y + dir[direction][1];
                        if (obs.contains(next_x + "," + next_y)) break;
                        x = next_x;
                        y = next_y;
                        result = Math.max(result, x * x + y * y);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}