/*Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(true)
        {
            Queue<TreeNode> tmp_q = new LinkedList<TreeNode>();
            for(TreeNode tmp : q)
            {
                System.out.println(tmp.val);
                if(tmp.left != null)
                {
                    tmp_q.add(tmp.left);
                }
                if(tmp.right != null)
                {
                    tmp_q.add(tmp.right);
                }
            }
            if(tmp_q.isEmpty())
            {
                return q.poll().val;
            }
            else
            {
                q = tmp_q;
            }
        }
    }
}


