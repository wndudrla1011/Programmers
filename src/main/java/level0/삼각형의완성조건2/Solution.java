package level0.삼각형의완성조건2;

public class Solution {

    public int solution(int[] sides) {
        return (sides[0] + sides[1]) - Math.abs(sides[0] - sides[1]) - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 2}));
    }

}
