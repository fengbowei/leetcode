import com.problem.MaximumBinaryTree;


public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Starting From Main Entrance:\n");
        System.out.println("1. MaximumBinaryTree\n");
        MaximumBinaryTree obj = new MaximumBinaryTree();
        MaximumBinaryTree.TreeNode node;
        int nums[] = {3,2,1,6,0,5};
        node = obj.constructMaximumBinaryTree(nums);
        
    }
}
