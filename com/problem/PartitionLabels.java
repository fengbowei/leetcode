import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String S) {
        Hashtable<Character, Integer> last_index_table = new Hashtable<Character, Integer>();
        List<Integer> result = new LinkedList<Integer>();
        for(int i = 0; i < S.length(); i++)
        {
            char current = S.charAt(i);
            last_index_table.put(current, Integer.valueOf(i));
        }
        
        for(int i = 0; i < S.length(); i++)
        {
            char current = S.charAt(i);
            int i_init = i;
            Integer max = last_index_table.get(current);
            while(i < max)
            {
                i++;
                Integer local_max = last_index_table.get(S.charAt(i));
                if(local_max > max)
                {
                    max = local_max;
                }
            }
            result.add(max - i_init + 1);
        }
        return result;
    }
}
