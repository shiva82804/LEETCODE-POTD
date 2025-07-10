class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        boolean[] q = new boolean[n];
        for(int i = 0,t1 = 0,t2 = 0;i<n;i++){     //Checking the avaiability of each event to reschedule
            if(endTime[i]-startTime[i]<=t1){
                q[i] = true;
            }
            t1 = Math.max(t1,startTime[i] - (i == 0 ? 0 : endTime[i - 1]));
            if(endTime[n-i-1]-startTime[n-i-1]<=t2){
                q[n-i-1] = true;
            }
            t2 = Math.max(t2,(i == 0 ? eventTime : startTime[n - i]) - endTime[n - i - 1]);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            int left = i==0 ? 0 : endTime[i-1];               //edge case for left     
            int right = i==n-1 ? eventTime : startTime[i+1];  //edge case for right
            if(q[i]){
                ans = Math.max(ans,right-left);
            }else{
                ans = Math.max(ans,right-left-(endTime[i]-startTime[i]));
            }
        }
        return ans;
    }
}