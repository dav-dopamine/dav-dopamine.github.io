import java.util.Arrays;

public class KLargestElement 
{
	public int findKthLargest(int[] nums, int k) 
	{
        Arrays.sort(nums);  
        return nums[nums.length - k];  
    }
}
