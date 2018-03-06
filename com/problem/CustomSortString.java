import java.util.*;


public class CustomSortString
{
    public String customSortString(String S, String T) 
    {
        Queue<String> q = new LinkedList<String>();
        int[] table = new int[S.length()];
        Arrays.fill(table, 0);
        for (int i = 0; i < T.length(); i++) 
        {
            int priority = S.indexOf(T.charAt(i));
            if(priority == -1)
            {
                q.add(String.valueOf(T.charAt(i)));
            }
            else
            {
                table[priority]++;
            }
        }

        String result = new String();
        for (int i = 0; i < S.length(); i++) 
        {
            for(int j = table[i]; j > 0; j--)
            {
                result += S.charAt(i);
            }
        }

        while(!q.isEmpty())
        {
            result += q.poll();
        }
        return result;
    }
}
