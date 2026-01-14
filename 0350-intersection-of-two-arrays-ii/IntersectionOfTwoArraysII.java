import java.util.*;
class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        if(n1 > n2){
            for(int i : nums1){
                if(!map.containsKey(i)){
                    map.put(i, 1);    
                }
                else{
                    map.put(i, map.get(i)+1);    
                }
            }
            for(int i : nums2){
                if(map.containsKey(i) && map.get(i) > 0){
                    list.add(i);
                    map.put(i, map.get(i)-1);    
                }
            }
        }

        else{
            for(int i : nums2){
                if(!map.containsKey(i)){
                    map.put(i, 1);    
                }
                else{
                    map.put(i, map.get(i)+1);    
                }
            }
            for(int i : nums1){
                 if(map.containsKey(i) && map.get(i) > 0){
                    list.add(i);
                    map.put(i, map.get(i)-1);    
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
