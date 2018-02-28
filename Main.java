import com.problem.MaximumBinaryTree;
import com.problem.IProblem;


public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Starting From Main Entrance:");
        System.out.println("1. MaximumBinaryTree");
        IProblem obj = new MaximumBinaryTree();
        obj.setInput("[3,2,1,6,0,5]");
        obj.runTest();
        obj.printResult();
    }
}
