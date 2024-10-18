package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KClosest
{
    class Solution 
    {
        public List<Integer> getClosestElements(int[] numbers, int count, int target) 
        {
            List<Integer> sortedList = Arrays.stream(numbers)
                .boxed()
                .sorted((num1, num2) -> 
                {
                    int difference = Math.abs(num1 - target) - Math.abs(num2 - target);
                    return difference == 0 ? num1 - num2 : difference;
                })
                .collect(Collectors.toList());

            List<Integer> closestElements = new ArrayList<>(sortedList.subList(0, count));
            Collections.sort(closestElements);

            return closestElements;
        }
    }
}
