package com.problem;

import com.problem.IProblem;
import java.util.*;

public class MaximumBinaryTree implements IProblem
{
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findMaxIndex(int[] nums)
    {
        int maxIndex = 0;
        int maxValue = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > maxValue)
            {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        return maxIndex;
    }
    
    public void print(int[] nums)
    {
        for(int i = 0; i < nums.length; i++)
        {
            System.out.println(nums[i]);
        }
        System.out.println("\n");
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length <= 0)
        {
            return null;
        }

        int maxIndex = findMaxIndex(nums);
        TreeNode head = new TreeNode(nums[maxIndex]);
        
        
        if(maxIndex == 0)
        {
            head.left = null;
        }
        else
        {
            head.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        }
        
        if(maxIndex == nums.length - 1)
        {
            head.right = null;
        }
        else
        {
            head.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        }
        
        return head;
    }
}
