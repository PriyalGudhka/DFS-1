// Time Complexity : O(m*n) => In the worst case, image[sr][sc] might be surrounded by the same color and which in turn requires to convert it to a new color
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach : Using BFS(Level Order Traversal). Take queue and add the image[sr][sc]. Run a while loop to check if queue is not empty and use size variable
to hold size of the queue. Use the direction array to travel up, down, left & right and then start converting color and add in the queue if it matches the original color.
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //Indicates we don't have access to the original color
        if (image[sr][sc] == color) {
            return image;
        }

        int m = image.length;
        int n = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });

        int originalColor = image[sr][sc];
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == originalColor) {

                        q.add(new int[]{nr, nc});
                        image[nr][nc] = color;
                    }
                }
            }

        }

        return image;

    }
}