// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * There are two approaches:
 * 1. BFS (level Order traversal) - find the max at each level. TC: O(n) & SC: O(n)
 * 2. DFS
 * 
 * Following code is implementing DFS: 
 * We maintaing the node & its corresponding level/depth at each call in stack. 
 * Whenever same level is encountered at any node, we check if this larger value in the result list or not.
 * Accordingly we update the result.
 */
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if (root == null) return;

        if(level == result.size()){
            result.add(root.val);
        }else{
            result.set(level, Math.max(result.get(level), root.val));
        }
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}