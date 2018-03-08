/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.
*/


class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> arrayComparator = new Comparator<int[]>() 
        {
            @Override
            public int compare(int[] a, int[] b) 
            {
                if (b[0] == a[0]) 
                {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        };
        Arrays.sort(people, arrayComparator);
        
        LinkedList<int[]> ll = new LinkedList<int[]>();
        
        for(int i = 0; i < people.length; i++)
        {
            ll.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        return ll.toArray(new int[0][0]);
    }
}
