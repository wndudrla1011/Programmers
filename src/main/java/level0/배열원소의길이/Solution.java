package level0.배열원소의길이;

import java.util.Arrays;

public class Solution {

    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(String::length).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"We", "are", "the", "world!"})));
    }

}
