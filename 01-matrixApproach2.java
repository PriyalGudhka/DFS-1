// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, Inside the while loop forgot adding the -1's to the queue

/*
Approach : Using BFS(Level Order Traversal). Take queue and first add all the elements with value 0 and convert all the 1's to -1 to distinguish between distance 1 or value 1. Check until !q.isEmpty() iterate over the direction matrix. Start converting -1 to mat[curr[0]][curr[1]] + 1 and add in the queue.
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        if(mat == null || mat.length == 0){
            return new int[][]{};
        }

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
        //Start by adding all independent nodes i.e. all 0's
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){

                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                }
                else{
                    mat[i][j] = -1; // To distinguish between distance 1 & node 1
                }
            }
        }

        int level = 0;

        while(!q.isEmpty()){

            int[] curr = q.poll();

            for(int[] dir: dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }
}