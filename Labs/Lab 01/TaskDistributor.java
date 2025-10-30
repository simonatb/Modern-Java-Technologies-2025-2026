import java.util.Arrays;

public class TaskDistributor {
    public static int sumArray(int[] tasks){
        int sum = 0;
        for(int i = 0; i < tasks.length; i++){
            sum += tasks[i];
        }
        return sum;
    }

    public static int minDifference(int[] tasks){
        int n = tasks.length;
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return tasks[0];
        }
        else if(n == 2) {
            return Math.abs(tasks[0] - tasks[1]);
        }

        int sum = sumArray(tasks);
        int target = sum / 2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int i = 0; i < n; i++){
            for(int j = target; j >= tasks[i]; j--){
                if(dp[j - tasks[i]]){
                    dp[j] = true;
                }
            }
        }

        int firstSum = 0;
        for(int i = target; i >= 0 ; i--){
            if(dp[i]){
                firstSum = i;
                break;
            }
        }
        int secondSum = sum - firstSum;;
        return Math.abs(firstSum - secondSum);
    }

}
