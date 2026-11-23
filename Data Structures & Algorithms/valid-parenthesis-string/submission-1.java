class Solution {
    public boolean checkValidString(String s) {
          int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            }
            else { // '*'
                minOpen--;
                maxOpen++;
            }

            // Cannot have negative unmatched opening brackets
            if (maxOpen < 0) {
                return false;
            }

            // Minimum possible unmatched opening count
            minOpen = Math.max(0, minOpen);
        }

        return minOpen == 0;
    }
}
