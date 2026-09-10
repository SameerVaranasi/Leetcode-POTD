/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans =0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
        int []dfs (TreeNode root){
            //first check the null condition
            if(root == null){
                return new int[]{0,0};
            }
            //now lets check the left and right part
            int [] left = dfs(root.left);//left child part
            int [] right= dfs(root.right);//right child part
            int sum = left[0]+right[0]+root.val;
            int count = left[1]+right[1]+1;
            // we have counted all thee sum and count now lets caluclate the average
            if (sum/count ==root.val){
                ans++;
            }
            return new int[]{sum,count}; 


        }
    
}