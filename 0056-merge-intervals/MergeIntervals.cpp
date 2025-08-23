class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) 
    {
        // sort intervals according to their start time so that if in future I find any interval which is smaller so it could not create problem while merging.
       vector<pair<int,int>>vec;    
       vector<vector<int>>ans;
       for(auto it:intervals){
        vec.push_back({it[0],it[1]});
       }

       sort(vec.begin(),vec.end());

       // most imp. is creating these 2 variables.

       int fir=vec[0].first;
       int sec=vec[0].second;

       for(int i=0;i<vec.size()-1;i++){
        if(sec>=vec[i+1].first){
            sec=max(sec,vec[i+1].second);     // focus.
        }

        else{
               vector<int>temp;
               temp.push_back(fir);
               temp.push_back(sec);

               fir=vec[i+1].first;
               sec=vec[i+1].second;
               ans.push_back(temp);
        }
       }

       ans.push_back({fir,sec});           // focus.
       return ans;
    }
};
