
public class FindFirstandLast 
{
	 public int[] searchRange(int[] array, int targetValue) {
	        int leftIndex = findPosition(array, targetValue);
	        int rightIndex = findPosition(array, targetValue + 1);
	        return leftIndex == rightIndex ? new int[]{-1, -1} : new int[]{leftIndex, rightIndex - 1};
	    }

	    private int findPosition(int[] array, int searchValue) {
	        int start = 0, end = array.length;
	        while (start < end) {
	            int midpoint = (start + end) >>> 1;
	            if (array[midpoint] >= searchValue) {
	                end = midpoint;
	            } else {
	                start = midpoint + 1;
	            }
	        }
	        return start;
	    }
}
