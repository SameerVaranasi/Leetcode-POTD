/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    int ans = 0;

public:
    int averageOfSubtree(TreeNode* root) {
        dfs(root);
        return ans;
    }

    vector<int> dfs(TreeNode* root) {
        // null condition
        if (root == nullptr) {
            return {0, 0};
        }

        // left and right subtree
        vector<int> left = dfs(root->left);
        vector<int> right = dfs(root->right);

        // calculate sum and count
        int sum = left[0] + right[0] + root->val;
        int count = left[1] + right[1] + 1;

        // calculate average
        if (sum / count == root->val) {
            ans++;
        }

        return {sum, count};
    }
};