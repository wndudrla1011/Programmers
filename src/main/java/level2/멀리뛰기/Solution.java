package level2.멀리뛰기;

public class Solution {

    public long solution(int n) {
        long[] dp = new long[n + 1];

        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3));
    }

}
