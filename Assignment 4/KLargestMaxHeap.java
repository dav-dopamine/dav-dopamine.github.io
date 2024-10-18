package main;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestMaxHeap 
{
	 public static List<Integer> findTopKElements(int[] elements, int count) 
	    {
	        PriorityQueue<Integer> indexQueue = 
	            new PriorityQueue<>((index1, index2) -> elements[index2] - elements[index1]);

	        List<Integer> topElements = new ArrayList<>();
	        indexQueue.offer(0);

	        while (!indexQueue.isEmpty() && count > 0) 
	        {
	            int largestIndex = indexQueue.poll();
	            topElements.add(elements[largestIndex]);

	            int leftChild = 2 * largestIndex + 1;
	            int rightChild = leftChild + 1;

	            if (leftChild < elements.length) 
	            {
	                indexQueue.offer(leftChild);
	            }
	            if (rightChild < elements.length) 
	            {
	                indexQueue.offer(rightChild);
	            }
	            count--;
	        }
	        return topElements;
	    }
}
