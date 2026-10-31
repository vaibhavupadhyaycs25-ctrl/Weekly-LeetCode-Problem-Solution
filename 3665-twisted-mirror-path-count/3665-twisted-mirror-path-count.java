class Solution {
    public int uniquePaths(int[][] grid) {
        final int mod = 1_000_000_007;
        int[] down = new int[grid[0].length]; 
        down[0] = 1;
        for (int[] row : grid) {
            int right = 0; 
            for (int j = 0; j < row.length; j++) {
                int above = down[j], merged = right + above; 
                merged -= merged >= mod ? mod : 0; 
                int mask = -row[j];  
                down[j] = merged ^ ((merged ^ right) & mask); 
                right = merged ^ ((merged ^ above) & mask);
            }
        }
        return down[down.length - 1];
    }
}