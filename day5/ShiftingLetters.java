public class ShiftingLetters {
    public static String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        long[] cumulativeShifts = new long[n];
        cumulativeShifts[n - 1] = shifts[n - 1];

        // Calculate the cumulative shifts from right to left
        for (int i = n - 2; i >= 0; i--) {
            cumulativeShifts[i] = cumulativeShifts[i + 1] + shifts[i];
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            long shift = cumulativeShifts[i] % 26; // Convert the shift value to be in the range [0, 25]

            // Apply the shift to the character
            char shiftedChar = (char) (((ch - 'a' + shift) % 26) + 'a');

            result.append(shiftedChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = { 3, 5, 9 };
        String result = shiftingLetters(s, shifts);
        System.out.println(result); // Output: "rpl"
    }
}
