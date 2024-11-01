
package main;

import java.util.ArrayList;
import java.util.List;



class Solution 
{
    public List<Integer> lexicalOrder(int n) 
    {
        List<Integer> result = new ArrayList<>(n);
        int currentValue = 1; // Renamed from 'v' to 'currentValue'
        
        for (int i = 0; i < n; ++i) 
        {
            result.add(currentValue);
            
            if (currentValue * 10 <= n) 
            {
                currentValue *= 10; // Move to the next level in the lexical order
            } 
            else 
            {
                while (currentValue % 10 == 9 || currentValue + 1 > n) 
                {
                    currentValue /= 10; // Backtrack to find the next valid number
                }
                ++currentValue; // Increment to the next number
            }
        }
        return result; // Return the list of numbers in lexical order
    }
}
