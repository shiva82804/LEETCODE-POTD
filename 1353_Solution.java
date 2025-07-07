class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxDay = 0;
        for(int i = 0;i<events.length;i++){
            maxDay = Math.max(maxDay,events[i][1]);
        }
        Arrays.sort(events,(a,b)->a[0] - b[0]);
        int ans = 0;
        int n = events.length;
        for(int i = 1,j = 0;i<=maxDay;i++){
            while(j<n && events[j][0]<=i){
                pq.offer(events[j][1]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek()<i){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                ans++;
            }
        }
        return ans;
    }
}