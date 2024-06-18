// Time Complexity : O(m*n) => As we iterate over the n nodes
// Space Complexity : O(m*n) //Recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Stopping condition for recursive call was incorrect

/*
Approach : Using DFS(Level Order Traversal). In the dfs(), iterate over the direction array to traverse up, down, left & right and call dfs() by passing new row and new column.
 */
class Solution {
    int[][] dirs;
    int m, n;
    int originalColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //Indicates we don't have access to the original color
        if (image[sr][sc] == color) {
            return image;
        }

        m = image.length;
        n = image[0].length;

        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        originalColor = image[sr][sc];

        dfs(image, sr, sc, color);

        return image;
    }

    private void dfs(int[][] image, int row, int column, int color){

        if(row < 0 || row == m || column < 0 || column == n || image[row][column] != originalColor){
            return;
        }

        image[row][column] = color;

        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = column + dir[1];

            dfs(image, nr, nc, color);
        }
    }
}