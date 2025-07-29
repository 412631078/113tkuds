import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] hm = sc.nextLine().split(":");
            times.add(Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]));
        }
        String[] q = sc.nextLine().split(":");
        int query = Integer.parseInt(q[0]) * 60 + Integer.parseInt(q[1]);

        int l = 0, r = times.size() - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (times.get(mid) > query) {
                ans = times.get(mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (ans == -1) {
            System.out.println("No bike");
        } else {
            System.out.printf("%02d:%02d\n", ans / 60, ans % 60);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋在排序陣列中尋找下一個時間點，時間複雜度為 O(log n)。
 */