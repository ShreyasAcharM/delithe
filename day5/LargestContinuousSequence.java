import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousSequence {
    public static ArrayList<Integer> findLargestZeroSumSubarray(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

        int sum = 0;
        int maxLength = 0;
        int start = -1;
        sumIndexMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumIndexMap.containsKey(sum)) {
                int length = i - sumIndexMap.get(sum);
                if (length > maxLength) {
                    maxLength = length;
                    start = sumIndexMap.get(sum) + 1;
                }
            } else {
                sumIndexMap.put(sum, i);
            }
        }

        if (start >= 0) {
            for (int i = start; i < start + maxLength; i++) {
                result.add(arr[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, -2, 4, -4 };
        ArrayList<Integer> largestSubarray = findLargestZeroSumSubarray(arr);
        System.out.println(largestSubarray); // Output: [2, -2, 4, -4]
    }
}
