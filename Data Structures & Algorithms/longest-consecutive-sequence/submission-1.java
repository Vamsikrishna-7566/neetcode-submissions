class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int longest = 0;
        int i = 0;
        int result = 0;

        for (int j = 0; j < nums.length; j++) {
            set.add(nums[j]);
        }

        while (i < nums.length) {

            // Check if the previous number exists
            if (!set.contains(nums[i] - 1)) {

                longest = 1;
                int current = nums[i];

                // Find consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    longest++;
                }

                result = Math.max(result, longest);
            }

            i++;
        }

        return result;
    }
}