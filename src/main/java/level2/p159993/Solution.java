package level2.p159993;

import java.util.*;

public class Solution {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static Character[][] M;
    static Queue<int[]> q = new LinkedList<>();
    static int startX, startY; // restart points
    static int[][] dist; // cumulative distance

    public int solution(String[] maps) {
        M = new Character[maps.length][maps[0].length()];
        dist = new int[maps.length][maps[0].length()];
        int resultL, resultE; // resultL: S ~ L, resultE: L ~ E

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i; startY = j;
                }
                M[i][j] = maps[i].charAt(j);
            }
        }

        // 1. search to lever
        q.offer(new int[]{startX, startY});
        dist[startX][startY] = 1; // visit start point
        resultL = BFS('L');

        // failed to reach lever
        if (resultL == -1) return -1;

        // 2. L -> E
        q.clear();
        dist = new int[maps.length][maps[0].length()];

        q.offer(new int[]{startX, startY});
        dist[startX][startY] = 1;
        resultE = BFS('E');

        // failed to reach exit
        if (resultE == -1) return -1;

        return resultL + resultE;
    }

    static int BFS(char arrival) {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int X = node[0];
            int Y = node[1];

            // confirmation of arrival
            if (M[X][Y] == arrival) {
                startX = X;
                startY = Y;
                return dist[X][Y] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = X + dx[i];
                int nextY = Y + dy[i];

                if (nextX < 0 || nextX >= M.length || nextY < 0 || nextY >= M[0].length) continue;
                if (dist[nextX][nextY] > 0) continue;

                char next = M[nextX][nextY];
                if (next != 'X') {
                    dist[nextX][nextY] = dist[X][Y] + 1;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    }

}
