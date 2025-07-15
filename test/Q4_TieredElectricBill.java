import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            int bill = calc(kWh);
            total += bill;
            System.out.println("Bill: $" + bill);
        }

        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }

    static int calc(int kWh) {
        int[] limits = {120, 210, 170, 200, 300, Integer.MAX_VALUE};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};

        int bill = 0, used = 0;
        for (int i = 0; i < limits.length; i++) {
            int consume = Math.min(limits[i], kWh - used);
            if (consume <= 0) break;
            bill += Math.round(consume * rates[i]);
            used += consume;
        }
        return bill;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆資料計算一次費用，固定最多分段 6 次。
 */