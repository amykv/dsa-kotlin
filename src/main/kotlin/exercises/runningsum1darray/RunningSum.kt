package exercises.runningsum1darray

/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.


Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
*/

fun main(){
    val solution = Solution()
    val myNums = intArrayOf(1, 2, 3, 4)
    println(solution.runningSum(myNums))
}

//Working function for solution on LeetCode, problem 1480
// Time complexity: O(n)
// Space complexity: 0(1)
class Solution {
    fun runningSum(nums: IntArray): IntArray {
        if (nums.size == 1) {
            return nums
        }
        for (index in 1 until nums.size) {
            nums[index] += nums[index - 1]
        }
        return nums
    }
}

