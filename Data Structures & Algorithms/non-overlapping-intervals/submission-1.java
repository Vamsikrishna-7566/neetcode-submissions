class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int i = 0;
        int result = 0;
        while (i < intervals.length) {
            int[] current = intervals[i];
            int j = i + 1;
            while (j < intervals.length) {
                int[] next = intervals[j];
                if (current[1] > next[0]) {
                    // overlapping condition
                    result++;
                      // Keep the interval that ends earlier
                    if (current[1] > next[1]) {
                        current = next;
                    }

                }

                else {
                    break;
                }
                j++;
            }

            i = j;
        }

        return result;
    }
}
