
public class MajorityElement 
{
	public int majorityElement(int[] nums)
	{
		int counter = 0; 
		int pos = 0;
		
		for(int i=0; i < nums.length; i++)
		{
			if(nums[i] == pos)
			{
				counter++;
			}
			else if(counter == 0)
			{
				pos = nums[i];
				counter =1;
			}
			else
			{
				counter--;
			}
		}
		
		return pos;
	}
}
 