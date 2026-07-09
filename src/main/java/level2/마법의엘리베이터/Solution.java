package level2.마법의엘리베이터;

public class Solution {

    static int answer;

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(95));
    }

    public int solution(int storey) {
        DFS(storey, answer);
        return answer;
    }

    public void DFS(int cur, int sum) {
        int next = cur % 10;
        if (cur == 0) {
            answer = sum;
            return;
        }
        int move = 0;
        if (next > 5) {
            move = 10 - next;
            cur += move; // Move Up
        } else if (next < 5) {
            move = next;
            cur -= move; // Move Down
        } else {
            int nn = (cur / 10) % 10;
            if (nn >= 5) {
                move = 10 - next;
                cur += move; // Move Up
            } else {
                move = next;
                cur -= move; // Move Down
            }
        }

        DFS(cur / 10, sum + move);
    }

}
