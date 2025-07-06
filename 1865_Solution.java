class FindSumPairs {
    HashMap<Integer,Integer> hm1;
    HashMap<Integer,Integer> hm2;
    int nums1[];
    int nums2[];
    public FindSumPairs(int[] nums1, int[] nums2) {
        hm1 = new HashMap<>();
        hm2 = new HashMap<>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int i = 0;i<nums1.length;i++){
            hm1.put(nums1[i],hm1.getOrDefault(nums1[i],0)+1);
        }
        for(int i = 0;i<nums2.length;i++){
            hm2.put(nums2[i],hm2.getOrDefault(nums2[i],0)+1);
        }
    }
    
    public void add(int idx, int val) {
        int cnt = hm2.get(nums2[idx]);
        hm2.put(nums2[idx],cnt-1);
        nums2[idx] += val;
        hm2.put(nums2[idx],hm2.getOrDefault(nums2[idx],0)+1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for(Integer key : hm1.keySet()){
            int target = tot-key;
            int cnt1 = hm1.get(key);
            if(hm2.containsKey(target)){
                ans += (cnt1*(hm2.get(target)));
            }
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */