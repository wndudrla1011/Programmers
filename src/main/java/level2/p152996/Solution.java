package level2.p152996;

import java.util.*;

public class Solution {

    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if ((key * 3) % 2 == 0 && map.containsKey(key * 3 / 2))
                answer += ((long) map.get(key) * map.get(key * 3 / 2));
            if (map.containsKey(key * 2))
                answer += ((long) map.get(key) * map.get(key * 2));;
            if (map.get(key) > 1)
                answer += comb(map, key);
            if ((key * 4) % 3 == 0 && map.containsKey(key * 4 / 3))
                answer += ((long) map.get(key) * map.get(key * 4 / 3));
        }

        return answer;
    }

    static long comb(Map<Integer, Integer> map, int K) {
        return ((long) map.get(K) * (map.get(K) - 1)) / 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{100, 180, 360, 100, 270}));
    }

}
