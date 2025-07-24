/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9; // Sudoku board size (9x9)

        // Create 3 lists of HashSets:

        // 1. rows -> to track numbers present in each row
        List<HashSet<Character>> rows = new ArrayList<HashSet<Character>>(N);
        // 2. cols -> to track numbers present in each column
        List<HashSet<Character>> cols = new ArrayList<HashSet<Character>>(N);
        // 3. grids -> to track numbers present in each 3x3 sub-grid
        List<HashSet<Character>> grids = new ArrayList<HashSet<Character>>(N);

        // Initialize all 9 HashSets for rows, columns, and grids
        for (int r = 0; r < N; r++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            grids.add(new HashSet<Character>());
        }

        // Traverse the 9x9 sudoku board
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char value = board[r][c];

                // Skip empty cells (denoted by '.')
                if (value == '.')
                    continue;

                // Check if the value already exists in the current row
                if (rows.get(r).contains(value))
                    return false; // Duplicate found → invalid Sudoku
                rows.get(r).add(value); // Add value to the current row set

                // Check if the value already exists in the current column
                if (cols.get(c).contains(value))
                    return false; // Duplicate found → invalid Sudoku
                cols.get(c).add(value); // Add value to the current column set

                // Identify the 3x3 grid index:
                // Each grid can be represented by index 0 to 8:
                int g = (r / 3) * 3 + (c / 3);

                // Check if the value already exists in the current 3x3 grid
                if (grids.get(g).contains(value))
                    return false; // Duplicate found → invalid Sudoku
                grids.get(g).add(value); // Add value to the current grid set
            }
        }

        // If no duplicates are found in any row, column, or grid → valid Sudoku
        return true;
    }
}
// @lc code=end
