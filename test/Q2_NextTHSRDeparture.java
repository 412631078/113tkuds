import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(":");
            times[i] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }

        String[] queryParts = sc.nextLine().split(":");
        int query = Integer.parseInt(queryParts[0]) * 60 + Integer.parseInt(queryParts[1]);

        int idx = Arrays.binarySearch(times, query + 1);
        if (idx < 0) idx = -idx - 1;

        if (idx >= n) {
            System.out.println("No train");
        } else {
            int h = times[idx] / 60;
            int m = times[idx] % 60;
            System.out.printf("%02d:%02d\n", h, m);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋找第一個大於查詢時間的位置。
 */