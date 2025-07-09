class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int time[] = new int[n+1];
        for(int i = 0;i<n;i++){
            time[i+1] = endTime[i]-startTime[i] + time[i];
        }
        int res = 0;
        for(int i =k-1;i<n;i++){
            int left = i==k-1? 0:endTime[i-k];
            int right = i==n-1 ? eventTime : startTime[i+1];
            res = Math.max(res,right-left-(time[i+1]- time[i-k+1]));
        }
        return res;
     }
        
}