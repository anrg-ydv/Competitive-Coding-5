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
    private  int[][] centers;
    private  int[][] dirs;
    private  int m;
    private  int n;
    public boolean isValidSudoku(char[][] board) {
        centers = new int[][] {{1,1},{1,4},{1,7},{4,1},{4,4},{4,7},{7,1},{7,4},{7,7}};
        dirs = new int[][] {{-1,1},{0,1},{1,1},{-1,0},{1,0},{-1,-1},{0,-1},{1,-1},{0,0}};
        m = board[0].length; 
        n = board.length;
        boolean flag = true;

        //validate row
        flag = validateRow(board);
        //validate columns
        if(flag){
            flag = validateColumn(board);
        }
        //validate 3*3 matrix
        if(flag){
            flag = validateMatrix(board);
        }
        return flag;
    }
    private boolean validateRow(char[][] board){
        for(int j = 0; j< n; j++){
            HashSet<Character> set = new HashSet<>();
            for(int i =0; i< m; i++){
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
    private boolean validateColumn(char[][] board){
        for(int i =0; i< m; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j< n; j++){
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
    private boolean validateMatrix(char[][] board){
        for(int[] center : centers){
            int i = center[0];
            int j = center[1];
            HashSet<Character> set = new HashSet<>();
            for(int[] dir: dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                char ch = board[nr][nc];
                if(ch != '.'){
                    if(nr>=0 && nc>=0 && nr<m && nc< n && !set.contains(ch)){
                        set.add(ch);
                    }else{
                        return false;
                    }
                }                
            }
        }
        return true;
    }
}