import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] names = new String[n];
        int[] sales = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            names[i] = parts[0];
            sales[i] = Integer.parseInt(parts[1]);
        }

        for (int i = 1; i < n; i++) {
            String tempName = names[i];
            int tempSale = sales[i];
            int j = i - 1;
            while (j >= 0 && sales[j] < tempSale) {
                sales[j + 1] = sales[j];
                names[j + 1] = names[j];
                j--;
            }
            sales[j + 1] = tempSale;
            names[j + 1] = tempName;
        }

        for (int i = 0; i < Math.min(10, n); i++) {
            System.out.println(names[i] + " " + sales[i]);
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：使用插入排序法進行排序，最壞情況為 O(n^2)。
 */