


class Solution {
    public String minWindow(String s, String t) {

        // Store how many times each character is needed
        Map<Character, Integer> map = new HashMap<>();

        // Count the characters in t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Number of characters we still need to find
        int required = t.length();

        // Start of our sliding window
        int left = 0;

        // Starting index of the smallest window found
        int start = 0;

        // Length of the smallest window found
        int minLength = Integer.MAX_VALUE;

        // Move right pointer to expand the window
        for (int right = 0; right < s.length(); right++) {

            // Get the new character entering the window
            char ch = s.charAt(right);

            // If this character is still needed, reduce required
            if (map.getOrDefault(ch, 0) > 0) {
                required--;
            }

            // Mark this character as added to our window
            map.put(ch, map.getOrDefault(ch, 0) - 1);

            // When required is zero, we have all needed characters
            while (required == 0) {

                // Find the size of the current window
                int windowLength = right - left + 1;

                // Save this window if it is the smallest so far
                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }

                // Get the character leaving the window
                char leftChar = s.charAt(left);

                // Put this character back into the needed count
                map.put(leftChar, map.get(leftChar) + 1);

                // If we now need this character again,
                // our window is no longer valid
                if (map.get(leftChar) > 0) {
                    required++;
                }

                // Move left pointer to shrink the window
                left++;
            }
        }

        // If no valid window was found, return empty string
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        // Return the smallest valid substring
        return s.substring(start, start + minLength);
    }
}
