// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/***
 * Three things we need to validate for sudoku:
 * 1. validate row
 * 2. validate column
 * 3. validate nine 3*3 matrix
 * 
 *  for every row/column validation we simply iterated through the elements 
 * and maintain a hashset corresponding to each row/column to track any duplicate. 
 * If duplicate found set the flag as false & return then & there.
 * 
 * For validating all 3*3 matrix: we keep track of a their centers.
 * we iterate through all these centers & use direction matrix to reach all the elements.
 * Use hashset to track the duplicates.
 */

class Solution {
    private boolean flag;
    private int[][] dirs;
    private int[][] centers;
    private int m;
    private int n;
    public boolean isValidSudoku(char[][] board) {
        this.flag = true;
        this.dirs = new int[][] {{0,0},{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        this.centers = new int[][]{{1,1},{1,4},{1,7},{4,1},{4,4},{4,7},{7,1},{7,4},{7,7}};
        m = board.length;
        n = board[0].length;

        if(flag){
            flag = validRow(board);
        }
        System.out.println(flag);
        if(flag){
            flag = validColumn(board);
        }
        System.out.println(flag);
        if(flag){
            flag = validMatrix(board);
        }
        return flag;
    }

    private boolean validRow(char[][] board){
        for(int i = 0; i < m; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < n; j++){
                char ch = board[i][j];
                if(ch != '.'){
                    if(!set.contains(ch)){
                        set.add(ch);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean validColumn(char[][] board){
        for(int j = 0; j < n; j++){
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < m; i++){
                char ch = board[i][j];
                if(ch != '.'){
                    if(!set.contains(ch)){
                        set.add(ch);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean validMatrix(char[][] board){
        for(int[] center: centers){
            int r = center[0];
            int c = center[1];
            HashSet<Character> set = new HashSet<>();
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                System.out.println(r+" , "+c);
                //boundary check
                if(nr >= 0 && nc >= 0 && nr < m && nc < n){
                    char ch = board[nr][nc];
                    if(ch != '.'){
                        if(!set.contains(ch)){
                            set.add(ch);
                        }else{
                            System.out.println(nr+" , "+nc+" , "+ch);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}