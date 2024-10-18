package main;
import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayK 
{
	public int findShortestSubarray(int[] array, int targetSum) 
    {
        int length = array.length;
        long[] prefixSum = new long[length + 1];

        for (int index = 0; index < length; ++index) 
        {
            prefixSum[index + 1] = prefixSum[index] + array[index];
        }

        Deque<Integer> indexDeque = new ArrayDeque<>();
        int minimumLength = length + 1;

        for (int index = 0; index <= length; ++index) 
        {
            while (!indexDeque.isEmpty() && prefixSum[index] - prefixSum[indexDeque.peek()] >= targetSum) 
            {
                minimumLength = Math.min(minimumLength, index - indexDeque.poll());
            }
            while (!indexDeque.isEmpty() && prefixSum[indexDeque.peekLast()] >= prefixSum[index]) 
            {
                indexDeque.pollLast();
            }
            indexDeque.offer(index);
        }

        return minimumLength > length ? -1 : minimumLength;
    }
}
