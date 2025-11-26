class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        int n=costs.size()/2;
    int totalsum=0;

        sort(costs.begin(), costs.end(),
             [](const vector<int>& a, const vector<int>& b) {
                 return (a[0]-a[1]) < (b[0]-b[1]);
             });

        for(int i=0;i<n;i++){
            totalsum+=costs[i][0];
        }
        for(int i=n;i<2*n;i++){
            totalsum+=costs[i][1];
        }
        return totalsum;
    }
};
