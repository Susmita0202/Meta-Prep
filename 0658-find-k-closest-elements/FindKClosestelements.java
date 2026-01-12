class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]);
                } 
                else {
                    return Integer.compare(b[0], a[0]);
                }
            }
        );
        for(int i = 0; i < arr.length; i++){
            maxHeap.add(new int[]{arr[i], absDifference(arr[i], x)});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(maxHeap.size() > 0){
            int[] part = maxHeap.poll();
            ans.add(part[0]);
        }
        Collections.sort(ans);
        return ans;
    }
    public Integer absDifference(int a, int x){
        return Math.abs(a - x);
    }
}
