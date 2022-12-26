package level0.머쓱이보다키큰사람;

import java.util.Arrays;

public class Solution {

    public int solution(int[] array, int height) {
        return (int) Arrays.stream(array).filter(a -> a > height).count();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{149, 180, 192, 170}, 167));
    }

}
