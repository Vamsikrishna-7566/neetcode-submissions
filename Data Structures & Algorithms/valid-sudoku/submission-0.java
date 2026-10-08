class Solution {
    public boolean isValidSudoku(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // Check all rows
        for (int i = 0; i < n; i++) {
            int[] visitor = new int[board.length + 1];

            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int number = board[i][j] - '0';

                if (visitor[number] == 1) {
                    return false;
                } else {
                    visitor[number] = 1;
                }
            }
        }

        // Check all columns
        for (int j = 0; j < m; j++) {
            int[] visitor = new int[board.length + 1];

            for (int i = 0; i < n; i++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int number = board[i][j] - '0';

                if (visitor[number] == 1) {
                    return false;
                } else {
                    visitor[number] = 1;
                }
            }
        }

        // Check all 3x3 sub-boxes
        for (int row = 0; row < n; row += 3) {
            for (int col = 0; col < m; col += 3) {

                // Fresh visitor array for each 3x3 box
                int[] visitor1 = new int[board.length + 1];

                for (int iR = row; iR < row + 3; iR++) {
                    for (int jC = col; jC < col + 3; jC++) {

                        if (board[iR][jC] == '.') {
                            continue;
                        }

                        int number = board[iR][jC] - '0';

                        if (visitor1[number] == 1) {
                            return false;
                        } else {
                            visitor1[number] = 1;
                        }
                    }
                }
            }
        }

        return true;
    }
}