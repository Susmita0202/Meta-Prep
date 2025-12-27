#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (!root) return result;

        // map<column, values>
        map<int, vector<int>> colMap;

        // queue stores node and its column index
        queue<pair<TreeNode*, int>> q;
        q.push({root, 0});

        while (!q.empty()) {
            auto [node, col] = q.front();
            q.pop();

            colMap[col].push_back(node->val);

            if (node->left)
                q.push({node->left, col - 1});
            if (node->right)
                q.push({node->right, col + 1});
        }

        // collect results column by column
        for (auto &it : colMap) {
            result.push_back(it.second);
        }

        return result;
    }
};
