class Solution {
    
    public class Job {
        int jobId;
        int deadline;
        int profit;
        public Job(int jobId, int deadline, int profit){
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
        
    }
    
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int maxDeadline = Integer.MIN_VALUE;
        Job[] jobs = new Job[profit.length];
        for(int i = 0; i < profit.length; i++){
            Job job = new Job(i, deadline[i], profit[i]);
            jobs[i] = job;
            if(maxDeadline < deadline[i]){
                maxDeadline = deadline[i];
            }
        }
        
        Arrays.sort(jobs, (a, b) -> 
        {
            return (b.profit - a.profit);
            
        });
        
        int [] schedule = new int[maxDeadline + 1];
        Arrays.fill(schedule, -1);
        
        int ans = 0;
        int count = 0;
        
        for(int i = 0; i < jobs.length; i++){
            Job job = jobs[i];
            int lastDay = job.deadline;
            for(int day = lastDay; day >= 1; day--){
                if(schedule[day] == -1){
                    schedule[day] = job.jobId;
                    ans += job.profit;
                    count++;
                    break;
                }
            }
        }
        ArrayList<Integer> li = new ArrayList<>();
        li.add(count);
        li.add(ans);
        return li;
        
    }
}
