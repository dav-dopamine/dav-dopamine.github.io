package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class TopK 
{
	 class Solution 
	    {
	        public int[] findTopKFrequent(int[] elements, int k) 
	        {
	            Map<Integer, Integer> frequencyMap = new HashMap<>();
	            for (int i = 0; i < elements.length; i++) 
	            {
	                frequencyMap.merge(elements[i], 1, Integer::sum);
	            }

	            PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
	                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

	            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) 
	            {
	                minHeap.offer(entry);
	                if (minHeap.size() > k) 
	                {
	                    minHeap.poll();
	                }
	            }

	            List<Integer> resultList = new ArrayList<>();
	            while (!minHeap.isEmpty()) 
	            {
	                resultList.add(minHeap.poll().getKey());
	            }

	            int[] resultArray = new int[resultList.size()];
	            for (int i = 0; i < resultList.size(); i++) 
	            {
	                resultArray[i] = resultList.get(i);
	            }

	            return resultArray;
	        }
	    }
  }

