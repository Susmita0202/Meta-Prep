/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        vector<int> list;
        ListNode* result = nullptr;
        for(auto a :lists){
            while(a!=nullptr){
                list.push_back(a->val);
                a = a->next;
            }
        }
        sort(list.begin(),list.end(),greater<int>());
        for(int i = 0;i<list.size();i++){
            ListNode* temp = new ListNode(list[i],result);
            result = temp;
        }

        return result;
    }
};
