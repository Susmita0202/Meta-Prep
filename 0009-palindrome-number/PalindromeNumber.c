class Solution {
public:
    bool isPalindrome(int x) {
         if(x<0)
    return false;
   long int num=x, rem=0, rev=0;
while(x != 0){
    rem= x%10;
    rev= rev*10 + rem;
    x= x/10;
}
if(num == rev)
return true;
else
return false;
}
};
