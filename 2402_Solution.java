class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] meetingAvailabiltyTime = new long[n];
        int[] count = new int[n];
        Arrays.sort(meetings,(a,b) ->Integer.compare(a[0],b[0]));    //Sort the meetings according to start time
        for(int[] meeting:meetings){
            int start=meeting[0],end=meeting[1];
            boolean UnUsedRoom =false;
            long minAvailablet = Long.MAX_VALUE;
            int minAvailableroom = 0;
            for(int i = 0;i<n;i++){
            if(meetingAvailabiltyTime[i]<=start){
                UnUsedRoom =true;
                meetingAvailabiltyTime[i] = end;
                count[i]++;
                break;
            }
            if(meetingAvailabiltyTime[i]<minAvailablet){
                minAvailablet = meetingAvailabiltyTime[i];
                minAvailableroom = i;
            }
            }
            if(!UnUsedRoom){
                meetingAvailabiltyTime[minAvailableroom] += (long)end-start;
                count[minAvailableroom]++;
            }
        }
        int ans = 0;
        int max_count = 0;
        for(int i =0;i<n;i++){
            if(count[i]>max_count){
                ans = i;
                max_count = count[i];
            }
        }
        return ans; 
     }
}