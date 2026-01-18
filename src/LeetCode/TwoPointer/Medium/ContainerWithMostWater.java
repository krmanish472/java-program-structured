package LeetCode.TwoPointer.Medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {
        int leftPtr = 0;
        int rightPtr = height.length - 1;

        int maxArea = 0;
        while (leftPtr < rightPtr) {
            int h = Math.min(height[leftPtr], height[rightPtr]);
            int w = rightPtr - leftPtr;

            int currArea = h * w;
            maxArea = Math.max(maxArea, currArea);

            if (height[leftPtr] < height[rightPtr]) {
                leftPtr++;
            } else {
                rightPtr--;
            }

        }
        return maxArea;
    }
}


/**
 * height array represents height at each index 0-1, 1-8, 2-6, etc
 * getting height is simple => water can fill only within the min height
 * getting width is simple, its just index difference
 * Calculating area and finding max is also easy... However, we can't just move both pointers at same time...
 * In this ex, 1, 8, 6, 2, 5, 4, 8, 3, 7 => if we move both ptr at same time, we check 1-7, 8-3, but we miss 8-7, which later turns out to be the answer
 * 👍RULE OF THUMB => keep max height constant, and be greedy for next max height
 */