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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
            if(list1 == NULL) return list2;
            else if(list2 == NULL) return list1;
            vector<int> vec;
            ListNode* temp = list1;
            while(temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = list2;

            temp = list1;

            while(temp != NULL)
            {
                vec.push_back(temp->val);
                temp = temp->next;
            }

            sort(vec.begin(), vec.end());
            temp = list1;
            int i = 0;
            while(temp != NULL)
            {
                temp->val = vec[i];
                temp = temp->next;
                i++;
            }
            return list1;
    }
};
