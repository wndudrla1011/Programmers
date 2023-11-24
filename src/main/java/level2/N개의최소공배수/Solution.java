package level2.N개의최소공배수;

public class Solution {

    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = (answer * arr[i]) / gcd(answer, arr[i]);
        }

        return answer;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{2, 6, 8, 14}));
    }

}
