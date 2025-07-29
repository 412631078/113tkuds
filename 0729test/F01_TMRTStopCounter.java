import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }
        String start = sc.next();
        String end = sc.next();

        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) idx1 = i;
            if (stops[i].equals(end)) idx2 = i;
        }

        if (idx1 == -1 || idx2 == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(idx1 - idx2) + 1);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：需線性掃描陣列以尋找起訖站的索引，因此時間複雜度為 O(n)。
 */