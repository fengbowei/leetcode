package com.problem;

import com.problem.IProblem;
import java.util.*;

public class MaximumBinaryTree implements IProblem
{
    int[] m_nums;
    TreeNode m_result;
    public void setInput(String s)
    {
        s = s.replace("[", "");
        s = s.replace("]", "");
        String sarray[]= s.split(",");
        m_nums = new int[sarray.length];
        for(int i = 0; i < sarray.length; i++)
        {
            m_nums[i] = Integer.parseInt(sarray[i]);
        }
        System.out.print("input: [");
        for(int i = 0; i < m_nums.length; i++)
        {
            System.out.print(m_nums[i]);
            System.out.print(',');
        }
        System.out.println("]");
    }
    
    public void runTest()
    {
        m_result = constructMaximumBinaryTree(m_nums);
    }

    public void printResult()
    {
        System.out.print("Output: ");
        bfs_print(m_result);   
    }
    
    public void bfs_print(TreeNode head)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> tmp_q = new LinkedList<TreeNode>();
        q.add(head);
        System.out.print('[');
        while(!q.isEmpty())
        {
            while(!q.isEmpty())
            {
                TreeNode tmp_node = q.poll();
                if(tmp_node == null)
                {
                    System.out.print("null");
                }
                else
                {
                    System.out.print(tmp_node.val);
                    if(tmp_node.left != null || tmp_node.right != null)
                    {
                        tmp_q.add(tmp_node.left);
                        tmp_q.add(tmp_node.right);
                    }
                }
                System.out.print(',');
            }
            q = tmp_q;
        }
        System.out.println(']');
    }

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
