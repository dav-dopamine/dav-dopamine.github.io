public class ShortestSubarray 
{
    public int shortestSubarray(int[] nums, int k) 
    {
        int n = nums.length;
        int[] prefixSums = new int[n + 1];
        
        for(int i = 0; i < n; i++) 
        {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;

        for(int start = 0; start < n; start++) 
        {
            for(int end = start + 1; end <= n; end++) 
            {
                int currentSum = prefixSums[end] - prefixSums[start];
                if(currentSum >= k) 
                {
                    minLength = Math.min(minLength, end - start);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
