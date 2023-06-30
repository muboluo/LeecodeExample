package jv.leet.array;

import jv.leet.list.ReverseList;

/**
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
 * 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * <p>
 * key: 如果我们试图将指向较长线段的指针向内移动，移动后，新形成的矩形，受限于先前较小的线段的概率会更大。
 * <p>
 * 目标：我们的目标是寻找新的受限条件，而不是替换不受限的条件。
 * 我们只有在X轴不断减小的同时，寻找更高的Y轴线段才能获得更大的矩形。
 * <p>
 * https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
 * 这篇文章分析的很不错，讲到了消去所有的状态。
 * <p>
 * 疑问点1：
 * 怎么证明移动 y 轴值小的一方，更有可能找到更大面积的矩形。
 */
class MaxArea {

    public static int maxArea(int[] heightArray) {

        int result = 0;
        if (heightArray == null) {
            return result;
        }
        int left = 0, right = heightArray.length - 1;

        while (left < right) {

            result = Math.max(Math.min(heightArray[left], heightArray[right]) * (right - left), result);

            if (heightArray[left] < heightArray[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;

    }

    // 第二遍
    public static int maxArea2(int[] heightArray) {

        int result = 0;
        if (heightArray == null) {
            return result;
        }

        int left = 0, right = heightArray.length - 1;

        while (left < right) {

            result = Math.max(result, (right - left) * Math.min(heightArray[left], heightArray[right]));

            if (heightArray[left] < heightArray[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        final int result = maxArea(new int[]{1, 2, 3, 4, 5, 6});
        final int result2 = maxArea2(new int[]{1, 2, 3, 4, 5, 6});
        final int result3 = maxArea3(new int[]{1, 2, 3, 4, 5, 6});
        final int result4 = maxArea4(new int[]{1, 2, 3, 4, 5, 6});

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    private static int maxArea4(int[] nums) {
        int result = -1;
        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = 0, right = nums.length - 1;

        while (left < right) {
            result = Math.max(result, Math.min(nums[left], nums[right]) * (right - left));
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    // 第三遍
    private static int maxArea3(int[] ints) {
        // 我们的目标是，在X轴不断减小的同时，不断寻找更高的Y轴。
        // 寻找新的受限条件，而不是，替换不受限条件。

        int result = 0;
        if (ints == null) {
            return result;
        }

        int left = 0, right = ints.length - 1;

        while (left < right) {
            result = Math.max(result, (right - left) * Math.min(ints[right], ints[left]));

            if (ints[left] < ints[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }


    private static int maxArea5(int[] nums) {
        int maxArea = -1;
        if (nums == null || nums.length == 0) {
            return maxArea;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int currentArea = (right - left) * Math.min(nums[left], nums[right]);

            maxArea = Math.max(currentArea, maxArea);

            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}
