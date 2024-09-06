
public class Median 
{
	public double findMedianSortedArrays(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;

        int[] combinedArray = new int[length1 + length2];
        int mergeIndex = 0;

        for (int index1 = 0; index1 < length1; index1++) {
            combinedArray[mergeIndex++] = array1[index1];
        }

        for (int index2 = 0; index2 < length2; index2++) {
            combinedArray[mergeIndex++] = array2[index2];
        }

        // Sort the merged array.
        Arrays.sort(combinedArray);

        int totalLength = combinedArray.length;

        // Determining the median 
        if (totalLength % 2 == 1) {
            return (double) combinedArray[totalLength / 2];
        } else {
            int middleElement1 = combinedArray[totalLength / 2 - 1];
            int middleElement2 = combinedArray[totalLength / 2];
            return ((double) middleElement1 + (double) middleElement2) / 2.0;
        }
    }
}
